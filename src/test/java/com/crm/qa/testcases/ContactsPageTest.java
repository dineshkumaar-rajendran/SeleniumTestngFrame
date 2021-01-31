package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.BaseClass;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends BaseClass {

	HomePage homepage;
	TestUtil testutil;
	ContactsPage contactpage;

	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialize_driver();
		LoginPage loginpage = new LoginPage();
		testutil = new TestUtil();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		testutil.SwitchtoFrame();
		contactpage =homepage.click_contacts_link();
		}

	@Test(priority=1)

	public void verifyContactsLabel() {
		Assert.assertTrue(contactpage.verifylabel(),"Contact Label is missing");

	}
	
	
	@Test
	public void selectAcontact() {
		contactpage.selectContactsByName("amit shah");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	}

	@AfterMethod
	public void tearDown() {
		contactpage.Logout();
		driver.quit();
	}
	
	

}
