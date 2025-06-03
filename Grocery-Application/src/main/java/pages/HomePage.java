package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class HomePage {

	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//p[text()='Manage Category']")
	WebElement manageCategory;
	@FindBy(xpath = "//p[text()='Manage Contact']")
	WebElement manageContact;
	@FindBy(xpath = "//p[text()='Manage News']")
	WebElement manageNews;

	public CategoryPage clickOnCategory() { 
		manageCategory.click();
		return new CategoryPage(driver);
	}

	public ManageContact clickOnManageContact() {

		GeneralUtilities generalUtilities = new GeneralUtilities(driver);
		generalUtilities.clickJavaScriptExecutor(manageContact, driver);
		return new ManageContact(driver);
	}

	public ManageNewsPage clickOnManageNews() {
		GeneralUtilities generalUtilities = new GeneralUtilities(driver);
		generalUtilities.clickJavaScriptExecutor(manageNews, driver);
		return new ManageNewsPage(driver);
	}
}
