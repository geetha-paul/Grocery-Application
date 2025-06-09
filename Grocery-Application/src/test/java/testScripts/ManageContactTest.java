package testScripts;

import java.io.IOException;
import utilities.FakerUtility;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.BaseClass;
import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageContact;

public class ManageContactTest extends BaseClass {
	LoginPage loginpage;
	HomePage homepage;
	ManageContact manageContact;

	@Test(priority = 1)

	public void verifyEditContactWithValidDetails() throws IOException {
		loginpage = new LoginPage(driver);
		homepage = loginpage.loginByUsingExcelDataForValidLogin();
		String phone = FakerUtility.generatePhoneNumber();
		String email = FakerUtility.generateEmail();
		String address = FakerUtility.generateAddress();
		String deliveryTime = FakerUtility.generateDeliveryTime();
		String deliveryLimit = FakerUtility.generateDeliveryLimit();

		manageContact = homepage.clickOnManageContact().clickOnEditButton().editFormFields(phone, email, address,
				deliveryTime, deliveryLimit);
		Assert.assertTrue(manageContact.isEditSuccessAlertDisplayed(), Constant.mc_edit_success_alert);
	}

	@Test(priority = 2)
	public void verifyResetEditContactFormFunctionality() throws IOException {
		loginpage = new LoginPage(driver);
		homepage = loginpage.loginByUsingExcelDataForValidLogin();
		manageContact = homepage.clickOnManageContact().clickOnEditButton().resetContact();
		Assert.assertTrue(manageContact.isContactTitleDisplayed(), Constant.mc_contact_title_displayed);
	}
}
