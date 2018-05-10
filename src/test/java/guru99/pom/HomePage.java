package guru99.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	private WebDriver driver;

	@FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[3]/td")
	private WebElement managerId;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getManagerId() {
		return managerId.getText();
	}
	
	public NavigationMenu getNavigationMenu(){
		return new NavigationMenu(driver);
	
	}
}
