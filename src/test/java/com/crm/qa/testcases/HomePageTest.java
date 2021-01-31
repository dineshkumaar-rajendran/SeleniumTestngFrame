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

public class HomePageTest extends BaseClass {

	HomePage homepage;
	TestUtil testutil;
	ContactsPage contactpage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialize_driver();
		LoginPage loginpage = new LoginPage();
		testutil = new TestUtil();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		

	}

	@Test(priority = 1)
	public void VerifyHomePageTitle() {
		String title = homepage.Verify_homepage_title();
		Assert.assertEquals(title, "CRMPRO", "Home Page title not matched");
	}

	@Test(priority = 2)
	public void VerifyUserNameinTheHomePage() {
		testutil.SwitchtoFrame();
		Assert.assertTrue(homepage.VerifyUserName());

	}

	@Test
	public void VerifyContactLinkTest() {
		testutil.SwitchtoFrame();
		contactpage = homepage.click_contacts_link();
	}

	@AfterMethod
	public void tearDown() {
		homepage.Logout();
		driver.quit();
	}
}
