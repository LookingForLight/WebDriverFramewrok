package com.zhulei.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import zhulei.com.DriverStart;

public class SonyDetailPage extends DriverStart{
	
	@FindBy(className="price")
	WebElement price;
	
	
	public String getCost(){
		
		String cost = price.getText();
		
		return cost;
	}
}
