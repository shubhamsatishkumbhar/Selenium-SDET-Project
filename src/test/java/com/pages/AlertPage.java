package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import com.TestBase.TestBase;

public class AlertPage extends TestBase {
	
// All Locators Locating Alert Page Related Elements.
	
	public AlertPage(){
		PageFactory.initElements(driver, this);
	}
	
//Simple Alert
	By alertOk = By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[1]/a");
	By displayAlertBox = By.xpath("//*[@id='OKTab']/button");
	
//Confirm Alert
	By alertOkCancel = By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[2]/a");
	By confirmbox = By.xpath("//*[@id='CancelTab']/button");
	
//Alert Prompt
	By alertText =  By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[3]/a");
	By promptBox = By.xpath("//*[@id='Textbox']/button");
	
	
	public void clickAlertok() {
		driver.findElement(alertOk).click();
	}
	public void clickAlertbox() {
		driver.findElement(displayAlertBox).click();
	}
	public void clickAlertconfirm() {
		driver.findElement(alertOkCancel).click();
	}
	public void clickConfirmbox() {
		driver.findElement(confirmbox).click();
	}
	public void clickAlerttext() {
		driver.findElement(alertText).click();
	}
	public void clickPromptbox() {
		driver.findElement(promptBox).click();
	}
}
