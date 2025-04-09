package org.ne.net;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Network Exchanger 2.0<br>
 * 
 * @author Ballad
 * @version 1.0
 * @since NES(NetExchangerSource) 2.0
 */
public class SystemAdapters {

	/**
	 * The List is used for store Network Adapter's names.
	 */
	private static List<String> adapterList;

	private static String ethernetAdapterName = "Ethernet adapter";

	public SystemAdapters() {
		refresh();
	}

	public void refresh() {
		adapterList = null;
		adapterList = new ArrayList<String>();
		String str = excCommand();
		while (str.contains(ethernetAdapterName)) {
			int start = str.indexOf(ethernetAdapterName);
			int end = str.substring(start, str.length()).indexOf(':') + start;

			// the substring(start, end) is like "Ethernet adapter WIFI"
			// 17 is the length of string "Ethernet adapter "
			String adapterName = str.substring(start + 17, end);
			adapterList.add(adapterName);
			System.out.println (adapterName);
			str = str.substring(end, str.length());
		}
	}

	private String excCommand() {
		String s = null;
		try {
			Runtime rt = Runtime.getRuntime();
			Process p = rt.exec("ipconfig");
			byte[] bytes = new byte[40480];
			p.getInputStream().read(bytes);
			s = new String(bytes);
			System.out.println (s);
		} catch (Exception e) {
			// May the System doesn't support IPCONFIG command.
			e.printStackTrace();
		}
		return s;
	}

	public List<String> getAdapterList() {
		return adapterList;
	}

	public void setAdapterList(List<String> adapterListPara) {
		adapterList = adapterListPara;
	}

	public String[] getAdapterListNames() {
		int size = adapterList.size();
		Iterator<String> iter = adapterList.iterator();

		String[] retStr = new String[size];
		for (int i = 0; i < size; i++) {
			retStr[i] = iter.next();
		}

		return retStr;
	}

	public static void main(String[] args) {
		SystemAdapters sa = new SystemAdapters();
		sa.refresh();
		String[] list = sa.getAdapterListNames();
		for (int i = 0; i < list.length; i++) {
			System.out.println(list[i]);
		}
	}
}
