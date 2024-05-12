package Objects;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonProductSearch {
	WebDriver driver;

	
	public AmazonProductSearch(WebDriver driver) {
		this.driver= driver;
	}
	
	
	By searchBox = By.xpath("//input[@type='text']");
	By signin = By.xpath("//a[@id=\"nav-link-accountList\"]");
	
	public void SignIn() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(200));
		wait.until(ExpectedConditions.elementToBeClickable(signin));
		driver.findElement(signin).click();
	}
	
	
	
	public void SearchForProduct(String productName){
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(200));
		wait.until(ExpectedConditions.elementToBeClickable(searchBox));
		driver.findElement(searchBox).sendKeys(productName);
		driver.findElement(searchBox).sendKeys(Keys.RETURN);
		
	}

}
