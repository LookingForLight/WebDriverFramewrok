package com.zhulei.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import zhulei.com.DriverStart;

public class SonyDetailPage extends DriverStart{
	
	@FindBy(className="price")
	WebElement price;
	
	
	public String getCost(){
		wait.until(ExpectedConditions.visibilityOf(price));
		String cost = price.getText();
		System.out.println("sony cost is"+cost);
		return cost;
	}
}
