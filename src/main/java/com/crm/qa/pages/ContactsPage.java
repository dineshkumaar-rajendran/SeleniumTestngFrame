package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.BaseClass;

public class ContactsPage extends BaseClass {

	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	WebElement ContactsNameLabel;

	@FindBy(xpath = "//input[@value='New Contact']")
	WebElement Create_contact_button;
	
	@FindBy(xpath = "(//a[@class='topnavlink'])[3]")
	WebElement Logout_btn;

	public void Logout() {
		Logout_btn.click();
	}

	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	public Boolean verifylabel() {

		return ContactsNameLabel.isDisplayed();
	}

	public void selectContactsByName(String name) {
		driver.findElement(By.xpath("//a[text()='" + name + "']//parent::td[@class='datalistrow']"
				+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}

	public CreateContactPage ClickOnCreateContact() {

		Create_contact_button.click();
		return new CreateContactPage();
	}

}
