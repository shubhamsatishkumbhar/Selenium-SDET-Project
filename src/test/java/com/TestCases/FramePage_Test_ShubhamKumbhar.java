package com.TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.TestBase.TestBase;
import com.Utilities.TestUtils;
import com.pages.FramePage;

public class FramePage_Test_ShubhamKumbhar extends TestBase {
	
//Testing FramePage
	FramePage objFrame; 
	TestUtils testUtils;
  public FramePage_Test_ShubhamKumbhar() {
	  super();
  }
  @BeforeMethod
  public void setUp() {

//Setting up for Alert page Test.
	  initialization();
	  objFrame = new FramePage();
	  driver.findElement(By.linkText("SwitchTo")).click();
	  driver.findElement(By.linkText("Frames")).click();
	  driver.manage().timeouts().pageLoadTimeout(testUtils.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
  }
//Performing test on Single Frame
  @Test(priority=1)
  public void FramePage_Test1() {
	 // WebElement frame1= driver.findElement(By.xpath("/html/body/section/div/div/div"));
	  driver.switchTo().frame("singleframe");
	  int FrameCount = driver.findElements(By.tagName("iFrame")).size();
	  System.out.println("Total iFrame = "+FrameCount);

//Entering some data into frame field.	  
	  WebElement text = driver.findElement(By.xpath("/html/body/section/div/div/div/input"));
	  text.sendKeys("Hello Wel-Come from Shubham");
	  
	  driver.switchTo().defaultContent();
  }
//Performing test on Multi Frames.
  @Test(priority=2)
  public void FramePage_Test2() {
	  objFrame.clickMultiframe();
	  WebElement frame= driver.findElement(By.xpath("//*[@id=\"Multiple\"]/iframe"));
	  driver.switchTo().frame(frame);
	  int Framecount1 = driver.findElements(By.tagName("iFrame")).size();
	  System.out.println("Total Frames in frame : "+Framecount1);
	 
	  WebElement frame1= driver.findElement(By.xpath("/html/body/section/div/div/iframe"));
	  driver.switchTo().frame(frame1);
	  
//Entering some data into frame field.	
	  driver.findElement(By.xpath("/html/body/section/div/div/div/input")).sendKeys("Greetings from Shubham Kumbhar");
	  
	  driver.switchTo().parentFrame();
	  driver.switchTo().defaultContent();  
  }
  @AfterMethod(enabled=true)
  public void fClose() {
	  driver.close();
  }
}
