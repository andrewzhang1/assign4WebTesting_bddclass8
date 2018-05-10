package bmi;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BmiStepDefs {
	private WebDriver driver;
	private BmiPage page;
	
	@Before
	public void setUp() {
		//System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
		System.setProperty("webdriver.chrome.driver", "C:/AGZ1/workspace_java_final1/WebAppTesting/drivers/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@Given("the user is on the BMI Calculate page")
	public void heIsOnBmiPage() {
		//page = new BmiPage(driver);
		page = new BmiPage(driver);
		
	}
	
	// regular expression to find "*":
	@When("he enters \"([^\"]*)\" as height")
	public void heEnetersHeight(String height) {
		page.setHeight(height);
		
	}
	
	@And("he enters \"([^\"]*)\" as weight")
	public void heEntersWeight(String weight) {
		page.setWeight(weight);
	}
	
	@And("he clicks the Calculate button")
	public void heClicksCalculateButton() {
		page.calculate();
	}
	
	@Then("ensure the bmi category is \"([^\"]*)\"")
	public void ensureBmiCategory(String category) {
		assertEquals(category, page.getBmiCategory());
	}
}
