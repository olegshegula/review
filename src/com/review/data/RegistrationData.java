package com.review.data;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;

import au.com.bytecode.opencsv.CSVReader;

public class RegistrationData {
	private String login;
	private String email;
	private String password;
	
	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	@DataProvider (name= "loginCSVData")
	public static Object[][] getCSVData() throws IOException {
		
		CSVReader csvReader = new CSVReader(new FileReader(RegistrationData.class.getResource("regdata.csv").getPath()));
		
		List<String[]>dataList = csvReader.readAll();
		Object[][] data = new Object[dataList.size()][1];
		List<RegistrationData> regList = new ArrayList<RegistrationData>();
		
		for (String[] strArray:dataList){
			RegistrationData registrationData = new RegistrationData();
			registrationData.setLogin(strArray[0].trim());
			registrationData.setLogin(strArray[1].trim());
			registrationData.setPassword(strArray[2].trim());
			regList.add(registrationData);
			
		}
		
		for(int i=0; i<data.length;i++){
			
			for(int j=0; j<data[i].length;j++){
				data[i][j]=regList.get(i);
			}			
		}
	csvReader.close();
	return data;
	}
}
