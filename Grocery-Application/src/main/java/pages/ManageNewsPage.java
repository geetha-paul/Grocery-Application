package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageNewsPage {

	public WebDriver driver;
	GeneralUtilities generalutility;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		generalutility = new GeneralUtilities(driver); 
	}
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;
	@FindBy(xpath="//textarea[@id='news']")
	WebElement enterNewsInformations;
	@FindBy(xpath="//button[@type='submit']")
	WebElement saveButton;
	@FindBy(xpath="//a[@class='btn btn-sm btn btn-primary btncss']")
	WebElement editButton;
	@FindBy(xpath="//button[@name='update']")
	WebElement updateButton;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	WebElement searchButton;
	
	@FindBy(xpath="//a[@class='btn btn-sm btn btn-danger btncss']")
	WebElement deleteButton;
	
	
	
	public ManageNewsPage clickOnNewButton() {
		
		generalutility.clickJavaScriptExecutor(newButton, driver);
		return this;
	}
	public ManageNewsPage enterNewsInformation(String news) {
		enterNewsInformations.sendKeys(news);
		return this;
	}
	public ManageNewsPage clickOnSaveButton() {
		
		generalutility.clickJavaScriptExecutor(saveButton, driver);
		return this;
	}
	
	public ManageNewsPage clickOnEditButton() {
		
		generalutility.clickJavaScriptExecutor(editButton, driver);
		return this;
	}
	public ManageNewsPage upgateNews(String updatedNews) {
		
		generalutility.clickJavaScriptExecutor(enterNewsInformations, driver);
		enterNewsInformations.clear();
		enterNewsInformations.sendKeys(updatedNews);
		updateButton.click();
		return this;
	}
	public ManageNewsPage deleteNews() {

		deleteButton.click();
		generalutility.acceptAlert();
		return this;
	}
}
