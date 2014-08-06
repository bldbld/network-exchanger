package org.ne.manager;

import org.ne.file.FileOutputer;

/**
 * Network Exchanger 2.0<br>
 * Execute File Manager.
 * 
 * @author Ballad
 * @version 1.0
 * @since NES(NetExchangerSource) 2.0
 */
public class ExcFileManager {

	private final static String batFileName = "C:\\Program Files\\Network Exchanger\\NeExcMgrFile\\ne2tmp.bat";

	public void createBatFile(String[] args) {
		FileOutputer fo = new FileOutputer();
		fo.init(batFileName);
		fo.close();
	}

	public void execBatFile() {
		Runtime rt = Runtime.getRuntime();

		String excFileName = "cmd.exe /C " + batFileName;
		try {
			// Process p = rt.exec(excFileName);
			rt.exec(excFileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}