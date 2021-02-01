package com.crm.qa.testcases;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.BaseClass;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.CreateContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;
import com.excel.reader.GetDataFromExcel;

public class CreateAContactPage extends BaseClass {

	public LoginPage loginpage;
	public HomePage homepage;
	public ContactsPage contactpage;
	public TestUtil testutil;
	public CreateContactPage createContact;

	public CreateAContactPage() {
		super();

	}

	@BeforeMethod
	public void setup() {
		testutil = new TestUtil();
		initialize_driver();
		loginpage = new LoginPage();
		homepage = new HomePage();
		contactpage = new ContactsPage();
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		testutil.SwitchtoFrame();
		contactpage = homepage.click_contacts_link();
		createContact = contactpage.ClickOnCreateContact();

	}

	@DataProvider
	public Iterator<Object[]> GetTestData() {
		ArrayList<Object[]> testdata = GetDataFromExcel.GetTestDataFrom_Excel();
		return testdata.iterator();
	}

	@Test(dataProvider = "GetTestData")
	public void CreateAContact(String Title, String Firstname, String LastName, String Address_T, String Address,
			String City, String State, String PinCode, String Phone) {
		createContact.Select_Title_DropDown(Title);
		createContact.EnterFirstName(Firstname);
		createContact.LastName(LastName);
		createContact.EnterAddress_Title(Address_T);
		createContact.Enter_Addrress(Address);
		createContact.EnterCity(City);
		createContact.EnterState(State);
		createContact.EnterPincode(PinCode);
		createContact.EnterPhone(Phone);
		createContact.SaveThe_Contact();

	}

	@AfterMethod
	public void tearDown() {
		//createContact.Logout();
		driver.quit();
		
	}
}
