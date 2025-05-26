package testScripts;

import java.io.IOException;
import utilities.FakerUtility;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.BaseClass;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageContact;

public class ManageContactTest extends BaseClass {
	LoginPage loginpage;
	HomePage homepage;
	ManageContact manageContact;
  @Test(priority = 1)
  public void verifyMandatoryFieldsValidationInEditContact() throws IOException {
	  loginpage =  new LoginPage(driver);
	  homepage=loginpage.loginByUsingExcelData();
	  //HomePage homepage = new HomePage(driver);
	  manageContact = homepage.clickOnManageContact().clickOnEditButton().mandatoryFieldsCheck();
	  
	  
  }
  @Test(priority = 2)
  
  public void verifyEditContactWithValidDetails() throws IOException {
	  loginpage =  new LoginPage(driver);
	  homepage=loginpage.loginByUsingExcelData();
	  String phone = FakerUtility.generatePhoneNumber();
      String email = FakerUtility.generateEmail();
      String address = FakerUtility.generateAddress();
      String deliveryTime = FakerUtility.generateDeliveryTime();
      String deliveryLimit = FakerUtility.generateDeliveryLimit();

      manageContact = homepage.clickOnManageContact()
                              .clickOnEditButton()
                              .editFormFields(phone, email, address, deliveryTime, deliveryLimit);
	  Assert.assertTrue(manageContact.isEditSuccessAlertDisplayed(), "Test failed: Success message is not displayed after editing the contact.");
}
  
  @Test(priority = 3)
	  public void verifyResetEditContactFormFunctionality()throws IOException {
		  loginpage =  new LoginPage(driver);
		  homepage=loginpage.loginByUsingExcelData();
		  manageContact = homepage.clickOnManageContact()
                  .clickOnEditButton().resetContact();
		  Assert.assertTrue(manageContact.isContactTitleDisplayed(), "Test failed: Contact form is not resetted");
	  }
}
