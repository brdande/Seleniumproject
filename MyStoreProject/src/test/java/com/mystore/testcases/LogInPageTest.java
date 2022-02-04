package com.mystore.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;

public class LogInPageTest extends BaseClass{
	
	private IndexPage indexPage;
	private LoginPage loginPage;
	
	
	@BeforeMethod(groups = { "smoke", "sanity"})
	@Parameters("browser")
	public void setup(String browser) {
		
		launchApp(browser); 
	}
	
	
	@Test(dataProvider = "credentials" , dataProviderClass = DataProviders.class, groups = "sanity" )
	public void logInTest(String userName, String password) throws Throwable {
		Log.startTestCase("Login Test");
		indexPage= new IndexPage();
		Log.info("User is going to sign in ");
		loginPage = indexPage.clickOnSignIn();
		Log.info("Enter username and password");
		System.out.println("User Name " + userName + "   password " + password);
		loginPage.login(userName,password);
		    //loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod(groups = { "smoke", "sanity"})
	public void tearDown() {
		getDriver().quit();
	}

	

}
