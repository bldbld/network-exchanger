package org.ne.process;

import java.io.File;

/**
 * Network Exchanger<br>
 * 
 * @author Ballad
 * @version 1.0 2011/11/17
 * @since NES 2.0
 */
public class InitProcess {

	/**
	 * Calling this method when the program start up.
	 */
	public void initProgram() {

		initValues();

		if (!isResFileExist()) {
			System.out.println("NO");
		}

		if (!isCfgFileExist()) {

		}

		if (!isExcDirExist()) {

		}
	}

	private void initValues() {
		excDirName = "C:\\Program Files\\Network Exchanger\\";
		cfgFileName = "ne-cfg.ini";
		resFileName = "neres.ini";
	}

	/**
	 * Checkout whether the configuration file exist.
	 */
	private boolean isCfgFileExist() {
		File f = new File(cfgFileName);
		return f.isFile() ? f.exists() : false;
	}

	/**
	 * Checkout whether the resource file exist.
	 */
	private boolean isResFileExist() {
		File f = new File(resFileName);
		return f.isFile() ? f.exists() : false;
	}

	/**
	 * Checkout whether the executable file's directory exist.
	 */
	private boolean isExcDirExist() {
		File f = new File(excDirName);
		return f.isDirectory() ? f.exists() : false;
	}

	private String excDirName;
	private String cfgFileName;
	private String resFileName;

	/**
	 * The main function is for testing.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InitProcess tip = new InitProcess();
		tip.initProgram();
	}
}
