package org.ne.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Network Exchanger 2.0<br>
 * File Input Support.
 * 
 * @author Ballad
 * @version 1.0
 * @since NES(NetExchangerSource) 2.0
 * @see java.io.BufferedReader
 */
public class FileInputer {
	private File file;
	private BufferedReader br;

	public void init(String fileName) {
		file = new File(fileName);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public String readLine() {
		String ret = null;
		try {
			ret = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ret;
	}

	public String[] readAll() {
		List<String> list = new ArrayList<String>();
		String str = null;
		try {
			while (true) {
				str = br.readLine();
				if (str == null) {
					break;
				}
				list.add(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		int size = list.size();
		String[] ret = new String[size];
		for (int i = 0; i < size; i++) {
			ret[i] = list.get(i);
		}
		return ret;
	}

	public void close() {
		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
