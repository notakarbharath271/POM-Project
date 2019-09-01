package com.crm.qa.util;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.crm.qa.base.TestBase;

public class WebEventListener extends TestBase implements WebDriverEventListener {

	

	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("Before Navigate to:"+url+"'");
		
	}

	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("'Navigate to:'"+url+"'");
		
	}

	public void beforeNavigateBack(WebDriver driver) {
		System.out.println("'Before navigate to preavoius page'");
		
	}

	public void afterNavigateBack(WebDriver driver) {
		System.out.println("'After navigate Back the page'");
		
	}

	public void beforeNavigateForward(WebDriver driver) {
		System.out.println("'Before navigate Forward the page'");
		
	}

	public void afterNavigateForward(WebDriver driver) {
		System.out.println("'After navigate Forward the page'");
		
	}

	public void beforeNavigateRefresh(WebDriver driver) {
		System.out.println("'Before navigate refreash the page'");
		
	}

	public void afterNavigateRefresh(WebDriver driver) {
		System.out.println("'After navigate refreash the page'");
		
	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("'BeforFindBy'"+by.toString()+"'");
		
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("'AfterFindBy'"+by.toString()+"'");
		
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		System.out.println("'Before click on element'"+element.toString()+"'");
		
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println("'After click on element'"+element.toString()+"'");
		
	}

	public void beforeScript(String script, WebDriver driver) {
		System.out.println("'BeforeScript :'"+script.toString()+"'");
		
	}

	public void afterScript(String script, WebDriver driver) {
		System.out.println("'AfterScript :'"+script.toString()+"'");
		
	}

	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		System.out.println("'BeforeSwitchToWindow :'"+windowName.toString()+"'");
		
	}

	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		System.out.println("'BeforeSwitchToWindow :'"+windowName.toString()+"'");
		
	}
	
	public void onException(Throwable throwable, WebDriver driver) {
	System.out.println("Exception occured :"+throwable);
	try {
		TestUtil.takescreenshotAtEndOfTest();
	}catch(IOException e) {
		e.printStackTrace();
	}
		
	}

	

	public void beforeAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub
		
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub
		
	}

	
	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		// TODO Auto-generated method stub
		
	}

	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		// TODO Auto-generated method stub
		
	}

	public void beforeGetText(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterGetText(WebElement element, WebDriver driver, String text) {
		// TODO Auto-generated method stub
		
	}

	

}
