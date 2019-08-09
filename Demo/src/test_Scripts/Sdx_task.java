package test_Scripts;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import object_repo.homepage;

public class Sdx_task {
	//--------launch driver----------
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
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		}

		driver.get(baseurl);
	}


	/*
	 * @Test public void alert_handle() { Alert alert = driver.switchTo().alert();
	 * alert.accept(); }
	 */

	/**
	 * Test Description - Verify Following for Opinion Section on homepage.
	 * 1. Label Text is "Opinion / Latest" 2. "Show All" Link Text is displayed Next
	 * to Section Label Text. 3. The section has 2 list items. 4. Every list item
	 * should have Headline, Content Text, Author, Image.
	 */
	@Test
	public void Verify_opinion_section() {
		try {
			int noListItems = 2;
			//String exp_label = "Opinion / Latest";
			//			String actual_label = driver.findElement(By.xpath("//*[@id=\'home-opinion\']/header/h2")).getText();
			String label_opinion_section = new homepage(driver).Opinion_Latest.getText();

			System.out.println(label_opinion_section);
			//Assert.assertEquals(label_opinion_section, exp_label);
			List<WebElement> listitems = new homepage(driver).list_Opinion_Elements;
			int nCount = 0;
			WebElement obj_Header;
			WebElement obj_InnerText;
			WebElement obj_Author;
			WebElement obj_Image;
			for (int i = 0; i < listitems.size(); i++) {
				obj_Header = new homepage(driver).list_Headline_listitems_Opinion_Section.get(i);
				obj_InnerText = new homepage(driver).list_innertext_listitems_Opinion_Section.get(i);
				obj_Author = new homepage(driver).list_author_listitems_Opinion_Section.get(i);
				obj_Image = new homepage(driver).list_image_listitems_Opinion_Section.get(i);
				System.out.println(obj_Header.isDisplayed());
				System.out.println(obj_InnerText.isDisplayed());
				System.out.println(obj_Image.isDisplayed());
				System.out.println(obj_Header.getText());
				System.out.println(obj_InnerText.getText());
				System.out.println(nCount);

				if (obj_Header.isDisplayed() && obj_InnerText.isDisplayed() && (obj_Image.isDisplayed())
						&& (obj_Header.getText().length() > 0) && (obj_InnerText.getText().length() > 0)
						&& (obj_Author.isDisplayed()) && (obj_Author.getText().length() > 0)) {
					nCount = nCount + 1;
				} 
				//				else {
				//					break;
				//				}
			}
			System.out.println(nCount);
			if ((nCount == listitems.size()) && (listitems.size() == noListItems)
					&& new homepage(driver).Opinion_Latest.isDisplayed()
					&& (new homepage(driver).Show_All.isDisplayed())) {
				System.out.println("Validated Opinion Section of the Homepage");
			} else {
				System.out.println(" Opinion Section not validated");
				Assert.fail();
			}
		} catch (Exception e) {
			System.out.println("Exception Occured while Validating Opinion Section " + e.getMessage());
			Assert.fail();
		}

	}	

	/**
	 * Test Description - Verify Following for DemoFridays and Webinars
	 * Section on homepage. 1. Tab Label is "DemoFridays / Webinars" 2. "Show All"
	 * Linktext Is Displayed. 3. The section has 3 list items. 4. Every list item
	 * should have Category, Date, Headline, Content Text, Footer Button.
	 */

	@Test
	public void Homepage_DemoFri_WeB() {
		try {
			int noListItems = 6; 
			int n0DateCount = 0;
			Thread.sleep(1000);
			List<WebElement> listitems = new homepage(driver).list_listitem_DemoFridays_and_Webinars_Section;
			int nCounter = 0;
			WebElement obj_Category;
			WebElement obj_Header;
			WebElement obj_InnerText;
			WebElement obj_Footer;
			WebElement obj_Header_href;

			for (int i = 0; i < listitems.size(); i++) {
				obj_Category = new homepage(driver).list_listitem_Category_DemoFridays_and_Webinars_Section.get(i);
				obj_Header = new homepage(driver).list_listitem_Header_DemoFridays_and_Webinars_Section.get(i);
				obj_Header_href = new homepage(driver).list_listitem_Header_Href_DemoFridays_and_Webinars_Section.get(i);
				obj_InnerText = new homepage(driver).list_listitem_inner_content_text_DemoFridays_and_Webinars_Section
						.get(i);
				obj_Footer = new homepage(driver).list_footer_button_DemoFriday_and_Webinar.get(i);
				if (obj_Category.getText().contains("Webinar")
						|| (obj_Category.getText().equalsIgnoreCase("On-Demand DemoFriday "))
						|| (obj_Category.getText().equalsIgnoreCase("On-Demand Analyst Webinar"))|| (obj_Category.getText().equalsIgnoreCase("\r\n" + 
								"On-Demand Webinar "))) {
					if (obj_Header.isEnabled() && obj_InnerText.isEnabled() && obj_Footer.isEnabled()
							&& (obj_Header.getText().length() > 0) && (obj_InnerText.getText().length() > 0)
							&& (obj_Header_href.getAttribute("href").length() > 12)) {
						nCounter = nCounter + 1;
					} else {
						break;
					}
				} else {
					if (obj_Category.isEnabled() && obj_Header.isEnabled() && obj_InnerText.isEnabled()
							&& obj_Footer.isEnabled() && (obj_Header.getText().length() > 0)
							&& (obj_InnerText.getText().length() > 0) && (obj_Category.getText().length() > 0)
							&& (obj_Header_href.getAttribute("href").length() > 12)) {
						nCounter = nCounter + 1;
						n0DateCount = n0DateCount + 1;
					} else {
						break;
					}
				}
			}
			List<WebElement> objDate = new homepage(driver).list_listitem_Date_DemoFridays_and_Webinars_Section;
			for (WebElement we : objDate) {
				if (we.getText().length() < 1) {
					nCounter = nCounter - 1;
					break;
				}
			}
			if (nCounter == listitems.size() && (listitems.size() >= noListItems)
					&& (new homepage(driver).linktext_show_all_navTab_DemoFriday_and_Webinar.isEnabled())
					&& (objDate.size() == n0DateCount)) {
				System.out.println("Validated DemoFridays and Webinars Section");
			} else {
				System.out.println("Could Not Validate DemoFridays and Webinars Section");
				Assert.fail();
			}
		} catch (Exception e) {
			System.out.println("Exception Occured while Validating DemoFridays and Webinars Section " + e.getMessage());
			Assert.fail();
		}
	}
	@AfterClass
	public void terminateBrowser() {
		//	driver.close();

	}

}