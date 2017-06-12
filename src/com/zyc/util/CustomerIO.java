package com.zyc.util;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import com.zyc.entity.Customer;

public class CustomerIO {
	public static void main(String[] args) {
		CustomerIO customerIO = new CustomerIO();
		customerIO.save(new Customer("asdfasdfasdf","asdfasdfasdfasdf"));
		
	}
	public void save(Customer customer){
		try {
			System.out.println(System.getProperty("java.class.path"));
			File file = new File(this.getClass().getClassLoader().getResourceAsStream("customer.zyc").toString());
			if(!file.exists()){
				file.mkdirs();
			}
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file));
			BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
			System.out.println(bufferedWriter);
			bufferedWriter.write("aslkdjghaslkdjghalskdjhg");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
