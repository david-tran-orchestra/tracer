package com.orchestra.tracer.slog.feeder.actions;

import static com.sun.nio.file.ExtendedWatchEventModifier.FILE_TREE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.input.Tailer;
import org.apache.commons.io.input.TailerListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orchestra.tracer.slog.feeder.model.SLogFile;
import com.orchestra.tracer.slog.feeder.model.SLogTailerListener;
import com.orchestra.tracer.slog.feeder.utils.PropertiesUtils;

@Service
public class SLogParserProcessor {

	@Autowired
	private PropertiesUtils env;

	@Autowired
	private SLogsSender sender;

	/**
	 *
	 * @param sLogFile
	 */
	//	@Async
	public void proccessFile(SLogFile sLogFile) {
		TailerListener listener = new SLogTailerListener(sLogFile.getName(), sender);
		Tailer tailer = Tailer.create(sLogFile, listener, 100);
		tailer.run();
		// zipFile(sLogFile);
	}
	
	public String getFileBaseName(File file) {
		return FilenameUtils.getBaseName(file.getName());
	}

	/**
	 *
	 * @return
	 */
	public List<File> processSlogs() {
		String slogPath = env.getProperty("commons.tracer.slog.parser.path");
		File sLogDirectory = new File(slogPath);

		// Tailing existing files
		for(File file : sLogDirectory.listFiles()) {
			SLogFile sLogFile = new SLogFile(file);
			System.out.println("######### TAILING -> " + sLogFile.getPath() + " ##########");
			proccessFile(sLogFile);
		}

		// Tailing new created files
		try {

			FileSystem fs = FileSystems.getDefault();
			WatchService ws = fs.newWatchService();
			sLogDirectory.toPath().register(ws, new WatchEvent.Kind[] {ENTRY_CREATE}, FILE_TREE);
			while(true){
				WatchKey k = ws.take();
				for (WatchEvent<?> watchEvent : k.pollEvents())
				{
					Path newPath = ((WatchEvent<Path>) watchEvent).context();
					File builtFile = new File(sLogDirectory, newPath.toString());
					SLogFile createdsLogFile = new SLogFile(builtFile);
					System.out.println("######### TAILING -> " + createdsLogFile.getPath() + " ##########");
					proccessFile(createdsLogFile);
				}
				k.reset();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return null;
	}


	/**
	 *
	 * @param sLogFile
	 */
	public void zipFile(File sLogFile) {

		ZipOutputStream zos = null;
		FileOutputStream fos = null;

		try {
			fos = new FileOutputStream(sLogFile);
			zos = new ZipOutputStream(fos);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {

				if(fos != null) {
					fos.flush();
					fos.close();
				}

				// let's finish the compression process and free memory
				if(zos != null) {
					zos.flush();
					zos.close();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// the file has to be deleted once it has been compressed
		sLogFile.delete();
	}


}
