package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.constants.Env;

public class PropertiesUtil {

	public static String getProperty(Env env, String propertName) {
		File file = new File(System.getProperty("user.dir") + "/config/" + env + ".properties");

		FileReader fileReader = null;
		Properties prop = new Properties();
		try {
			fileReader = new FileReader(file);
			prop.load(fileReader);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String value = prop.getProperty(propertName);
		return value;
	}

}
