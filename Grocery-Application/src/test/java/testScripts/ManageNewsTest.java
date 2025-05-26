package testScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import automationCore.BaseClass;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;

public class ManageNewsTest extends BaseClass{
	LoginPage loginpage;
	HomePage homepage;
	ManageNewsPage news;
  @Test(priority = 1)
  public void verifyEnteringNewsInformation() throws IOException {
	  loginpage = new LoginPage(driver);
		homepage = loginpage.loginByUsingExcelData();
		news= homepage.clickOnManageNews().clickOnNewButton().enterNewsInformation("Website under construction").clickOnSaveButton();
  }
  @Test(priority = 2)
  public void verifyUpdatingNewsInformation() throws IOException {
	  loginpage = new LoginPage(driver);
		homepage = loginpage.loginByUsingExcelData();
		news= homepage.clickOnManageNews().clickOnEditButton().upgateNews("Website will be available soon");
  }
  @Test(priority = 3)
  public void verifyNewsDeletionFunctionality() throws IOException {
	  loginpage = new LoginPage(driver);
		homepage = loginpage.loginByUsingExcelData();
		news= homepage.clickOnManageNews().deleteNews();
  }
}
