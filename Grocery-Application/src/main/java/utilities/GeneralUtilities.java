package utilities;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class GeneralUtilities {

	public WebDriver driver;

	public GeneralUtilities(WebDriver driver) {
		this.driver = driver;
	}

	// Single-select dropdown - Select by value
	public String selectDropdownWithValue(WebElement element, String value) {
		Select object = new Select(element);
		object.selectByValue(value);
		WebElement selectedElement = object.getFirstSelectedOption();
		return selectedElement.getText();
	}

	// Single-select dropdown - Select by visible text
	public String selectDropdownWithVisibleText(WebElement element, String visibleText) {
		Select object = new Select(element);
		object.selectByVisibleText(visibleText);
		WebElement selectedElement = object.getFirstSelectedOption();
		return selectedElement.getText();
	}

	// Single-select dropdown - Select by index
	public String selectDropdownWithIndex(WebElement element, int index) {
		Select object = new Select(element);
		object.selectByIndex(index);
		WebElement selectedElement = object.getFirstSelectedOption();
		return selectedElement.getText();
	}

	// JavaScriptExecutor to click
	public void clickJavaScriptExecutor(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}

	// javaScript Executer to scroll down the page

	public void scrollDownThePageJavaScriptExecutor(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	// javaScriptExecuter to scroll down to a visible element

	public void scrollUntilElementIsVisible(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	// Alert Handling Utility
	public void acceptAlert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();

	}

	// Radio Button Selection
	public void selectRadioButton(WebElement radioButton) {
		if (!radioButton.isSelected()) {
			radioButton.click();
		}

	}

	// Drag and Drop Utility
	public void dragAndDrop(WebElement source, WebElement target) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(source, target).build().perform();

	}

	// to generate current date and time
	public String generateCurrentDateAndTime() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyhhmmss");
		return formatter.format(date);
	}

}
