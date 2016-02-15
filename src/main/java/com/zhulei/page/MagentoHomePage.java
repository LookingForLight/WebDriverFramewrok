package com.zhulei.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import zhulei.com.DriverStart;
import zhulei.com.PageUtils;



public class MagentoHomePage extends DriverStart {
	
	
	
	@FindBy(className="level0")
	public WebElement mobile;
	
	public String getCurTitle(){
		
		return PageUtils.getTitle();
	}
	
	public void clickMobile(){
		
		mobile.click();
	}

}
