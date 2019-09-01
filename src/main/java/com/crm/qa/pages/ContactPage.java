package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactPage extends TestBase{
	
	Select select;
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactslabel;
	
	@FindBy(xpath="//input[@onclick='checkAll(this);']")
	WebElement selectAllcheckbox;
	
	@FindBy(xpath="//select[@name='title']")
	WebElement selecttitle;
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement first_name;
	
	@FindBy(xpath="//input[@name='surname']")
	WebElement surname;
	
	@FindBy(xpath="//input[@name='client_lookup']")
	WebElement companyclient_lookup;
	
	@FindBy(xpath="//*[@id=\"contactForm\"]/table/tbody/tr[1]/td/input[2]")
	WebElement savebtn;
	
	
	
	public ContactPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	public boolean verifyContectsLabel() {
		return contactslabel.isDisplayed();
		
	}
	
	public void seletContactsByName(String name) {
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
				+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}
	
	public void createNewContacts(String title,String fstName, String lstName,String compName ) {
		Select select = new Select(selecttitle);
		select.selectByVisibleText(title);
		first_name.sendKeys(fstName);
		surname.sendKeys(lstName);
		companyclient_lookup.sendKeys(compName);
		savebtn.click();
		
	}
}
