package com.excel.reader;

import java.util.ArrayList;

public class GetDataFromExcel {

	static Xls_Reader reader;

	public static ArrayList<Object[]> GetTestDataFrom_Excel() {

		ArrayList<Object[]> mydata = new ArrayList<Object[]>();
		try {

			reader = new Xls_Reader("./src/main/java/com/testdata/TestData_Contacts.xlsx");
		} catch (Exception e) {
			// TODO: handle exception
		}

		for (int rowNum = 2; rowNum <= reader.getRowCount("NewContact"); rowNum++) {
			String Title = reader.getCellData("NewContact", "Title", rowNum);
			String Firstname = reader.getCellData("NewContact", "F_Name", rowNum);
			String LastName = reader.getCellData("NewContact", "L_Name", rowNum);
			String Address_T = reader.getCellData("NewContact", "Address_T", rowNum);
			String Address = reader.getCellData("NewContact", "Full_Address", rowNum);
			String City = reader.getCellData("NewContact", "City", rowNum);
			String State = reader.getCellData("NewContact", "State", rowNum);
			String PinCode = reader.getCellData("NewContact", "PinCode", rowNum);
			String Phone = reader.getCellData("NewContact", "Phone", rowNum);

			Object ab[] = { Title, Firstname, LastName, Address_T, Address, City, State, PinCode, Phone };
			mydata.add(ab);

		}
		return mydata;
	}
}
