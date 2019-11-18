package com.project;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

public class TC_005 extends BaseTest
{
	private static final Logger log=Logger.getLogger(TC_005.class.getName());
	
	public static void main(String[] args) throws Exception
	{
		test=report.startTest("TC_005");
		
		init();
		log.info("initialising the properties files....");
		test.log(LogStatus.PASS, "initialising the properties files....");
		
		launch("chromebrowser");
		log.info("Opened the browser :- "+ p.getProperty("chromebrowser"));
		test.log(LogStatus.PASS,"Opened the browser :- "+ p.getProperty("chromebrowser"));
		
		navigateUrl("amazonurl");
		log.info("Navigated to url :- " + p.getProperty("amazonurl"));
		test.log(LogStatus.PASS, "Navigated to url :- " + p.getProperty("amazonurl"));
		
		
		
		
		/*//String actualLink = driver.findElement(By.linkText("AmazonBasics")).getText();
		String actualLink = driver.findElement(By.linkText("AmazonBasics")).getAttribute("innerHTML");
		String expectedLink="AmazonBas";
		
		System.out.println("Actual Link  :-" + actualLink );
		System.out.println("Expected Link  :-" + expectedLink );
		
		//if(actualLink.equals(expectedLink))
		//if(actualLink.equalsIgnoreCase(expectedLink))
		if(actualLink.contains(expectedLink))
			System.out.println("Both links are equal....");
		else
			System.out.println("Both links are not equal....");*/
		
		
		/*WebElement loc = driver.findElement(By.id("twotabsearchtextbox"));
		loc.sendKeys("samsung");
		String actualText = loc.getAttribute("value");
		System.out.println("Actual Text :- " + actualText);*/
		
		
		String expectedLink="AmazonBasic";
		if(!verifyElement(expectedLink))
			reportFailure("Both links are not equal...");
		else
			reportSuccess("Both links are equal...");
		
		
		
		report.endTest(test);
		report.flush();
		
	}

	
}
