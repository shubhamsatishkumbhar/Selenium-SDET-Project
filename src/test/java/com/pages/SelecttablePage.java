package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.TestBase.TestBase;

public class SelecttablePage extends TestBase{

// All Locators Locating SelectTable Related Elements.
	
	public SelecttablePage() {
		PageFactory.initElements(driver, this);
	}

//Locators locating elements related to Normal Select table.
	By list = By.xpath("//*[@id=\"Default\"]/ul");
	By tagList = list.tagName("li");//taglist variable used here to locate tagname li under the list variable

//Locators locating elements related to Normal Select table.
	By serialize = By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[2]/a");
	By list1 = By.xpath("//*[@id=\"Serialize\"]/ul");
	By tagList1 = list1.tagName("li");
	
	public WebElement getList() {
		return driver.findElement(list);
	}
	public List<WebElement> getTagList(){
		return driver.findElements(tagList);
	}
	public void clickSerialize() {
		driver.findElement(serialize).click();
	}
	public WebElement getList1() {
		return driver.findElement(list1);
	}
	public List<WebElement> getTagList1(){
		return driver.findElements(tagList1);
	}
}
