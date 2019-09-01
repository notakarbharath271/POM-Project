package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	ContactPage contactpage;
	TestUtil testutil;
	
	public HomePageTest(){
		super();
	}
	// test cases should be seperate/independent with each other
	//before each test case--launch the browser and login
	//@test--execute the testcase
	//after each test case -- close the browser
	@BeforeMethod
	public void setup() {
		initialization();
		loginpage = new LoginPage();
		contactpage=new ContactPage();
		testutil = new TestUtil();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyHomepageTitleTest() {
		String homepagetitle=homepage.verifyHomePageTitle();
		Assert.assertEquals(homepagetitle, "CRMPRO","HomePage Title is not matched");
		
	}
	
	@Test(priority=2)
	public void verifyuserNameLabelTest() {
		testutil.switchtoframe();
		Assert.assertTrue(homepage.verifyusernamelabel());
	}
	
	@Test(priority=3)
	public void clickOnContactsLink() {
		testutil.switchtoframe();
		contactpage= homepage.clickOnContactslink();
		
		
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
