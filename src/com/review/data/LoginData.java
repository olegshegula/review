package com.review.data;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;




import org.testng.annotations.DataProvider;

import au.com.bytecode.opencsv.CSVReader;

public class LoginData {

	private String login;
	private String password;

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login
	 *            the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	// /////////DataProvider/////////////////////////////

	@DataProvider (name= "loginCSVData")
	public static Object[][] getCSVData() throws IOException {
		
		CSVReader csvReader = new CSVReader(new FileReader(LoginData.class.getResource("logdata.csv").getPath()));
		
		List<String[]>dataList = csvReader.readAll();
		Object[][] data = new Object[dataList.size()][1];
		List<LoginData> loginList = new ArrayList<LoginData>();
		
		for (String[] strArray:dataList){
			LoginData loginData = new LoginData();
			loginData.setLogin(strArray[0].trim());
			loginData.setPassword(strArray[1].trim());
			loginList.add(loginData);
			
		}
		
		for(int i=0; i<data.length;i++){
			
			for(int j=0; j<data[i].length;j++){
				data[i][j]=loginList.get(i);
			}			
		}
	csvReader.close();
	return data;
	}
}
