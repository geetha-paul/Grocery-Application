package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelUtililty;

public class LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='username']")
	WebElement usernameField;
	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordField;
	@FindBy(xpath = "//button[@type=\"submit\"]")
	WebElement signInButton;
	@FindBy(xpath = "//span[text()='7rmart supermarket']")
	WebElement homePage;
	@FindBy(xpath = "//div[@class=\"alert alert-danger alert-dismissible\"]")
	WebElement errorMessageForInvalidCredentials;

	public LoginPage enterUsername(String username) {
		usernameField.sendKeys(username);
		return this;
	}

	public LoginPage enterPassword(String password) {
		passwordField.sendKeys(password);
		return this;
	}

	public HomePage clickSignInButton() { // chaining of pages
		signInButton.click();
		return new HomePage(driver);
	}

	public boolean isHomePageLoaded() {
		return homePage.isDisplayed();

	}

	public boolean alertMessageForInvalidLogin() {
		return errorMessageForInvalidCredentials.isDisplayed();
	}

	public HomePage loginByUsingExcelData() throws IOException {
		String username = ExcelUtililty.getStringData(1, 0, "loginPage");
		String password = ExcelUtililty.getStringData(1, 1, "loginPage");
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		signInButton.click();
		return new HomePage(driver);
	}
}
