package com.crm.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.BaseClass;

public class LoginPage extends BaseClass {

	// page factory of login page

	@FindBy(name = "username")
	WebElement Username;

	@FindBy(name = "password")
	WebElement Password;

	@FindBy(xpath = "//*[@value='Login']")
	WebElement Login_butn;

	@FindBy(xpath = "//*[text()='Sign Up']")
	WebElement Signup_btn;

	/*@FindBy(xpath = "//*[text()='Forgot your password?']")
	WebElement forgot_password;*/
	
	@FindBy(xpath = "(//a[@class='topnavlink'])[3]")
	WebElement Logout_btn;

	public void Logout() {
		Logout_btn.click();
	}

	// initializing the page object
	public LoginPage() {
		PageFactory.initElements(driver, this); // this refers to current class object
	}

	public String Validate_loginpage_title() {
		return driver.getTitle();
	}

	public HomePage login(String username, String password) {
		Username.sendKeys(username);
		Password.sendKeys(password);
		Login_butn.click();
		
		return new HomePage();
		
	}

}
