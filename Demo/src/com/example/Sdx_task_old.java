package com.example;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Sdx_task_old {

	public WebDriver driver = null;
	String baseurl = "https://beta.sdxcentral.com/?staging_key=FGCewLU";

	@Parameters({ "browsername" })
	@BeforeClass
	public void setup(String browsername) throws Exception {
		// Check if parameter passed from TestNG is 'firefox'
		if (browsername.equalsIgnoreCase("Firefox")) {
			// create firefox instance
			System.setProperty("webdriver.gecko.driver", "test-data/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		// Check if parameter passed as 'chrome'
		else if (browsername.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "test-data/chromedriver75.exe");
			driver = new ChromeDriver();
		}

		driver.get(baseurl);
	}

	/*
	 * @BeforeMethod public void verifyHomepageTitle() { String expectedTitle =
	 * "Welcome: Mercury Tours"; String actualTitle = driver.getTitle();
	 * Assert.assertEquals(actualTitle, expectedTitle);
	 */
	@Test
	public void Verify_opinion_section() {
		try {
			String exp_label = "Opinion / Latest";
			String actual_label = driver.findElement(By.xpath("//*[@id=\'home-opinion\']/header/h2")).getText();
			System.out.println(actual_label);
			Assert.assertEquals(actual_label, exp_label);
			WebElement Show_all = driver.findElement(By.xpath("//*[@id=\'home-opinion\']/header/a"));
			Assert.assertEquals(true, Show_all.isDisplayed());
			System.out.println("The displayed element is:" + Show_all.getText());

			List<WebElement> allElements = driver.findElements(By.xpath("//*[@id='home-opinion']//*[@class='home__post-block']"));
			int s = allElements.size();
			System.out.println(allElements.size());
			/*
			 * for(int i=1;i<=s;i++){ allElements =
			 * driver.findElements(By.xpath("//*[@id=\'home-opinion\']/div"));
			 * allElements.get(i); }
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@AfterClass
	public void terminateBrowser() {
		driver.close();

	}

}