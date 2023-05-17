package com.TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.TestBase.TestBase;
import com.Utilities.ExcelWork;
import com.Utilities.TestUtils;
import com.pages.RegisterPage;

import junit.framework.Assert;

public class RegisterPage_Test_ShubhamKumbhar extends TestBase {
	
//Testing RegisterPage
	RegisterPage objregister;
	ExcelWork excel = new ExcelWork();
	TestUtils testUtils;
	
  public RegisterPage_Test_ShubhamKumbhar() {
	  super();
  }
  @BeforeMethod
  public void setUp() {

//Setting up for Register Page Test.
	  initialization();
	  objregister = new RegisterPage();
	  driver.manage().timeouts().pageLoadTimeout(testUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
  }

//Testing by performing action on submit button.
  @Test(dataProvider="registrationTest",priority=1)
  public void RegisterPage_Test1(String fName, String lName, String add, String ID, String ph, String la, String skill, String Scountry, String da, String mon, String yr, String Npass, String Cpass) {

//Filling personal details.
	objregister.enterfirst(fName);  
	objregister.enterLast(lName);
	objregister.enterAddress(add);
	objregister.enterEmail(ID);
	objregister.enterPhone(ph);
	objregister.selectMale();
	
	objregister.selectHobbieCricket();
	objregister.selectHobbieMovie();
	
	/*WebElement lang = objregister.enterlanguage();
	Select Language = new Select(lang);
	Language.selectByVisibleText(la);*/
	
	driver.manage().timeouts().implicitlyWait(testUtils.IMPLICIT_WAIT,TimeUnit.SECONDS);
	
	objregister.selectSkill(skill);
	//objregister.selectCountry(null);
	
	/*objregister.CickselectCountry();
	WebElement count = objregister.SearchCountry(Scountry);
	Actions act = new Actions(driver);
	act.sendKeys(count);
	act.pause(1000).perform();
	act.sendKeys(count, Keys.ENTER).perform();
	driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);*/
	
	
	
	objregister.SearchCountry(Scountry);

//Selecting date of Birth.
	objregister.Day(da);
	objregister.Month(mon);
	objregister.Year(yr);

//Entering Passwords
	objregister.enterPassword(Npass);
	objregister.enterConfirmPassword(Cpass);
	objregister.clickUpload();

//Uploading file
	WebElement file_upload = objregister.clickUpload();
	file_upload.sendKeys(testUtils.projectPath+"\\src\\TestData\\Example.txt");
	driver.manage().timeouts().implicitlyWait(testUtils.IMPLICIT_WAIT,TimeUnit.SECONDS);
	objregister.clickSubmit();

//Checking of all fields are successfully filled or not.
	String expect="https://demo.automationtesting.in/Register.html";
	String actual = driver.getCurrentUrl();
	if(expect.equals(actual)) {
		System.out.println("Some fields are not able to fill.");
	}
	else{
		System.out.println("All fields filled Succesfully. You are inside.");
	}
		
  }
  
//Testing by performing action on Refresh button.
  @Test(dataProvider="registrationTest",priority=2)
  public void RegisterPage_Test2(String fName, String lName, String add, String ID, String ph, String la, String skill, String Scountry, String da, String mon, String yr, String Npass, String Cpass) {
	    
//Filling personal details	    
	    objregister.enterfirst(fName);  
		objregister.enterLast(lName);
		objregister.enterAddress(add);
		objregister.enterEmail(ID);
		objregister.enterPhone(ph);
		objregister.selectMale();
		
		objregister.selectHobbieMovie();
		objregister.selectHobbieHockey();

//Selecting date of Birth.
		objregister.Day(da);
		objregister.Month(mon);
		objregister.Year(yr);
		
		objregister.enterPassword(Npass);
		objregister.enterConfirmPassword(Cpass);
		
//Clicking on refresh button.		
		objregister.clickRefresh();

//Checking the result that refresh button is properly working or not.
		String result ="";
		if(result.equals(objregister.Renterfirst())&&result.equals(objregister.RenterLast())&&result.equals(objregister.RenterEmail())&&result.equals(objregister.RenterPhone())&&result.equals(objregister.RenterPassword())) {
			System.out.println("Refresh Button working Properly.");
		}
		else {
			System.out.println("Refresh Button is not Working as Expected.");
		}
	}
  
//Providing data for registration.
  @DataProvider(name="registrationTest")
  public Object[][] getData(){
//Fetching data from location.
	  String registerPath = testUtils.projectPath+"\\src\\TestData\\ExcelData.xlsx";
	  Object[][] data = excel.registrationTest(registerPath,"Register");
	 
	  return data;  
  }
  
  @AfterMethod(enabled= true)
  public void rOut() {
	  driver.close();
  }
}
