package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageContact {

	public WebDriver driver;
	GeneralUtilities generalutility = new GeneralUtilities(driver);

	public ManageContact(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@role='button']")
	WebElement editContact;
	@FindBy(xpath = "//input[@name='phone']")
	WebElement phoneNumberField;
	@FindBy(xpath = "//input[@name='email']")
	WebElement emailField;
	@FindBy(xpath = "//textarea[@name='address']")
	WebElement addressField;
	@FindBy(xpath = "//textarea[@name='del_time']")
	WebElement deliveryTimeField;
	@FindBy(xpath = "//input[@name='del_limit']")
	WebElement deliveryChargeLimitField;
	@FindBy(xpath = "//button[@name='Update']")
	WebElement updateButton;
	@FindBy(xpath = "//a[text()='Reset']")
	WebElement resetButton;
	@FindBy(xpath="//h4[text()='Contact Us']") 
	WebElement contactTitle;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement successAlert;

	public ManageContact clickOnEditButton() {
		
		generalutility.clickJavaScriptExecutor(editContact, driver);
		return this;
	}

	public ManageContact mandatoryFieldsCheck() {
		phoneNumberField.clear();

		emailField.clear();

		addressField.clear();

		deliveryTimeField.clear();

		deliveryChargeLimitField.clear();
		
		generalutility.clickJavaScriptExecutor(updateButton, driver);

		return this;
	}

	public ManageContact editFormFields(String phoneNumber, String email, String address, String delTime,
		String delLimit) {
		phoneNumberField.clear();
		phoneNumberField.sendKeys(phoneNumber);
		emailField.clear();
		emailField.sendKeys(email);
		addressField.clear();
		addressField.sendKeys(address);
		deliveryTimeField.clear();
		deliveryTimeField.sendKeys(delTime);
		deliveryChargeLimitField.clear();
		deliveryChargeLimitField.sendKeys(delLimit);
		generalutility.clickJavaScriptExecutor(updateButton, driver);
		return this;
	} 
	public ManageContact resetContact() {
		generalutility.clickJavaScriptExecutor(resetButton, driver);
		return this;
	}
	public boolean isEditSuccessAlertDisplayed() {
	    
        return successAlert.isDisplayed();
}
	public boolean isContactTitleDisplayed() {
	    
        return contactTitle.isDisplayed();
}
}
