package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LeafTapsWrappers;

public class LoginPage extends LeafTapsWrappers  {

	// This is to confirm you are in Login Page
	public LoginPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;

		if(!verifyTitle("Opentaps Open Source ERP + CRM")){
			reportStep("This is not Login Page", "FAIL");
		}
	}

	// Enter UserName
	public LoginPage enterUserName(String userName){
		enterById(prop.getProperty("Login.UserName.Id"), userName);
		return this;
	}

	// Enter Password
	public LoginPage enterPassword(String password){
		enterById(prop.getProperty("Login.Password.Id"), password);
		return this;

	}

	// Click this login 
	public HomePage clickLogin(){
		clickByClassName(prop.getProperty("Login.LoginButton.Class"));
		return new HomePage(driver, test);
	}


	// Click this logOut
	public HomePage clickLogOut(){
		clickByClassName(prop.getProperty("Login.LoginButton.Class"));
		return new HomePage(driver, test);
	}
	
	// Click login button on negative case
	public LoginPage clickLoginForFailure(){
		clickByClassName(prop.getProperty("Login.LoginButton.Class"));
		return this;
	}

	// Verify the error message
	public LoginPage verifyErrorMsg(String text){
		verifyTextContainsById(prop.getProperty("Login.Error.Id"), text);
		return this;
	}
	


}
