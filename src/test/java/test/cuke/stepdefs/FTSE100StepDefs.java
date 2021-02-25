package test.cuke.stepdefs;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import test.pages.LandingPage;
import test.pages.RiserPage;

public class FTSE100StepDefs {
	
	private static RemoteWebDriver driver;
	private String high;
	private static LandingPage page;
	private static RiserPage risers;
	
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
		page = PageFactory.initElements(driver, LandingPage.class);
        risers = PageFactory.initElements(driver, RiserPage.class);
	}
	
	@After
    public static void tearDown() {
        driver.quit();
        System.out.println("driver closed");
    }
	
	@Given("that I can navigate to HL")
	public void that_i_can_navigate_to_hl() {
		driver.get("https://www.hl.co.uk/shares/stock-market-summary/ftse-100");
		page.getRidOfCookie();
	}
	
	@When("I click on the Risers link")
	public void i_click_on_the_risers_link() {
	    page.navigateToRiser();
	    System.out.println("LOOKING FOR RISERS");
	}
	
	@When("I click on the Fallers link")
	public void i_click_on_the_fallers_link() {
	    page.navigateToFaller();
	    System.out.println("LOOKING FOR FALLERS");
	}
	
	@When("I find the highest table entry")
	public void i_find_the_highest_table_entry() {
	    page.waitForLoad(driver);
	    high = risers.getRiserText();
	}
	@Then("I can display it")
	public void i_can_display_it() {
	    System.out.println("Highest on Table = " + high);
	}

}
