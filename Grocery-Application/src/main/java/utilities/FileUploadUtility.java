package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;


import org.openqa.selenium.WebElement;


//using sendKeys method and robot class
public class FileUploadUtility {

	 // Method to upload file using sendKeys (only works if input[type=file] is accessible)
	
	   public void fileUploadUsingSendKeys(WebElement element, String filePath) {
		   element.sendKeys(filePath);
	    }
	   
	   // Method to upload file using Robot class (for when input[type=file] is not accessible directly)
	   public void uploadUsingRobot(WebElement element, String filePath) throws AWTException {

	        element.click();
	        StringSelection ss = new StringSelection(filePath);
	        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
	        
	        Robot robot = new Robot();
	        robot.delay(500);
	        robot.keyPress(KeyEvent.VK_CONTROL);
	        robot.keyPress(KeyEvent.VK_V);
	        robot.delay(500);
	        robot.keyRelease(KeyEvent.VK_V);
	        robot.keyRelease(KeyEvent.VK_CONTROL);
	        robot.delay(500);
	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.keyRelease(KeyEvent.VK_ENTER);
	   }
}
