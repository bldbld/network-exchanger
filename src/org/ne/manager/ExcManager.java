package org.ne.manager;

import org.ne.file.FileOutputer;
import org.ne.model.IpInfo;
import org.ne.var.GlobalVar;

/**
 * Network Exchanger 2.0<br>
 * Execute Manager.
 * 
 * @author Ballad
 * @version 1.0
 * @since NES(NetExchangerSource) 2.0
 */
public class ExcManager {

	private String ipSetCommand;

	private String dnsSetCommand;

	private String dnsSetCommand2;

	private static String excBatFileName = GlobalVar.EXC_FILE_NAME;

	private FileOutputer fo;

	public void initParam(IpInfo ipinfo) {

		fo = new FileOutputer();
		fo.init(excBatFileName);

		if (ipinfo.getIsIpAuto().equals(GlobalVar.SET_IP_VALUE_AUTO)) {

			ipSetCommand = "netsh interface ip set address \""
					+ ipinfo.getLinkName() + "\" source=dhcp";
		} else {

			if (ipinfo.getDefaultGateway().trim().equals("")) {
				// The IpInfo had not a default gateway, so don't set gateway.
				ipSetCommand = "netsh interface ip set address \""
						+ ipinfo.getLinkName() + "\" static "
						+ ipinfo.getIpAddr() + " " + ipinfo.getSubnetMask();
			} else {
				// The IpInfo had a default gateway, so add the default gateway
				// to command.
				ipSetCommand = "netsh interface ip set address \""
						+ ipinfo.getLinkName() + "\" static "
						+ ipinfo.getIpAddr() + " " + ipinfo.getSubnetMask()
						+ " " + ipinfo.getDefaultGateway() + " 1";
			}
		}

		fo.write(this.ipSetCommand + GlobalVar.BREAKLINE_WINDOWS);

		if (ipinfo.getIsDnsAuto().equals(GlobalVar.SET_DNS_VALUE_AUTO)) {
			// Auto get DNS info.
			dnsSetCommand = "netsh interface ip set dns name = \""
					+ ipinfo.getLinkName() + "\" source=dhcp";

			fo.write(this.dnsSetCommand + GlobalVar.BREAKLINE_WINDOWS);
		} else {
			// Set DNS server info manually.
			dnsSetCommand = "netsh interface ip set dns name = \""
					+ ipinfo.getLinkName() + "\" static "
					+ ipinfo.getDnsAddr1();

			fo.write(this.dnsSetCommand + GlobalVar.BREAKLINE_WINDOWS);

			if (!ipinfo.getDnsAddr2().trim().equals("")) {
				// If DNS server 2 info is inputed.
				dnsSetCommand2 = "netsh interface ip add dns name = \""
						+ ipinfo.getLinkName() + "\" " + ipinfo.getDnsAddr2()
						+ " index=2";
				fo.write(this.dnsSetCommand2 + GlobalVar.BREAKLINE_WINDOWS);
			}
		}

		fo.close();
	}

	public void execCommand() {
		Runtime rt = Runtime.getRuntime();

		try {
			// String cmd = "cmd.exe /C \"" + fo.getFile().getAbsolutePath()+
			// "\"";
			String cmd = "cmd.exe /C " + excBatFileName;
			// TODO 有时用目前这种方法会失效，到底是什么情况呢，也许是错觉，需大量测试啊。
			rt.exec(cmd);

			// System.out.println(cmd);
			fo.removeFile();
		} catch (Exception e) {
			System.out.println("Exception Now");
			e.printStackTrace();
		}

		fo = null;
	}

}