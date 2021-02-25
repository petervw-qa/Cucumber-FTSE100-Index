package test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {
	
	@FindBy(xpath = "//*[@id=\"view-constituents\"]/ul/li[2]/a")
	private WebElement risersLink;
	@FindBy(xpath = "//*[@id=\"view-constituents\"]/ul/li[3]/a")
	private WebElement fallersLink;
	
	@FindBy(xpath = "//*[@id=\'acceptCookie\']")
	private WebElement cookie;

	public LandingPage(WebDriver driver) {
		super();
	}
	
	public void navigateToRiser() {
		risersLink.click();
	}
	
	public void navigateToFaller() {
		fallersLink.click();
	}
	
	public void getRidOfCookie() {
		cookie.click();
	}
	
	public void waitForLoad(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.jsReturnsValue("return document.readyState==\"complete\";"));
	}
	

}
