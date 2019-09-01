package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	ContactPage contactpage;
	TestUtil testutil;
	
	String sheetname="Contacts";
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginpage = new LoginPage();
		contactpage=new ContactPage();
		testutil = new TestUtil();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		testutil.switchtoframe();
		contactpage=homepage.clickOnContactslink();
	}
	
	@Test(priority=1)
	public void verifyContactsPageLabel()
	{
		Assert.assertTrue(contactpage.verifyContectsLabel(),"Contacts label is missing on the page");
	}
	@Test(priority=2)
	public void selectSingleContactTest() {
		contactpage.seletContactsByName("Sarath N");
		
	}
	
	@Test(priority=3)
	public void selectMultipleContactTest() {
		contactpage.seletContactsByName("Sarath N");
		contactpage.seletContactsByName("Bharathk Notakar");
	}
	
	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][]=TestUtil.getData(sheetname);
		return data;
		
	}
	@Test(priority=4,dataProvider="getCRMTestData")
	public void createNewContactlinkTest(String title,String firstname,String lastname,String company) {
		homepage.clickNewContactlink();
		//contactpage.createNewContacts("Mr.", "Bharath", "Notakar","Google");
		contactpage.createNewContacts(title, firstname, lastname, company);
	}
	
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
