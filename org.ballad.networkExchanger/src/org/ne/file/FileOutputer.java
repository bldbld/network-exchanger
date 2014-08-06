package org.ne.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Network Exchanger 2.0<br>
 * File Output Support.
 * 
 * @author Ballad
 * @version 1.0
 * @since NES(NetExchangerSource) 2.0
 * @see java.io.FileWriter
 */
public class FileOutputer {
	private File file;
	private FileWriter fw;

	public void init(String fname) {
		file = new File(fname);
		try {
			file.createNewFile();
			fw = new FileWriter(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void write(String str) {
		try {
			fw.write(str);
			fw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void removeFile (){
		file.deleteOnExit();
	}

	public File getFile() {
		return file;
	}
}
