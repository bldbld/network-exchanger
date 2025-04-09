package org.ne.process;

import org.ne.file.ExcFileManager;
import org.ne.file.ResFileManager;
import org.ne.model.IpInfo;
import org.ne.model.IpPool;
import org.ne.net.SystemNetwork;

/**
 * Network Exchanger 2.0<br>
 * Execute the Core Process of Network Exchanger.<br>
 * 执行Network Exchange的核心处理流程。
 * 
 * @author Ballad
 * @version 1.0
 * @since NES 2.0
 */
public class CoreProcess {
	private ExcFileManager efm;
	private ResFileManager rfm;
	private IpPool ipPool;
	private SystemNetwork sn;

	public CoreProcess() {
		efm = new ExcFileManager();
		rfm = new ResFileManager();
		ipPool = new IpPool();
		sn = new SystemNetwork();
	}

	public void init() throws Exception {
		ipPool = rfm.readResource();
	}

	public void create(String[] args) {
		IpInfo ipinfo = new IpInfo(args);
		ipPool.add(args[0], ipinfo);
	}

	public void update(String[] args) {
		IpInfo ipinfo = new IpInfo(args);
		ipPool.update(args[0], ipinfo);
	}

	public void delete(String name) {
		ipPool.del(name);
	}

	public void load(String name) {
		String[] args = get(name);
		efm.createBatFile(args);
		efm.execBatFile();
	}

	public String[] get(String name) {
		IpInfo ipinfo = ipPool.get(name);
		return ipinfo.getDetail();
	}

	public void close() {
		rfm.saveResFile();
	}
}
