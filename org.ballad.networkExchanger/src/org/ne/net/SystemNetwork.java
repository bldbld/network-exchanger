package org.ne.net;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Network Exchanger 2.0<br>
 * This Class is used for getting System IP information and offering some method
 * for checking the IP address.
 * 
 * @author Ballad
 * @version 1.0
 * @since NES(NetExchangerSource) 2.0
 */
public class SystemNetwork {
	/**
	 * The Map is used for store the mapping between Network Adapter's name and
	 * it's detail information.
	 */
	private Map<String, NetworkInterface> map;

	public SystemNetwork() {
		map = new HashMap<String, NetworkInterface>();
		refresh();
	}

	public Map<String, NetworkInterface> getMap() {
		return map;
	}

	/**
	 * Refresh and get the new system network information.
	 */
	public void refresh() {
		map.clear();
		try {
			Enumeration<NetworkInterface> nis = null;
			NetworkInterface n = null;
			nis = NetworkInterface.getNetworkInterfaces();
			while (nis.hasMoreElements()) {
				n = nis.nextElement();
				if (!n.getInetAddresses().toString().equals("127.0.0.1")) {
					map.put(n.getName(), n);
				}
			}
			n = null;
			nis = null;
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}

	public String[] returnSysNetAdapterNames() {
		int size = map.size();
		Iterator<String> iter = map.keySet().iterator();

		String[] retStr = new String[size];
		for (int i = 0; i < size; i++) {
			retStr[i] = iter.next();
		}

		return retStr;
	}

	public boolean checkIp(String desIp, String niName) {
		boolean ret = false;
		NetworkInterface n = map.get(niName);
		if (n != null) {
			if (n.getInetAddresses().toString().equals(desIp)) {
				ret = true;
			}
		}
		return ret;
	}

	/**
	 * This method is not completed, so just involve it for testing.
	 */
	public boolean checkIpLoop(String desIp, String niName, int maxLoop) {
		boolean ret = false;
		int i = 0;
		int max = maxLoop;
		while (true) {
			if ((ret = checkIp(desIp, niName)) == true) {
				break;
			}
			if (i >= max) {
				break;
			}
		}
		return ret;
	}
	
	public static void main(String[] args) {
		try {
			Enumeration<NetworkInterface> nis = null;
			NetworkInterface n = null;
			nis = NetworkInterface.getNetworkInterfaces();
			while (nis.hasMoreElements()) {
				n = nis.nextElement();
				System.out.println (n.getDisplayName());
			}
			n = null;
			nis = null;
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}
}
