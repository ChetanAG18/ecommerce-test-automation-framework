package com.ui.dataproviders;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.google.gson.Gson;
import com.ui.pojo.TestData;
import com.ui.pojo.User;

public class LoginDataProvider {
	
	@DataProvider(name = "LoginDataProvider", parallel = true)
	public Iterator<Object[]> loginDataProvider() {
		Gson gson = new Gson();		
		File file = new File(System.getProperty("user.dir") + "/testData/logindata.json");
		FileReader fr = null;
		try {
			fr = new FileReader(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}		
		TestData testdata = gson.fromJson(fr, TestData.class);
		
		List<Object[]> dataToReturn = new ArrayList<Object[]>();
		for (User user : testdata.getData()) {
			dataToReturn.add(new Object [] {user});
		}
		
		return dataToReturn.iterator();
	}
}
