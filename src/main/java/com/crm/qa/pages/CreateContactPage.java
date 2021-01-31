package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.BaseClass;

public class CreateContactPage extends BaseClass {

	public CreateContactPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//select[@name='title']")
	WebElement Title_DropDown;

	@FindBy(xpath = "//input[@name='first_name']")
	WebElement Enter_Firstname;

	@FindBy(xpath = "//input[@name='surname']")
	WebElement Enter_Lastname;

	@FindBy(xpath = "//input[@name='address_title']")
	WebElement Enter_Address_title;

	@FindBy(xpath = "//textarea[@name='address']")
	WebElement Enter_Full_Address;

	@FindBy(xpath = "//input[@name='city']")
	WebElement Enter_City;

	@FindBy(xpath = "//input[@name='state']")
	WebElement Enter_State;

	@FindBy(xpath = "//input[@name='postcode']")
	WebElement Enter_Postcode;

	@FindBy(xpath = "//input[@name='country']")
	WebElement Enter_Country;

	@FindBy(xpath = "//select[@name='category']")
	WebElement Select_Category;

	@FindBy(xpath = "//select[@name='status']")
	WebElement Select_Status;

	@FindBy(xpath = "//input[@name='phone']")
	WebElement Enter_Phone;

	@FindBy(xpath = "(//input[@value='Load From Company'])/following-sibling::input[1]")
	WebElement Save_button;

	@FindBy(xpath = "(//a[@class='topnavlink'])[3]")
	WebElement Logout_btn;

	public void Logout() {
		Logout_btn.click();
	}

	public String GetCreatePageContact_Title() {
		return driver.getTitle();
	}

	public void Select_Title_DropDown(String Title) {
		Select select = new Select(Title_DropDown);
		select.selectByValue(Title);
	}

	public void EnterFirstName(String FirstName) {
		Enter_Firstname.sendKeys(FirstName);
	}

	public void LastName(String LastName) {
		Enter_Lastname.sendKeys(LastName);
	}

	public void EnterAddress_Title(String Address_Title) {
		Enter_Address_title.sendKeys(Address_Title);
	}

	public void Enter_Addrress(String FullAddress) {
		Enter_Full_Address.sendKeys(FullAddress);
	}

	public void EnterCity(String CityName) {
		Enter_City.sendKeys(CityName);
	}

	public void EnterState(String StateName) {
		Enter_State.sendKeys(StateName);
	}

	public void EnterPincode(String Pincode) {
		Enter_Postcode.sendKeys(Pincode);
	}

	public void Select_Category() {
		Select select = new Select(Select_Category);
	}

	public void EnterPhone(String Phone) {
		Enter_Phone.sendKeys(Phone);
	}

	public void SaveThe_Contact() {
		Save_button.click();
	}

}
