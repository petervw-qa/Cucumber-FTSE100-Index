package test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FallerPage {
	
	@FindBy(xpath = "//*[@id=\'view-constituents\']/div[2]/table/tbody/*[1]/*[1]")
	private WebElement topFaller;

	public FallerPage(WebDriver driver) {
		super();
		}
	
	public void waitForFaller(WebDriver driver) {
		WebElement waitForFaller = (new WebDriverWait(driver, 2)).until(ExpectedConditions
						.presenceOfElementLocated(By.id("view-constituents")));
	}
	
	public String getFallerText() {
		return topFaller.getText();
	}

}
