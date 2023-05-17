package com.TestCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.TestBase.TestBase;
import com.Utilities.TestUtils;
import com.pages.SelecttablePage;

public class SelecttablePage_Test_ShubhamKumbhar extends TestBase {
	SelecttablePage objselectable;
	TestUtils testUtils;
  public SelecttablePage_Test_ShubhamKumbhar() {
	  super();
  }
  @BeforeMethod
  public void setUp() {

//Setting up for the SelectTable Page.
		initialization();
		objselectable = new SelecttablePage();
		driver.findElement(By.linkText("Interactions")).click();
		driver.findElement(By.linkText("Selectable")).click();
		driver.manage().timeouts().pageLoadTimeout(testUtils.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
	}
  
//Performing test on normal selectTable .
  @Test(priority=1)
  public void SelecttablePage_Test1() {
	
//Listing all the options from the table.
	  List<WebElement> table = objselectable.getTagList();
	  for(WebElement li : table) {
		  if(li.getText().equals("Sakinalium - Method Chaining")) {
			  li.click();
		  }
	  }
  }

//Performing test on Serialized selectTable.
  @Test(priority =2)
  public void SelecttablePage_Test2() {
	  objselectable.clickSerialize();

//Listing all the options from the table.
	  List<WebElement> table = objselectable.getTagList1();
	  for(WebElement get : table) {
		  if(get.getText().equals("Sakinalium - Extent Reports")) {
			  get.click();
		  }
	  }
//Checking selected option is right .
	  String Expect = "You've selected: Extent Reports";
	  String actual = driver.findElement(By.xpath("//*[@id=\"feedback\"]")).getText();
	  
	  Assert.assertEquals(actual, Expect);
  }
  
  @AfterMethod
  public void sEnd() {
	  driver.close();
  }
}
