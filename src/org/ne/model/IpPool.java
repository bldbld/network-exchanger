package org.ne.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Network Exchanger 2.0 <br>
 * Storage of IP Information(IpInfo).
 * 
 * @author Ballad
 * @version 1.0
 * @since NES(NetExchangerSource) 2.0
 * @see IpInfo
 */
public class IpPool {

	/**
	 * The map is used for mapping the IpInfo's name and IpInfo.
	 */
	private Map<String, IpInfo> ipinfos;

	public IpPool() {
		ipinfos = new HashMap<String, IpInfo>();
	}

	public Map<String, IpInfo> map() {
		return ipinfos;
	}

	public boolean add(String name, IpInfo ipinfo) {
		boolean ret = false;
		if (ipinfos.containsKey(name)) {
			ret = false;
		} else {
			ipinfos.put(ipinfo.getName(), ipinfo);
			ret = true;
		}
		return ret;
	}

	public void del(String name) {
		ipinfos.remove(name);
	}

	public void update(String name, IpInfo ipinfo) {
		ipinfos.put(ipinfo.getName(), ipinfo);
	}

	public IpInfo get(String name) {
		return ipinfos.get(name);
	}

	public String[] returnIpInfoNames() {
		int size = ipinfos.size();
		String[] retStr = new String[size];
		for (int i = 0; i < size; i++) {
			retStr[i] = ipinfos.get(i).getName();
		}
		return retStr;
	}
}
