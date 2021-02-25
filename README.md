# Cucumber-FTSE100-Index
An automated selenium test converted into a Cucumber (Gherkin) test navigating the Hargreaves Lansdown webpage; 
displaying both the highest riser and lowest faller for the passive FTSE100 fund.

### The `.feature` file outlining both scenarios

```
Feature: To check the highest rise and lowest faller on the FTSE100 index displayed on Hargreaves Lansdown

  Scenario: Get Highest Riser
    Given that I can navigate to HL
    When I click on the Risers link
    And I find the highest table entry
    Then I can display it

  Scenario: Get Lowest Faller
		Given that I can navigate to HL
    When I click on the Fallers link
    And I find the highest table entry
    Then I can display it

```

### Implementing the Page Object Model 
In order to organise the tests and make them easy to call in the step definitions class, we use the page object model to easily call upon and use page elements.
The below can be found in the `LandingPage.java` class.

```
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
  
```

### The Cuke Step Defintions
This is where we define the test for each step created using the framework created in the `.feature` file.

#####Examples 
```
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

(etc)
```

### The Cuke Runner
This is the class that will run the tests defined in the step definitions class, outlined using the `.feature` file.

```
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/cuke",
				glue = "test.cuke.stepdefs",
				stepNotifications = true)
public class CukeRunner {

}

```
