package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.TestBase.TestBase;


public class RegisterPage extends TestBase {
	
// All Locators Locating Register Page Related Elements.
	
	public RegisterPage(){
		PageFactory.initElements(driver, this);
	}
	
	By f_name = By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[1]/input");
	By l_name = By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[2]/input");
	By address = By.xpath("//*[@id='basicBootstrapForm']/div[2]/div/textarea");
	By email = By.xpath("//*[@id='eid']/input");
	By phone = By.xpath("//*[@id='basicBootstrapForm']/div[4]/div/input");
	By genderM = By.xpath("//*[@id='basicBootstrapForm']/div[5]/div/label[1]/input");
	By genderF = By.xpath("//*[@id='basicBootstrapForm']/div[5]/div/label[2]/input");
	By hobbiCricket = By.id("checkbox1");
	By hobbiMovie = By.id("checkbox2");
	By hobbiHockey = By.id("checkbox3");
	By language = By.xpath("//*[@id=\"basicBootstrapForm\"]/div[7]/div");
	By skills = By.id("Skills");
	By country = By.id("countries");
	By s_country = By.id("select2-country-container");
	By searchCountry = By.id("/html/body/span/span/span[1]/input");
	By year = By.id("yearbox");
	By month = By.xpath("//*[@id='basicBootstrapForm']/div[11]/div[2]/select");
	By day = By.id("daybox");
	By nPass = By.id("firstpassword");
	By cPass = By.id("secondpassword");
	By submit = By.name("signup");
	By refresh = By.id("Button1");
	By file = By.id("imagesrc");
	
	public void enterfirst(String fname) {
		driver.findElement(f_name).sendKeys(fname);
	}
	public void enterLast(String lname) {
		driver.findElement(l_name).sendKeys(lname);
	}
	public void enterAddress(String add) {
		driver.findElement(address).sendKeys(add);
	}
	public void selectHobbieCricket() {
		driver.findElement(hobbiCricket).click();
	}
	public void selectHobbieMovie() {
		driver.findElement(hobbiMovie).click();
	}
	public void selectHobbieHockey() {
		driver.findElement(hobbiHockey).click();
	}
	public void enterEmail(String id) {
		driver.findElement(email).sendKeys(id);
	}
	public void enterPhone(String num) {
		driver.findElement(phone).sendKeys(num);
	}
	public void selectMale() {
		driver.findElement(genderM).click();
	}
	public void selectFemale() {
		driver.findElement(genderF).click();
	}
	public WebElement enterlanguage() {
		return driver.findElement(language);
	}
	public void selectSkill(String skil) {
		Select sk =new Select(driver.findElement(skills));
		sk.selectByVisibleText(skil);
	}
	public WebElement selectCountry(String co) {
		return driver.findElement(s_country);
		
	}
	public void CickselectCountry() {
		driver.findElement(s_country).click();	
	}
	public WebElement SearchCountry(String co) {
		return driver.findElement(searchCountry);
	}
	public void Day(String d) {
		Select da = new Select(driver.findElement(day));
		da.selectByVisibleText(d);
	}
	public void Year(String y) {
		Select ya = new Select(driver.findElement(year));
		ya.selectByVisibleText(y);
	}
	public void Month(String m) {
		Select mo = new Select(driver.findElement(month));
		mo.selectByVisibleText(m);
	}
	public void enterPassword(String passN) {
		driver.findElement(nPass).sendKeys(passN);
	}
	public void enterConfirmPassword(String passC) {
		driver.findElement(cPass).sendKeys(passC);
	}
	public WebElement clickUpload() {
		return driver.findElement(file);
	}
	public void clickSubmit() {
		driver.findElement(submit).click();
	}
	public void clickRefresh() {
		driver.findElement(refresh).click();
	}
	public String Renterfirst() {
		return driver.findElement(f_name).getText();
	}
	public String RenterLast() {
		return driver.findElement(l_name).getText();
	}
	public String RenterEmail() {
		return driver.findElement(email).getText();
	}
	public String RenterPhone() {
		return driver.findElement(phone).getText();
	}
	public String RenterPassword() {
		return driver.findElement(nPass).getText();
	}	
}
