package com.zhulei.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import zhulei.com.DriverStart;
import zhulei.com.PageUtils;



public class MagentoHomePage extends DriverStart {
	
	
	
	@FindBy(className="level0")
	public WebElement mobile;
	
	@FindBy(xpath="//*[@id='header']/div/div[2]/div/a/span[2]")
	WebElement account;
	
	@FindBy(css="a[title='Register']")
	WebElement register;
	
	public String getCurTitle(){
		
		return PageUtils.getTitle();
	}
	//点击mobile链接
	public void clickMobile(){
		
		mobile.click();
	}
	//点击account链接
	public void clickAccount(){
		account.click();
		register.click();
	}

}
