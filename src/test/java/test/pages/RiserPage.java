package test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RiserPage {
	
	@FindBy(xpath = "//*[@id=\'view-constituents\']/div[2]/table/tbody/*[1]/*[1]")
	private WebElement topRiser;

	public void waitForRiser(WebDriver driver) {
		WebElement waitForRiser = (new WebDriverWait(driver, 2)).until(ExpectedConditions.
				presenceOfElementLocated(By.id("view-constituents")));
	}

	public String getRiserText() {
		return topRiser.getText();
	}

}
