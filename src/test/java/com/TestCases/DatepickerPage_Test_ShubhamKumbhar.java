package com.TestCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.TestBase.TestBase;
import com.Utilities.TestUtils;
import com.pages.DatepickerPage;

public class DatepickerPage_Test_ShubhamKumbhar extends TestBase {

//Testing DatePickerPage
	DatepickerPage objdate; 
	TestUtils testUtils;
   
	public DatepickerPage_Test_ShubhamKumbhar() {
		super(); //avoid to throw NullPointerException
	}
	
  @BeforeMethod
  public void setUp() {
//Setting up for DatePicker page Test.
	  
	  initialization();
	  objdate = new DatepickerPage();
	  driver.findElement(By.linkText("Widgets")).click();
	  driver.findElement(By.linkText("Datepicker")).click();
	  driver.manage().timeouts().pageLoadTimeout(testUtils.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
  }
//Performing test on Disable Type of DatePicker.
 @Test(priority=1)
  public void DatepickerPage_Test1() {
	  String year = "2021";
	  String month = "August";
	  String date = "10";
	  driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT,TimeUnit.SECONDS);
	  objdate.clickLogo();

//Getting the month and year and comparing with expected date and selecting by performing actions.
	  while(true) {
		  WebElement Gmonth = objdate.getDisableMonth();
		  String mon = Gmonth.getText();

		  
		  WebElement Gyear = objdate.getDisableYear();
		  String ye = Gyear.getText();
		  int Year = Integer.parseInt(ye);//Converted to int for comparison. 
		  
		  if(mon.equalsIgnoreCase(month) && ye.equals(year)) {//If there is any case sensitive data it will ignore and compare
			  break;
		  }
		  else if(Year<2021) {
			  objdate.clickNextDis();
		  }
		  else{
			 objdate.clickpreDis(); 
		  }
	  } 
//Listing of all days to comparing that date and selecting as expected.
	  List<WebElement> allDates = driver.findElements(By.xpath("//*[@id='ui-datepicker-div']/table//td"));
	  
	  for(WebElement ele:allDates) {
		  String dt = ele.getText();
		  if(dt.equals(date)) {
			  ele.click();
			  break;
		  }
	  }
  }
 
 //Performing test on Enable type of DatePicker.
  	@Test(priority=2)
  	public void DatepickerPage_Test2() {
  		objdate.clickEnablebox();
//Getting the month and year and comparing with expected date and selecting by performing actions. 		
  		Select Month = new Select(objdate.selectEnableMonth());
  		Month.selectByVisibleText("October");
  		
  		Select Year = new Select(objdate.selectEnableYearh());
  		Year.selectByVisibleText("2020");
 
  		String date = "18";
  	
//Listing of all days to comparing that date and selecting as expected.  		
  		List<WebElement> allDates = driver.findElements(By.xpath("/html/body/div[2]/div/div[2]/div/table//td"));
  		for(WebElement ele: allDates) {
  			String dt = ele.getText();
  			
  			if(date.equals(dt)) {
  				ele.click();
  				break;
  			}
  		}
  	}
  	
  	@AfterMethod(enabled=true)
    public void dClose() {
  	  driver.close();
    }
}
