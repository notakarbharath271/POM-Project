package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//PageFactort/ObjectRepository
	
	@FindBy(name="username")
	WebElement UserName;
	
	@FindBy(name="password")
	WebElement Password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement Loginbtn;
	
	@FindBy(xpath="//a[text()='Sign Up']")
	WebElement SignUplink;
	
	@FindBy(xpath="//img[contains(@src,'https://d3lh3kd7bj2evy.cloudfront.net/img/logo.png')]")
	WebElement crmLogo;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle() {
		String title=driver.getTitle();
		return title;
	}
	
	public boolean validateCRMLogo() {
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String username,String password) {
		UserName.sendKeys(username);
		Password.sendKeys(password);
		Loginbtn.click();
		
		return new HomePage();
	}

}
