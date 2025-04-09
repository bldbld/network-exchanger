package org.ne.gui;

import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;
import org.ne.process.CoreProcess;

/**
 * The main class of the Network Exchanger application.
 * 
 * @author Ballad
 * @version 1.0
 */
public class MainWindow extends SingleFrameApplication {

	/**
	 * At startup create and show the main frame of the application.
	 */
	@Override
	protected void startup() {
		show(new MainWindowView(this));
	}

	/**
	 * This method is to initialize the specified window by injecting resources.
	 * Windows shown in our application come fully initialized from the GUI
	 * builder, so this additional configuration is not needed.
	 */
	@Override
	protected void configureWindow(java.awt.Window root) {
	}

	/**
	 * A convenient static getter for the application instance.
	 * 
	 * @return the instance of MainWindow
	 */
	public static MainWindow getApplication() {
		return Application.getInstance(MainWindow.class);
	}

	/**
	 * Main method launching the application.
	 */
	public static void main(String[] args) {

		// Initial the CoreProcess.
		CoreProcess process = CoreProcess.getCoreProcess();
		try {
			process.init();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Launch the GUI.
		launch(MainWindow.class, args);
	}
}
