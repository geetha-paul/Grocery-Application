	package testScripts;
	
	import java.io.IOException;
	
	import org.testng.Assert;
	import org.testng.annotations.Test;
	
	import automationCore.BaseClass;
	import pages.CategoryPage;
	import pages.HomePage;
	import pages.LoginPage;
	
	public class CategoryTest extends BaseClass {
	
		LoginPage loginpage;
		HomePage homepage;
		CategoryPage category;
	
		@Test(priority = 1)
		public void verifyAddNewCategoryWithValidDetails() throws IOException {
			loginpage = new LoginPage(driver);
	
			homepage = loginpage.loginByUsingExcelData();
			category = homepage.clickOnCategory()
					.clickOnNewButton()
					.enterCategory("Hair Accesories for kids")
					.clickOnSelectGroup()
					.addImageToCategory()
					.scrollToViewSaveButton()
					.clickOnSaveButton(); // chaining of methods
																												
			Assert.assertTrue(category.isSuccessAlertDisplayed(), "Test failed: Success message is not displayed.");
		}
	
		@Test(priority = 2)
	
		public void verifySearchCategoryWithValidKeyword() throws IOException {
			loginpage = new LoginPage(driver);
			homepage = loginpage.loginByUsingExcelData();
			category = homepage.clickOnCategory().searchNewlyAddedCategory().clickOnSearchBox().enterSearchText()
					.clickOnSearchSubmitButton();
	
			/*
			 * homepage.clickOnCategory(); CategoryPage category = new CategoryPage(driver);
			 * category.searchNewlyAddedCategory(); category.clickOnSearchBox();
			 * category.enterSearchText(); category.clickOnSearchSubmitButton();
			 */
			 Assert.assertTrue(category.isCategoryPresentInSearchResults(), "Test failed: Category not found in search results.");
		}
	
		@Test(priority = 3)
	
		public void verifyResetSearchFunctionality() throws IOException {
			loginpage = new LoginPage(driver);
			homepage = loginpage.loginByUsingExcelData();
			// HomePage homepage = new HomePage(driver);//
			category = homepage.clickOnCategory().searchNewlyAddedCategory().clickOnSearchBox().enterSearchText()
					.clickOnSearchSubmitButton().resetSearchBox();
			/*
			 * CategoryPage category = new CategoryPage(driver);
			 * category.searchNewlyAddedCategory(); category.clickOnSearchBox();
			 * category.enterSearchText(); category.clickOnSearchSubmitButton();
			 * category.resetSearchBox();
			 */
			 Assert.assertTrue(category.isSearchAreaReset(), "Test failed: Search area was not reset or still visible.");
	
		}
	
		@Test(priority = 4)
	
		public void verifyEditCategoryWithValidDetails() throws IOException {
			loginpage = new LoginPage(driver);
			homepage = loginpage.loginByUsingExcelData();
			// HomePage homepage = new HomePage(driver);
			category = homepage.clickOnCategory().editCategoryItem("Hair clips for kids");
			// CategoryPage category = new CategoryPage(driver);
			// category.editCategoryItem("Hair clips for kids");
			  Assert.assertTrue(category.isEditSuccessAlertDisplayed(), "Test failed: Success message is not displayed after editing the category.");
		}
	
		@Test(priority = 5)
	
		public void verifyChangeCategoryStatusSuccessfully() throws IOException {
			loginpage = new LoginPage(driver);
			homepage = loginpage.loginByUsingExcelData();
			// HomePage homepage = new HomePage(driver);
			category = homepage.clickOnCategory().changeTheStatusOfItems();
			// CategoryPage category = new CategoryPage(driver);
	
			// category.changeTheStatusOfItems();
			 Assert.assertTrue(category.isStatusChangeAlertDisplayed(),
			            "Test failed: Status badge did not toggle correctly between Active and Inactive.");
		}
		
		@Test(priority = 6)
	
		public void verifyDeleteCategoryItemSuccessfully() throws IOException {
			loginpage = new LoginPage(driver);
			homepage = loginpage.loginByUsingExcelData();
			category = homepage.clickOnCategory().deleteCategory();
			Assert.assertTrue(category.isDeleteSuccessAlertDisplayed(), "Test failed: Category was not deleted successfully.");
	}
	}
