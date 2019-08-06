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
	
	
	@Parameters({"browsername"})
	@BeforeClass
	public void setup(String browsername) throws Exception{
		System.out.println(browsername);
		System.out.println("-----------------------------");
		//Check if parameter passed from TestNG is 'firefox'
		if(browsername.equalsIgnoreCase("Firefox")){
		//create firefox instance
			System.out.println("f1");
			System.setProperty("webdriver.gecko.driver", "test-data/geckodriver.exe");
			//DesiredCapabilities dc = new DesiredCapabilities();
			//dc.setCapability("marionatte", false);
			//FirefoxOptions opt = new FirefoxOptions();
			//opt.merge(dc);
			driver =  new FirefoxDriver();
			System.out.println("f2");
		}
		//Check if parameter passed as 'chrome'
		else if(browsername.equalsIgnoreCase("Chrome")){
			System.out.println("c1");
			System.setProperty("webdriver.chrome.driver", "test-data/chromedriver75.exe");
			driver = new ChromeDriver();
			System.out.println("c2");
	    }
		
		driver.get(appUrl);
		System.out.println("get");
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

	
	  @Test(groups ="regression") public void register(){
	  
	  driver.findElement(By.linkText("REGISTER")).click() ; String expectedoutput
	  ="Register: Mercury Tours"; String actualoutput= driver.getTitle();
	  Assert.assertEquals(actualoutput, expectedoutput); }
	  
	  @Test (groups ="sanity") public void support() {
	  driver.findElement(By.linkText("SUPPORT")).click() ; String expected
	  ="Under Construction: Mercury Tours"; String actual = driver.getTitle();
	  Assert.assertEquals(actual, expected); }
	 

	@AfterMethod 
	public void goBackToHomepage ( ) {
		driver.findElement(By.linkText("Home")).click() ; }

	@AfterClass
	public void terminateBrowser(){
		driver.close();

	}

}

/*cmd
 * ant -version
 * cd "E:\my selenium project\practice_new"
 * E:
 
ant -find build.xml
ant -build build.xml
*/
