package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.TestBase.TestBase;

public class DatepickerPage extends TestBase {
	
// All Locators Locating DatePicker Related Elements.	
	public DatepickerPage() {
		PageFactory.initElements(driver, this);
	}
	
//Locating elements of Disable type of DatePicker.
	By logo = By.xpath("/html/body/section/div[1]/div/div/form/div[2]/div[2]/img");
	By disableMonth = By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/span[1]");
	By disableYear = By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/span[2]");
	By disableDate = By.xpath("//*[@id='ui-datepicker-div']/table//td");
	By nextDis = By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]/span");
	By preDis = By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[1]/span");

//Locating elements of Enable type of DatePicker.
	By enableBox = By.id("datepicker2");
	By enableMonth = By.xpath("/html/body/div[2]/div/div[2]/div/div/select[1]");
	By enableYear = By.xpath("/html/body/div[2]/div/div[2]/div/div/select[2]");
	By enableDate = By.xpath("/html/body/div[2]/div/div[2]/div/table//td");
	
	public void clickLogo() {
		driver.findElement(logo).click();
	}
	public WebElement getDisableMonth() {
		return driver.findElement(disableMonth);
	}
	public WebElement getDisableYear() {
		return driver.findElement(disableYear);
	}
	public WebElement getDisableDate() {
		return driver.findElement(disableDate);
	}
	public void clickNextDis() {
		driver.findElement(nextDis).click();
	}
	public void clickpreDis() {
		driver.findElement(preDis).click();
	}
	public void clickEnablebox() {
		driver.findElement(enableBox).click();
	}
	public WebElement selectEnableMonth() {
		return driver.findElement(enableMonth);
	}
	public WebElement selectEnableYearh() {
		return driver.findElement(enableYear);
	}
	public void selectEnableDate() {
		 driver.findElement(enableDate);
	}
}
