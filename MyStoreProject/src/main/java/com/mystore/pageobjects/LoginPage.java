/**
 * 
 */
package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

/**
 * @author Admin
 *
 */
public class LoginPage extends BaseClass {
	
	Action action= new Action();
	
	@FindBy(xpath= "//input[@placeholder='Mobile No.']") 
	WebElement userName;
	
	@FindBy(xpath= "//input[@placeholder='Password']") 
	WebElement password;
	
	@FindBy(xpath= "//button[@type='submit'][normalize-space()='Login']") 
	WebElement logInbtn;
	
	@FindBy(xpath= "//a[@id='btnRegister']")
	WebElement signUpBtn;
	
	@FindBy(xpath= "//button[normalize-space()='OK']")
	WebElement okButton;
	
   public LoginPage() {
		PageFactory.initElements(getDriver(), this);
   }
   
   public UserPage login(String uname, String pswd) throws Throwable {
		action.scrollByVisibilityOfElement(getDriver(), userName);
		action.type(userName, uname);
		action.type(password, pswd);
		action.JSClick(getDriver(), logInbtn);
		Thread.sleep(2000);
		action.JSClick(getDriver(), okButton);
		
		return new UserPage();
	}

}
