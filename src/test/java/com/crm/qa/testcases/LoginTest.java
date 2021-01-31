package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.BaseClass;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginTest extends BaseClass {

	LoginPage login_page;
	HomePage homepage;

	public LoginTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialize_driver();
		login_page = new LoginPage();

	}

	@Test(priority = 1)
	public void login_page_Test() {
		String actual = login_page.Validate_loginpage_title();
		Assert.assertEquals(actual, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}

	@Test(priority = 2)
	public void login_to_App() {
		login_page.login(prop.getProperty("username"), prop.getProperty("password"));
		String pagetitle = driver.getTitle();
		Assert.assertEquals(pagetitle, "CRMPRO", "Login Page title not matched");
	}

	@AfterMethod
	public void tear_down() {
		login_page.Logout();
		driver.quit();
	}

}
