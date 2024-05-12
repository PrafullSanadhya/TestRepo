package TestScenarios;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;

	@BeforeClass
	public void setup() throws IOException {

		FileReader fr = new FileReader("C:\\Users\\sanad\\New WorkSpace\\PageObjectModel\\config.properties");
		Properties prop = new Properties();
		prop.load(fr);
		String browser = prop.getProperty("browser");
		String url = prop.getProperty("url");

		if (browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(url);
		} else if (browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get(url);
		} else {
			System.out.println("Provided Browser is not supported");
		}

	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
		if (ITestResult.FAILURE == result.getStatus()) {
			File screenshotfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotfile,
					new File("C:\\Users\\sanad\\New WorkSpace\\PageObjectModel\\screenshot\\failedTC.png"));
		}
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
