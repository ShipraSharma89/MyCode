package object_repo;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*This class defines locators for homepage*/

public class homepage {

	//--------------Opinion / Latest-------------------
	@FindBy(xpath = "//*[@id='home-opinion']/header/h2")
	// Locator for Opinion / Latest
	public WebElement Opinion_Latest;

	@FindBy(xpath = "//*[@id='home-opinion']/header/a[text()='Show All']")
	// Locator for Show_All
	public WebElement Show_All;

	@FindAll({ @FindBy(xpath = "//*[@id='home-opinion']//*[@class='home__post-block']") })
	// Locator To find List of Opinion_Elements
	public List<WebElement> list_Opinion_Elements;

	@FindAll({ @FindBy(xpath="//*[@class='home__opinion-columns clearfix']//*[@class='author']") })
	//Locator for Author In Items Under Opinion Section
	public List<WebElement> list_author_listitems_Opinion_Section;

	@FindAll({ @FindBy(xpath="//*[@class='home__opinion-columns clearfix']//h3") })
	//Locator for Headline In Items Under Opinion Section
	public List<WebElement> list_Headline_listitems_Opinion_Section;

	@FindAll({ @FindBy(xpath="//*[@class='home__opinion-columns clearfix']//p") })
	//Locator for InnerText In Items Under Opinion Section
	public List<WebElement> list_innertext_listitems_Opinion_Section;

	@FindAll({ @FindBy(xpath="//*[@class='home__opinion-columns clearfix']//img") })
	//Locator for Image Container In Items Under Opinion Section
	public List<WebElement> list_image_listitems_Opinion_Section;

	
	//--------------- DemoFridays and Webinars-------------------
	
	@FindBy(xpath = "//*[@data-target='#tab-demofridays-webinars']//a[text()='Show All']")
	// Locator of the linktext in Nav Tab - "show all"
	public WebElement linktext_show_all_navTab_DemoFriday_and_Webinar;
	
	@FindBy(xpath = "//*[@data-target='#tab-demofridays-webinars']//a[@aria-controls='tab-demofridays-webinars']")
	// Locator of the linktext in Nav Tab - "DemoFridays / Webinars"
	public WebElement linktext_Demofriday_Webinar_navTab_DemoFriday_and_Webinar;
	
	@FindAll({ @FindBy(xpath="//*[@class='home__demofriday-right']//*[@class='home__demofriday-footer-right']") }) 
	// Locator of the Footer Button Section that has "Register"
	public List<WebElement> list_footer_button_DemoFriday_and_Webinar;
	
	@FindAll({ @FindBy(xpath="//*[@class='home__demofriday-right']//*[@class='datetime']") }) 
	//Locator for List of List Items Date Under DemoFridays and Webinars Section.
	public List<WebElement> list_listitem_Date_DemoFridays_and_Webinars_Section;
	
	@FindAll({ @FindBy(xpath="//*[@class='home__demofriday-right']//p") }) 
	//Locator for List of List Items content text Under DemoFridays and Webinars Section.
	public List<WebElement> list_listitem_inner_content_text_DemoFridays_and_Webinars_Section;
	
	@FindAll({ @FindBy(xpath="//*[@class='home__demofriday-right']//h3") }) 
	//Locator for List of List Items Header Under DemoFridays and Webinars Section.
	public List<WebElement> list_listitem_Header_DemoFridays_and_Webinars_Section;
	
	@FindAll({ @FindBy(xpath="//*[@class='home__demofriday-right']/a") }) 
	//Locator for List of List Items Header Under DemoFridays and Webinars Section.
	public List<WebElement> list_listitem_Header_Href_DemoFridays_and_Webinars_Section;
	
	@FindAll({ @FindBy(xpath="//*[@class='home__demofriday-right']") }) 
	//Locator for List of List Items Under DemoFridays and Webinars Section.
	public List<WebElement> list_listitem_DemoFridays_and_Webinars_Section;
	
	@FindAll({ @FindBy(xpath="//*[@class='home__demofriday-right']//*[@class='category']") }) 
	//Locator for List of List Items Category Under DemoFridays and Webinars Section.
	public List<WebElement> list_listitem_Category_DemoFridays_and_Webinars_Section;
	
	






	//------Initialising webelements 

	public homepage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
