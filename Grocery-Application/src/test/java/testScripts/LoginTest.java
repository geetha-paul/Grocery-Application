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

		login.loginByUsingExcelData();
		boolean isHomePageLoaded = login.isHomePageLoaded();

		Assert.assertTrue(isHomePageLoaded, Constant.lp_verify_login_with_valid_data);
	}

	@Test

	public void loginWithInvalidUsername() {
		login = new LoginPage(driver);
		login.enterUsername("admin1").enterPassword("admin21").clickSignInButton();// chaining of methods

		boolean alertMessageForInvalidLogin = login.alertMessageForInvalidLogin();
		Assert.assertTrue(alertMessageForInvalidLogin, Constant.lp_invalid_username);
	}

	@Test
	public void loginWithInvalidPassword() {
		LoginPage login = new LoginPage(driver);
		login.enterUsername("admin").enterPassword("admin1").clickSignInButton();

		boolean alertMessageForInvalidPassword = login.alertMessageForInvalidLogin();
		Assert.assertTrue(alertMessageForInvalidPassword, Constant.lp_invalid_password);

	}

	@DataProvider(name = "invalidUserNameAndPassword")
	public Object[][] getData() {
		return new Object[][] { { "test11", "test11" }, { "test2", "test2" } };

	}

	@Test(dataProvider = "invalidUserNameAndPassword")

	public void loginWithInvalidUserNameAndPassword(String username, String password) {

		login = new LoginPage(driver);
		login.enterUsername(username).enterPassword(password).clickSignInButton();

		boolean alertMessageForInvalidUserNameAndPassword = login.alertMessageForInvalidLogin();
		Assert.assertTrue(alertMessageForInvalidUserNameAndPassword, Constant.lp_invalid_username_password);
	}
}
