package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.TestBase.TestBase;

public class FramePage extends TestBase {
	
//// All Locators Locating Frame Page Related Elements.	
	public FramePage(){
		PageFactory.initElements(driver,this);
	}
//Locating element of Single Frame.	
	 By singleFrame = By.xpath("/html/body/section/div[1]/div/div/div/div[1]/div/ul/li[1]/a");
//Locating Element of Multi Frame
	 By multiFrame = By.xpath("/html/body/section/div[1]/div/div/div/div[1]/div/ul/li[2]/a");
	 
	 public void clickSingleframe() {
		 driver.findElement(singleFrame).click();
	 }
	 public void clickMultiframe() {
		 driver.findElement(multiFrame).click();
	 }
}

