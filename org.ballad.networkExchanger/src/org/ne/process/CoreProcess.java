package org.ne.process;

import org.ne.model.IpInfo;

/**
 * Network Exchanger 2.0<br>
 * Execute the Core Process of Network Exchanger.<br>
 * 
 * @author Ballad
 * @version 1.0
 * @since NES 2.0
 */
public class CoreProcess extends BasicProcess {

	/**
	 * The singleton CoreProcess instance.
	 */
	private static CoreProcess coreProcess = null;

	/**
	 * Private Constructor.
	 */
	private CoreProcess() {
		super();
	}

	/**
	 * Call this method to get the CoreProcess instance.
	 * 
	 * @return CoreProcess's instance
	 */
	public static synchronized CoreProcess getCoreProcess() {
		if (coreProcess == null) {
			coreProcess = new CoreProcess();
		}
		return coreProcess;
	}

	/**
	 * Initiation of the program.
	 * 
	 * @throws Exception
	 */
	public void init() throws Exception {
		ipPool = rfm.readResource();
	}

	/**
	 * Create new Network Plan.
	 * 
	 * @param args
	 */
	public boolean create(String[] args) {
		IpInfo ipinfo = new IpInfo(args);
		return ipPool.add(args[0], ipinfo);
	}

	/**
	 * Update an existing Network Plan.
	 * 
	 * @param args
	 */
	public void update(String[] args) {
		IpInfo ipinfo = new IpInfo(args);
		ipPool.update(args[0], ipinfo);
	}

	/**
	 * Delete a Network Plan.
	 * 
	 * @param name
	 */
	public void delete(String name) {
		ipPool.del(name);
	}

	/**
	 * Load a Network Plan.
	 * 
	 * @param name
	 */
	public void load(String name) {
		efm.initParam(this.ipPool.get(name));
		efm.execCommand();
	}

	/**
	 * Get a Plan's info by it's name.
	 * 
	 * @param name
	 * @return
	 */
	public String[] getIpinfoByName(String name) {
		IpInfo ipinfo = ipPool.get(name);
		return ipinfo.getDetail();
	}

	/**
	 * Do something like saving when the program is closing or updating.
	 */
	public void saveConfig() {
		rfm.saveResFile(ipPool);
	}

	/**
	 * Get all IP Plan's name list for display in main window or other use.
	 * 
	 * @return
	 */
	public String[] getIpInfoNames() {
		return ipPool.returnIpInfoNames();
	}

	/**
	 * Get all System's Adapters name list.
	 * 
	 * @return
	 */
	public String[] getSysAdapterNames() {
		return sa.getAdapterListNames();
	}

	/**
	 * Refresh the System Adatpers's list.
	 */
	public void refreshSysAdapter() {
		sa.refresh();
	}

}
