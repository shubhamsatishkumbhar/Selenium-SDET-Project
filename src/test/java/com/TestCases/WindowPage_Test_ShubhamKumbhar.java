package com.TestCases;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.TestBase.TestBase;
import com.Utilities.TestUtils;
import com.pages.WindowPage;



public class WindowPage_Test_ShubhamKumbhar extends TestBase {

//Testing WindowPage
	WindowPage objwindow; 
	TestUtils testUtils;
	
	public WindowPage_Test_ShubhamKumbhar() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {

//Setting up for Window Page Test.
		initialization();
		objwindow = new WindowPage();
		driver.findElement(By.linkText("SwitchTo")).click();
		driver.findElement(By.linkText("Windows")).click();
		driver.manage().timeouts().pageLoadTimeout(testUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	}
	
//Performing test on Tabbed Window.
	@Test(priority=1)
	public void WindowPage_Test1() {
		objwindow.clickTabbed();
		objwindow.clickTabbedClick();
		
//Storing all opened Window Tab using ArrayList.
		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
//Switching to new opened tab of window
		driver.switchTo().window(newTab.get(1));
		System.out.println("Get Title of New Tab: "+driver.getTitle());
		driver.close();
		
//Switching to previous tab
		driver.switchTo().window(newTab.get(0));
		System.out.println("Get Title of Current Tab:  "+driver.getTitle());
	}

//Performing test on Separate window.
	@Test(priority=2)
	public void WindowPage_Test2() {
		objwindow.clickSeperate();
		
		String parentHandle= driver.getWindowHandle();
		System.out.println("Parent Window Url: "+driver.getCurrentUrl());
		
		objwindow.clickSeperateClick();	

		Set<String> handles = driver.getWindowHandles();	
		for(String handle : handles) {
			if(!handle.equals(parentHandle)) {
				driver.switchTo().window(handle);
				System.out.println("Child Window Url: "+driver.getCurrentUrl());				
			}
		}
	}

//Performing test on Multiple windows.
	@Test(priority=3)
	public void WindowPage_Test3() {
		objwindow.clickMultiple();
		objwindow.clickMultipleClicks();

//Getting no. of windows opens.
		Set<String> handles = driver.getWindowHandles();
		System.out.println("Total Window Open : "+handles);

//Iterating parent and child window.
		Iterator<String> iterator =handles.iterator();
		String parentWindow = iterator.next();
		System.out.println("Parent Window Url: "+parentWindow);
		String childWindow = iterator.next();
		System.out.println("Child Window Url: "+childWindow);
		String childWindow1 = iterator.next();
		System.out.println("Second ChildWindow: "+childWindow1);

//Switching to first child window and entering detail.
		driver.switchTo().window(childWindow1);
		
		objwindow.enterEmail("shubham@gmail.com");
		objwindow.clickArrow();
		String expected = "https://demo.automationtesting.in/Register.html";
		String actual = driver.getCurrentUrl();
		Assert.assertEquals(expected, actual);
		driver.close();

//Switching to second child window.
		driver.switchTo().window(childWindow);
		String expected1 = "https://www.selenium.dev/";
		String actual1 = driver.getCurrentUrl();
		Assert.assertEquals(expected1, actual1);
		driver.close();

//Switching to parent window. 
		driver.switchTo().window(parentWindow);
					
	}
	
	@AfterMethod(enabled = true)
	  public void wClose() {
		  driver.close();
	  }
}

