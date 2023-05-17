package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.TestBase.TestBase;

public class WindowPage extends TestBase {

// All Locators Locating Window Page Related Elements.	
	public WindowPage(){
		PageFactory.initElements(driver,this);
	}
//Tabbed Window 		
	By tabbed = By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[1]/a");
	By tabbedClick = By.xpath("//*[@id='Tabbed']/a/button");
//Seperate Window 
	By seperate = By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[2]/a");
	By seperateClick = By.xpath("//*[@id='Seperate']/button");
//Multiple Windows
	By multiple = By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[3]/a");
	By multipleClick = By.xpath("//*[@id='Multiple']/button");
	By indexEmail = By.id("email");
	By indexarrow = By.id("enterimg");
	
	public void clickTabbed() {
		driver.findElement(tabbed).click();
	}
	public void clickTabbedClick() {
		driver.findElement(tabbedClick).click();
	}
	public void clickSeperate() {
		driver.findElement(seperate).click();
	}
	public void clickSeperateClick() {
		driver.findElement(seperateClick).click();
	}
	public void clickMultiple() {
		driver.findElement(multiple).click();
	}
	public void clickMultipleClicks() {
		driver.findElement(multipleClick).click();
	}
	public void enterEmail(String Email) {
		driver.findElement(indexEmail).sendKeys(Email);
	}
	public void clickArrow() {
		driver.findElement(indexarrow).click();
	}
}
