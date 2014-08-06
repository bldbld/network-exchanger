package test;

import java.nio.charset.Charset;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Runtime rt = Runtime.getRuntime();

		String excFileName = "ipconfig";
		try {
			// Process p = rt.exec(excFileName);
			Process p = rt.exec(excFileName);
			byte[] bytes = new byte[1000];
			p.getInputStream().read(bytes);
			String s = new String(bytes);
			System.out.println(s);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
