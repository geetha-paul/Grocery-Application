package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.Constant;
import utilities.FileUploadUtility;
import utilities.GeneralUtilities;

public class CategoryPage {

	public WebDriver driver;
	GeneralUtilities generalUtilities;;

	public CategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		generalUtilities = new GeneralUtilities(driver);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;

	@FindBy(xpath = "//input[@placeholder='Enter the Category']")
	WebElement enterCategory;

	@FindBy(xpath = "//li[@id=\"134-selectable\"]")
	WebElement selectGroup;

	@FindBy(xpath = "//input[@name='main_img']")
	WebElement fileUpload;

	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement saveButton;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement successAlert;
	@FindBy(xpath = "//span[text()='Active']")
	WebElement activeButton;

	@FindBy(xpath = "//i[@class=' fa fa-search']")
	WebElement searchbutton;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")
	WebElement resetButton;

	@FindBy(xpath = "//input[@placeholder='Category']")
	WebElement searchBox;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement categorySearchSubmitButton;

	@FindBy(xpath = "//table[@class=\"table table-bordered table-hover table-sm\"]//tr[1]//td[1]")
	WebElement firstElementInCategorytable;

	@FindBy(xpath = "//a[@class=\"btn btn-default btn-fix\"]")
	WebElement searchResetButton;

	@FindBy(xpath = "//a[@class=\"btn btn-sm btn btn-primary btncss\"]")
	WebElement categoryEdit;

	@FindBy(xpath = "//button[@name=\"update\"]")
	WebElement updateCategoryButton;

	@FindBy(xpath = "//table[@class=\"table table-bordered table-hover table-sm\"]//tr[1]//td[3]")
	WebElement statusColumn;
	@FindBy(xpath = "//a[@class='btn btn-sm btn btn-danger btncss']")
	WebElement deleteButton;

	public CategoryPage clickOnNewButton() {
		newButton.click();
		return this;
	}

	public CategoryPage enterCategory(String enterCategoryValue) {
		enterCategory.sendKeys(enterCategoryValue + generalUtilities.generateCurrentDateAndTime());
		return this;
	}

	public CategoryPage clickOnSelectGroup() {
		selectGroup.click();
		return this;
	}

	public CategoryPage addImageToCategory() {
		FileUploadUtility fileUploadUtility = new FileUploadUtility();
		fileUploadUtility.fileUploadUsingSendKeys(fileUpload, Constant.imageFile);
		return this;
	}

	public CategoryPage scrollToViewSaveButton() {

		generalUtilities.scrollUntilElementIsVisible(saveButton, driver);
		return this;
	}

	public CategoryPage clickOnSaveButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(saveButton));

		generalUtilities.clickJavaScriptExecutor(saveButton, driver);

		return this;
	}

	public CategoryPage searchNewlyAddedCategory() {
		generalUtilities.clickJavaScriptExecutor(searchbutton, driver);
		return this;
	}

	public CategoryPage clickOnSearchBox() {
		searchBox.click();
		return this;
	}

	public CategoryPage enterSearchText() {
		String searchText = firstElementInCategorytable.getText();
		searchBox.sendKeys(searchText);
		return this;
	}

	public CategoryPage clickOnSearchSubmitButton() {
		categorySearchSubmitButton.click();
		return this;
	}

	public CategoryPage resetSearchBox() {

		generalUtilities.clickJavaScriptExecutor(searchResetButton, driver);
		return this;

	}

	public CategoryPage editCategoryItem(String enterCategoryValue) {
		categoryEdit.click();
		enterCategory.clear();
		enterCategory.sendKeys(enterCategoryValue + generalUtilities.generateCurrentDateAndTime());

		generalUtilities.clickJavaScriptExecutor(updateCategoryButton, driver);
		return this;
	}

	public CategoryPage changeTheStatusOfItems() {

		generalUtilities.clickJavaScriptExecutor(activeButton, driver);
		return this;
	}

	public CategoryPage deleteCategory() {
		generalUtilities.clickJavaScriptExecutor(deleteButton, driver);
		generalUtilities.acceptAlert();
		return this;

	}

	public boolean isSuccessAlertDisplayed() {
		return successAlert.isDisplayed();
	}

	public boolean isCategoryPresentInSearchResults() {
		return firstElementInCategorytable.isDisplayed();
	}

	public boolean isSearchAreaReset() {
		return !(searchBox.isDisplayed());
	}

	public boolean isEditSuccessAlertDisplayed() {

		return successAlert.isDisplayed();
	}

	public boolean isStatusChangeAlertDisplayed() {
		return successAlert.isDisplayed();

	}

	public boolean isDeleteSuccessAlertDisplayed() {
		return successAlert.isDisplayed();
	}

}
