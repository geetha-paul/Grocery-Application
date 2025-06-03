package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class HomePage {

	public WebDriver driver;
	GeneralUtilities generalUtilities;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		generalUtilities = new GeneralUtilities(driver);
	}

	@FindBy(xpath = "//p[text()='Manage Category']")
	WebElement manageCategory;
	@FindBy(xpath = "//p[text()='Manage Contact']")
	WebElement manageContact;
	@FindBy(xpath = "//p[text()='Manage News']")
	WebElement manageNews;

	public CategoryPage clickOnCategory() {
		generalUtilities.clickJavaScriptExecutor(manageCategory, driver);

		return new CategoryPage(driver);
	}

	public ManageContact clickOnManageContact() {

		generalUtilities.clickJavaScriptExecutor(manageContact, driver);
		return new ManageContact(driver);
	}

	public ManageNewsPage clickOnManageNews() {

		generalUtilities.clickJavaScriptExecutor(manageNews, driver);
		return new ManageNewsPage(driver);
	}
}
