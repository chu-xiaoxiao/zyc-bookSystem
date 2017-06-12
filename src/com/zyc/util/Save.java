package com.zyc.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.Set;

import com.zyc.entity.Customer;

public class Save {
	public static void main(String[] args) {
		try {
			new Save().saveUsername(new Customer());
			new Save().readUsername();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void saveUsername(Customer customer) throws IOException {
		String filename = getClass().getResource("/").getFile().toString() + "user.properties";
		File file = new File(filename);
		FileWriter filewriter = new FileWriter(filename,true);
		if (!file.exists()) {
			file.createNewFile();
			System.out.println("创建文件" + filename);
		}
		filewriter.write(customer.getCustomerName()+"="+customer.getCustomerPassword()+"\r\n");
		filewriter.close();
	}

	public void saveUsernameNoPassword(Customer customer) throws IOException {
		String filename = getClass().getResource("/").getFile().toString() + "user.properties";
		File file = new File(filename);
		FileWriter filewriter = new FileWriter(filename,true);
		if (!file.exists()) {
			file.createNewFile();
			System.out.println("创建文件" + filename);
		}
		filewriter.write(customer.getCustomerName()+"="+""+"\r\n");
		filewriter.close();
	}

	public Set<Object> readUsername() throws IOException {
		String filename = getClass().getResource("/").getFile().toString() + "user.properties";
		File file = new File(filename);
		if (!file.exists()) {
			file.createNewFile();
			System.out.println("资源文件不存在");
			System.out.println("创建文件" + filename);
			return null;
		}
		Properties properties = new Properties();
		properties.load(new FileInputStream(file));
		return properties.keySet();
	}

	public Object readPassword(String userName) throws FileNotFoundException, IOException {
		String filename = getClass().getResource("/").getFile().toString() + "user.properties";
		File file = new File(filename);
		if (!file.exists()) {
			System.out.println("资源文件不存在");
		}
		Properties properties = new Properties();
		properties.load(new FileInputStream(file));
		return properties.get(userName);
	}
}
