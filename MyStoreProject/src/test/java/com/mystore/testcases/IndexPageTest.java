package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;

public class IndexPageTest  extends BaseClass{

private IndexPage indexPage;
	
	
	
	
	@BeforeMethod(groups = { "smoke", "sanity"})
	@Parameters("browser")	
	public void setup(String browser) {
		
		launchApp(browser); 
	}
	@Test(groups = "smoke")
	public void verifyLogo() throws Throwable {
		
		indexPage= new IndexPage();
		boolean result = indexPage.validateLogo();
		Assert.assertTrue(result);
	}
	
	@Test(groups = "smoke")
	public void verifyTitle() {
		
		String actTitle=indexPage.getHBTitle();
		System.out.println(actTitle);
		Assert.assertTrue(false);
		
		
		//Assert.assertEquals(actTitle, "My Store1");
		
	}
	
	@AfterMethod(groups = { "smoke", "sanity"})
	public void tearDown() {
		getDriver().quit();
	}


}