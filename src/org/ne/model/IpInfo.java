package org.ne.model;

/**
 * Network Exchanger 2.0 <br>
 * Storage of IP Plan Information.
 * 
 * @author Ballad
 * @version 1.0
 * @since NES(NetExchangerSource) 2.0
 */
public class IpInfo {
	/** Scheme's name */
	private String name;
	/** Adapter's name */
	private String linkName;

	private String ipAddr;
	private String subnetMask;
	private String defaultGateway;
	private String dnsAddr1;
	private String dnsAddr2;

	/**
	 * @see GlobalVar
	 */
	private String isIpAuto;

	/**
	 * @see GlobalVar
	 */
	private String isDnsAuto;

	public IpInfo() {
	}

	public IpInfo(String name, String linkName, String ipAddr,
			String subnetMask, String defaultGateway, String dnsAddr1,
			String dnsAddr2, String isIpAuto, String isDnsAuto) {
		this.name = name;
		this.linkName = linkName;
		this.ipAddr = ipAddr;
		this.subnetMask = subnetMask;
		this.defaultGateway = defaultGateway;
		this.dnsAddr1 = dnsAddr1;
		this.dnsAddr2 = dnsAddr2;
		this.isIpAuto = isIpAuto;
		this.isDnsAuto = isDnsAuto;
	}

	/**
	 * Need 9 String Elements in args.
	 * 
	 * @param args
	 */
	public IpInfo(String[] args) {
		this.name = args[0];
		this.linkName = args[1];
		this.ipAddr = args[2];
		this.subnetMask = args[3];
		this.defaultGateway = args[4];
		this.dnsAddr1 = args[5];
		this.dnsAddr2 = args[6];
		this.isIpAuto = args[7];
		this.isDnsAuto = args[8];
	}

	public String[] getDetail() {
		String[] ret = new String[9];
		ret[0] = this.name;
		ret[1] = this.linkName;
		ret[2] = this.ipAddr;
		ret[3] = this.subnetMask;
		ret[4] = this.defaultGateway;
		ret[5] = this.dnsAddr1;
		ret[6] = this.dnsAddr2;
		ret[7] = this.isIpAuto;
		ret[8] = this.isDnsAuto;
		return ret;
	}

	public String getResDetail() {
		String str = this.name + "," + this.linkName + "," + this.ipAddr + ","
				+ this.subnetMask + "," + this.defaultGateway + ","
				+ this.dnsAddr1 + "," + this.dnsAddr2 + "," + this.isIpAuto
				+ "," + this.isDnsAuto;
		return str;
	}

	public String getName() {
		return name;
	}

	public String getLinkName() {
		return linkName;
	}

	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}

	public String getIpAddr() {
		return ipAddr;
	}

	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}

	public String getSubnetMask() {
		return subnetMask;
	}

	public void setSubnetMask(String subnetMask) {
		this.subnetMask = subnetMask;
	}

	public String getDefaultGateway() {
		return defaultGateway;
	}

	public void setDefaultGateway(String defaultGateway) {
		this.defaultGateway = defaultGateway;
	}

	public String getDnsAddr1() {
		return dnsAddr1;
	}

	public void setDnsAddr1(String dnsAddr1) {
		this.dnsAddr1 = dnsAddr1;
	}

	public String getDnsAddr2() {
		return dnsAddr2;
	}

	public void setDnsAddr2(String dnsAddr2) {
		this.dnsAddr2 = dnsAddr2;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIsDnsAuto() {
		return isDnsAuto;
	}

	public void setIsDnsAuto(String isDnsAuto) {
		this.isDnsAuto = isDnsAuto;
	}

	public String getIsIpAuto() {
		return isIpAuto;
	}

	public void setIsIpAuto(String isIpAuto) {
		this.isIpAuto = isIpAuto;
	}
}
