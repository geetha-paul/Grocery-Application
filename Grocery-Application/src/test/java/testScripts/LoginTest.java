package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationCore.BaseClass;
import constants.Constant;
import pages.LoginPage;

public class LoginTest extends BaseClass {

	LoginPage login;

	@Test(groups = "smoke")
	public void loginWithValidCredentials() throws IOException {
		LoginPage login = new LoginPage(driver);
		/*
		 * login.enterUsername("admin"); login.enterPassword("admin");
		 * login.clickSignInButton();
		 */
		login.loginByUsingExcelData();
		boolean isHomePageLoaded = login.isHomePageLoaded();

		Assert.assertTrue(isHomePageLoaded, Constant.lp_verifyLoginWithValidData);
	}

	@Test

	public void loginWithInvalidUsername() {
		login = new LoginPage(driver);
		login.enterUsername("admin1").enterPassword("admin21").clickSignInButton();
		// login.enterPassword("admin21");
		// login.clickSignInButton();
		boolean alertMessageForInvalidLogin = login.alertMessageForInvalidLogin();
		Assert.assertTrue(alertMessageForInvalidLogin, "Login successful for invalid username");
	}

	@Test
	public void loginWithInvalidPassword() {
		LoginPage login = new LoginPage(driver);
		login.enterUsername("admin");
		login.enterPassword("admin1");
		login.clickSignInButton();

		boolean alertMessageForInvalidPassword = login.alertMessageForInvalidLogin();
		Assert.assertTrue(alertMessageForInvalidPassword, "Login successful for invalild password");

	}

	@DataProvider(name = "invalidUserNameAndPassword")
	public Object[][] getData() {
		return new Object[][] { { "test11", "test11" }, { "test2", "test2" } };

	}

	@Test(dataProvider = "invalidUserNameAndPassword")

	public void loginWithInvalidUserNameAndPassword(String username, String password) {

		login = new LoginPage(driver);
		login.enterUsername(username).enterPassword(password).clickSignInButton();
		// login.enterPassword(password);
		// login.clickSignInButton();
		boolean alertMessageForInvalidUserNameAndPassword = login.alertMessageForInvalidLogin();
		Assert.assertTrue(alertMessageForInvalidUserNameAndPassword,
				"Login successful for invalild username and password");
	}
}
