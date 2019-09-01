package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//td[contains(text(),'User: N Bharath Kumar')]")
	WebElement UserNamelabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactslink;
	
	@FindBy(xpath="//a[text()='New Contact']")
	WebElement newcontactlink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealslink;

	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement taskslink;
	
	@FindBy(xpath="//a[text()='Email']")
	WebElement emaillink;
	
	
	// initilizing the page Objects
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	public boolean verifyusernamelabel() {
		
		return UserNamelabel.isDisplayed();
	}
	public ContactPage clickOnContactslink() {
		contactslink.click();
		
		return new ContactPage();
	}
	
	public DealsPage clickOnDealslink() {
		dealslink.click();
		
		return new DealsPage();
	}
	
	public TasksPage clickOntasklink() {
		taskslink.click();
		return new TasksPage();
	}
	
	public EmailPage clickonEmaillink() {
		emaillink.click();
		return new EmailPage();
	}
	
	public void clickNewContactlink() {
		Actions act=new Actions(driver);
		act.moveToElement(contactslink).build().perform();
		newcontactlink.click();
	}
	
}
