package com.project;

import org.apache.log4j.Logger;

import com.relevantcodes.extentreports.LogStatus;

public class TC_004 extends BaseTest
{
	private static final Logger log=Logger.getLogger(TC_004.class.getName());
	
	public static void main(String[] args) throws Exception
	{
		test=report.startTest("TC_004");
		
		init();
		log.info("initialising the properties files....");
		test.log(LogStatus.PASS, "initialising the properties files....");
		
		launch("chromebrowser");
		log.info("Opened the browser :- "+ p.getProperty("chromebrowser"));
		test.log(LogStatus.PASS,"Opened the browser :- "+ p.getProperty("chromebrowser"));
		
		navigateUrl("amazonurl");
		log.info("Navigated to url :- " + p.getProperty("amazonurl"));
		test.log(LogStatus.PASS, "Navigated to url :- " + p.getProperty("amazonurl"));
		
		selectoption("amazonsearchdrop_id","amazondropoption");
		log.info("Selected the item :-" + or.getProperty("amazondropoption") + " by using the locator :" + or.getProperty("amazonsearchdrop_id"));
		test.log(LogStatus.PASS,"Selected the item :-" + or.getProperty("amazondropoption") + " by using the locator :" + or.getProperty("amazonsearchdrop_id"));
		
		typeValue("amazonsearchtext_id","amazonsearchtext");
		log.info("Entered the text value :- "+ or.getProperty("amazonsearchtext") + " by using the locator :- " + or.getProperty("amazonsearchtext_id"));
		test.log(LogStatus.PASS, "Entered the text value :- "+ or.getProperty("amazonsearchtext") + " by using the locator :- " + or.getProperty("amazonsearchtext_id"));
		
		elementClick("amazonsearchbutton_xpath");
		log.info("Clicked on element by using the locator :- " + or.getProperty("amazonsearchbutton_xpath"));
		test.log(LogStatus.PASS, "Clicked on element by using the locator :- " + or.getProperty("amazonsearchbutton_xpath"));

		
		report.endTest(test);
		report.flush();
		/*driver.findElement(By.id("searchDropdownBox")).sendKeys("Books");
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Harry Potter");
		
		driver.findElement(By.xpath("//div[contains(@class,'nav-search-submit nav-sprite')]//input[contains(@class,'nav-input')]")).click();*/

	}

	

}
