package com.example;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Flight {

	public WebDriver driver = null;
	//String geckoPath = System.getProperty("user.dir") + "/test-data/geckodriver.exe";
	String appUrl = "http://www.newtours.demoaut.com/";
	//String chromePath = System.getProperty("user.dir") + "/test-data/chromedriver.exe";
	
	@BeforeClass
	@Parameters("browser")
	public void setup(String sBrowser) throws Exception{
		System.out.println(sBrowser);
		System.out.println("-----------------------------");
		//Check if parameter passed from TestNG is 'firefox'
		if(sBrowser.equalsIgnoreCase("Firefox")){
		//create firefox instance
			System.setProperty("webdriver.gecko.driver", "./test-data/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		//Check if parameter passed as 'chrome'
		else if(sBrowser.equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver", "./test-data/chromedriver.exe");
			driver = new ChromeDriver();
	    }
		
		driver.get(appUrl);
	}
	
	/*
	 * @Test(priority=0) public void check()throws Exception { driver.get(appUrl); }
	 * 
	 * @Test(priority=1) public void checkTitle() { driver.getTitle();
	 * 
	 * }
	 */
	@BeforeMethod
	public void verifyHomepageTitle() { 
		String expectedTitle = "Welcome: Mercury Tours";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle); 
	}

	@Test(groups ="regression")
	public void register(){

		driver.findElement(By.linkText("REGISTER")).click() ;
		String expectedoutput ="Register: Mercury Tours";
		String actualoutput= driver.getTitle();
		Assert.assertEquals(actualoutput, expectedoutput); }

	@Test (groups ="sanity")
	public void support() {
		driver.findElement(By.linkText("SUPPORT")).click() ;
		String expected ="Under Construction: Mercury Tours";
		String actual = driver.getTitle();
		Assert.assertEquals(actual, expected); 
	}

	@AfterMethod 
	public void goBackToHomepage ( ) {
		driver.findElement(By.linkText("Home")).click() ; }

	@AfterClass
	public void terminateBrowser(){
		driver.close();

	}

}



