package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class flipkartPartSearch {
	WebDriver driver;
	By searcbox = By.xpath("//input[@title =\"Search for Products, Brands and More\"]");
	By firstproduct = By.xpath("//*[contains(text(),'Apple iPhone 15 Pro')]");
	By filterc = By.xpath("//div[contains(@title,\"4★ & above\")]");
	
	
	public flipkartPartSearch(WebDriver driver) {
		this.driver = driver;
	}
	
	public void partSearch(String partname) {
		driver.findElement(searcbox).sendKeys(partname);
		driver.findElement(searcbox).submit();	
	}
	
	public String getfirstProduct() {
		return driver.findElement(firstproduct).getText();
	}
	
	public void applyFilter() {
		driver.findElement(filterc).click();
	}

	

}
