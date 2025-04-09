package org.ne.process;

import org.ne.manager.ExcManager;
import org.ne.manager.ResFileManager;
import org.ne.model.IpPool;
import org.ne.net.SystemAdapters;
import org.ne.net.SystemNetwork;

/**
 * Network Exchanger 2.0<br>
 * The Basic Process for Network Exchanger<br>
 * 
 * @author Ballad
 * @version 1.0
 * @since NES 2.0
 */
public abstract class BasicProcess {

	protected ExcManager efm;

	protected ResFileManager rfm;

	protected IpPool ipPool;

	protected SystemNetwork sn;

	protected SystemAdapters sa;

	/**
	 * Constructor.
	 */
	protected BasicProcess() {
		efm = new ExcManager();
		rfm = new ResFileManager();
		ipPool = new IpPool();
		sn = new SystemNetwork();
		sa = new SystemAdapters();
	}

}
