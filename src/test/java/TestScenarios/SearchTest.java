package TestScenarios;
import org.testng.Assert;
import org.testng.annotations.Test;
import Objects.flipkartPartSearch;
import Objects.xlsheetDataProvider;

public class SearchTest extends BaseClass {
	
	
	//@Test(dataProviderClass=xlsheetDataProvider.class,dataProvider="xldata")
	@Test
	public void flipkartSearch() {
		flipkartPartSearch obj = new flipkartPartSearch(driver);
		obj.partSearch("iPhone 15 Pro (White Titanium, 128 GB)");
		String searchProduct = obj.getfirstProduct();
		Assert.assertEquals("Apple iPhone 15 Pro (White Titanium, 128 GB)", searchProduct);
	}
	
	@Test(priority=2)  
	public void applyFilter() {
		flipkartPartSearch obj = new flipkartPartSearch(driver);
		obj.applyFilter();
	}  
	
} 
