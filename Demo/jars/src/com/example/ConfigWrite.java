package com.example;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Properties;

public class ConfigWrite {
	public static void main(String[] args) throws Exception {
		Properties properties = new Properties();
		properties.setProperty("favoriteAnimal", "Dog");
		properties.setProperty("favoriteContinent", "Asia");
		properties.setProperty("favoritePerson", "Shipra");

		File file = new File("test2.properties");
		FileOutputStream fileOut = new FileOutputStream(file);
		properties.store(fileOut, "Favorite Things");
		System.out.println("File Written");
		fileOut.close();
		
	}

}
