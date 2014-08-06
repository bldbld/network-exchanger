package org.ne.file;

/**
 * Network Exchanger 2.0<br>
 * Execute File Manager.
 * 
 * @author Ballad
 * @version 1.0
 * @since NES(NetExchangerSource) 2.0
 */
public class ExcFileManager {

	private String batFileName = "C:\\Program Files\\Network Exchanger\\ne2tmp.bat";

	public void createBatFile(String[] args) {
		FileOutputer fo = new FileOutputer();
		fo.init(batFileName);
		fo.close();
	}

	public void execBatFile() {

	}
}