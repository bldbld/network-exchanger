package org.ne.manager;

import org.ne.file.FileInputer;
import org.ne.file.FileOutputer;
import org.ne.model.IpInfo;
import org.ne.model.IpPool;
import org.ne.var.GlobalVar;

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
	private static String resFileName = GlobalVar.RES_FILE_NAME;

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
			ipInfo = new IpInfo(arr);
			ipPool.add(arr[0], ipInfo);
		}
		return ipPool;
	}

	public void saveResFile(IpPool ipPool) {
		FileOutputer fo = new FileOutputer();
		fo.init(resFileName);

		IpInfo ipInfo;
		String[] ipNames = ipPool.returnIpInfoNames();
		for (int i = 0; i < ipNames.length; i++) {
			ipInfo = ipPool.get(ipNames[i]);
			fo.write(ipInfo.getResDetail() + GlobalVar.BREAKLINE_WINDOWS);
		}
		fo.close();
	}
}
