package com.TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.TestBase.TestBase;
import com.Utilities.TestUtils;
import com.pages.AlertPage;

public class AlertPage_Test_ShubhamKumbhar extends TestBase { 
	
//Testing AlertPage	
	AlertPage objalert;
	
	public AlertPage_Test_ShubhamKumbhar() {
		super(); //avoid to throw NullPointerException
	}
	
  @BeforeMethod
  public void setUp() {

//Setting up for Alert page Test.
	  initialization();
	  objalert = new AlertPage();
	  driver.findElement(By.xpath("//*[@id=\"header\"]/nav/div/div[2]/ul/li[4]/a")).click();
	  driver.findElement(By.linkText("Alerts")).click();
	  driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
  }
//Performing test on Simple Alert.
  @Test(priority = 1)
  public void AlertTest_1() {
	  	  
	  //objalert.clickAlertok();
	  objalert.clickAlertbox();
	 // driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
	  
//Switching towards alert and getting text displayed on Alert Box and Accepting alert.	  
	  Alert alert = driver.switchTo().alert();
	  String alert1 = alert.getText();
	  System.out.println("Message1 : " +alert1);
	  alert.accept();
	  
	  driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
	  
  }
//Performing test on Confirm Alert.
  @Test(priority = 2)
  public void AlertTest_2() {
	  objalert.clickAlertconfirm();
	  objalert.clickConfirmbox();
	  
//Switching to alert as well getting message displayed on alert and Confirming as well as dismissing alert box and getting response
	  
	  Alert alert = driver.switchTo().alert();
	  String alert2 = alert.getText();
	  System.out.println("Message2 : " +alert2);
	  
//Accepting Alert 	  
	  alert.accept();
	  String except = "You pressed Ok";
	  String actual = driver.findElement(By.id("demo")).getText();
	  Assert.assertEquals(except,actual);
	  driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
	  objalert.clickAlertconfirm();
	  objalert.clickConfirmbox();
	  
//Dismissing Alert	  
	  alert.dismiss();
	  String except1 ="You Pressed Cancel";
	  String actual1 = driver.findElement(By.id("demo")).getText();
	  Assert.assertEquals(actual1, except1);
  }
  
//Performing Test on Prompt Alert.
  @Test(priority = 3)
  public void AlertTest_3() {
	  
	  objalert.clickAlerttext();
	  objalert.clickPromptbox();
//Switching towards prompt alert and entering data to text-filed of alert box and accepting alert as well as verify the feedback message.
	  Alert alert = driver.switchTo().alert();
	  String alert3=alert.getText();
	  System.out.println("Message3: "+alert3);
	  
	  String fill ="Shubham Satish Kumbhar";
	  alert.sendKeys(fill);
	  alert.accept();
	  
	  String get = driver.findElement(By.id("demo1")).getText();
	  if(get.equals("Hello "+fill+" How are you today")) {
		  System.out.println("Alert prompt Box Demo Successful");
	  }
	  else {
		  System.out.println("Prompt box Showing something different: "+get);
	  }
  }
  
  @AfterMethod(enabled=true)
  public void aClose() {
	  driver.close();
  }
}
