package org.ne.file;

import org.ne.model.IpInfo;
import org.ne.model.IpPool;

/**
 * Network Exchanger 2.0<br>
 * Resource File Manager.
 * 
 * @author Ballad
 * @version 1.0
 * @since NES(NetExchangerSource) 2.0
 */
public class ResFileManager {

	/** Network Exchanger RESources(NERES) file's name */
	private String resFileName = "neres.ini";

	/**
	 * Parser the IP setting information from resource file.<br>
	 * If the parserIpPool method throws an Exception, it means the resource
	 * file is broken.
	 */
	public IpPool readResource() throws Exception {
		FileInputer fi = new FileInputer();
		fi.init(resFileName);
		String[] allres = fi.readAll();
		fi.close();

		String[] arr;
		IpInfo ipInfo;
		IpPool ipPool = new IpPool();

		for (int i = 0; i < allres.length; i++) {
			arr = allres[i].split(",");
			ipInfo = new IpInfo();
			ipInfo.setName(arr[0]);
			ipInfo.setLinkName(arr[1]);
			ipInfo.setIpAddr(arr[2]);
			ipInfo.setSubnetMask(arr[3]);
			ipInfo.setDefaultGateway(arr[4]);
			ipInfo.setDnsAddr1(arr[5]);
			ipInfo.setDnsAddr2(arr[6]);

			ipPool.add(arr[0], ipInfo);
		}
		return ipPool;
	}

	public void saveResFile() {

	}
}
