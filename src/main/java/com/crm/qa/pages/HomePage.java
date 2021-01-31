package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.BaseClass;

public class HomePage extends BaseClass {

	@FindBy(xpath = "//td[contains(text(),'User: Demo User')]")
	WebElement userNameLablel;

	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement ContactsLink;

	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement DealsLink;

	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement TasksLink;
	
	@FindBy(xpath = "(//a[@class='topnavlink'])[3]")
	WebElement Logout_btn;

	public void Logout() {
		Logout_btn.click();
	}

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String Verify_homepage_title() {
		return driver.getTitle();

	}

	public ContactsPage click_contacts_link() {
		ContactsLink.click();
		return new ContactsPage();
	}

	public DealsPage click_deals_link() {
		DealsLink.click();
		return new DealsPage();
	}

	public TaskPage click_task_link() {
		DealsLink.click();
		return new TaskPage();
	}

	public boolean VerifyUserName() {
		return userNameLablel.isDisplayed();
	}

}
