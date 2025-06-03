package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.BaseClass;
import constants.Constant;
import pages.CategoryPage;
import pages.HomePage;
import pages.LoginPage;

public class CategoryTest extends BaseClass {

	LoginPage loginpage;
	HomePage homepage;
	CategoryPage category;
	public String categoryName = "Hair Accesories for kids";
	public String updatedCategoryName = "Hair clips for kids";

	@Test(priority = 1, groups = { "smoke" })
	public void verifyAddNewCategoryWithValidDetails() throws IOException {
		loginpage = new LoginPage(driver);

		homepage = loginpage.loginByUsingExcelData();
		category = homepage.clickOnCategory().clickOnNewButton().enterCategory(categoryName).clickOnSelectGroup()
				.addImageToCategory().scrollToViewSaveButton().clickOnSaveButton(); // chaining of
																					// methods

		Assert.assertTrue(category.isSuccessAlertDisplayed(), Constant.category_success_alert);
	}

	@Test(priority = 2)

	public void verifySearchCategoryWithValidKeyword() throws IOException {
		loginpage = new LoginPage(driver);
		homepage = loginpage.loginByUsingExcelData();
		category = homepage.clickOnCategory().searchNewlyAddedCategory().clickOnSearchBox().enterSearchText()
				.clickOnSearchSubmitButton();

		Assert.assertTrue(category.isCategoryPresentInSearchResults(), Constant.category_not_found);
	}

	@Test(priority = 3)

	public void verifyResetSearchFunctionality() throws IOException {
		loginpage = new LoginPage(driver);
		homepage = loginpage.loginByUsingExcelData();

		category = homepage.clickOnCategory().searchNewlyAddedCategory().clickOnSearchBox().enterSearchText()
				.clickOnSearchSubmitButton().resetSearchBox();

		Assert.assertTrue(category.isSearchAreaReset(), Constant.search_area_not_reset);

	}

	@Test(priority = 4, groups = { "smoke" })

	public void verifyEditCategoryWithValidDetails() throws IOException {
		loginpage = new LoginPage(driver);
		homepage = loginpage.loginByUsingExcelData();

		category = homepage.clickOnCategory().editCategoryItem(updatedCategoryName);

		Assert.assertTrue(category.isEditSuccessAlertDisplayed(), Constant.category_edit_success);
	}

	@Test(priority = 5)

	public void verifyChangeCategoryStatusSuccessfully() throws IOException {
		loginpage = new LoginPage(driver);
		homepage = loginpage.loginByUsingExcelData();

		category = homepage.clickOnCategory().changeTheStatusOfItems();

		Assert.assertTrue(category.isStatusChangeAlertDisplayed(), Constant.status_toggle_failed);
	}

	@Test(priority = 6, groups = { "smoke" })

	public void verifyDeleteCategoryItemSuccessfully() throws IOException {
		loginpage = new LoginPage(driver);
		homepage = loginpage.loginByUsingExcelData();
		category = homepage.clickOnCategory().deleteCategory();
		Assert.assertTrue(category.isDeleteSuccessAlertDisplayed(), Constant.delete_success_alert);
	}
}
