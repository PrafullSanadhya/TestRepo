package Objects;




import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class googleSearch {
	
	WebDriver driver;
	
	public googleSearch(WebDriver driver) {
		this.driver = driver;
	}
	
	By searchbox= By.xpath("//*[@title='Search']");
	By amazonlink = By.xpath("//*[contains(@href,'https://www.amazon.in/')][1]");
	

	public void searchforSite(String text){
		
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(200));
		wait.until(ExpectedConditions.elementToBeClickable(searchbox));
		driver.findElement(searchbox).sendKeys(text);
        driver.findElement(searchbox).sendKeys(Keys.RETURN);
	}
	
	public void clickOnAmazonlink() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(200));
		wait.until(ExpectedConditions.elementToBeClickable(amazonlink));
		driver.findElement(amazonlink).click();
	}
}
