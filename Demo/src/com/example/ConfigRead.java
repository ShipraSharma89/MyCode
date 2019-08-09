package com.example;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigRead {
	public static void main(String[] args) throws IOException {
		Properties prop= new Properties();
		FileInputStream input= new FileInputStream("D:\\my_project\\practice\\MyConfig.properties");
		prop.load(input);
		System.out.println(prop.getProperty("Browser"));
		System.out.println(prop.getProperty("Name"));
		input.close();

		FileOutputStream output = new FileOutputStream("D:\\my_project\\practice\\MyConfig.properties");
		prop.setProperty("Browser", "Firefox");
		prop.remove("Configured");
		prop.store(output, null);
		System.out.println("Browser:" +prop.getProperty("Browser"));
		output.close();
		
	}
	

}
