package com.zhulei.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import zhulei.com.DriverStart;
import zhulei.com.PageUtils;

public class MobilePage extends DriverStart {

	@FindBy(tagName="select")
	List<WebElement> selectbt;
	
	@FindBy(className="product-name")
	List<WebElement> productname;
	
	public void sortBy(String value){
		
		PageUtils.DropDownBox(selectbt, value);
		
	}
	
	public Boolean checkFirstProductName(String value){
		
		List<WebElement> els=driver.findElements(By.className("product-name"));
		Boolean sign=false;
		String productName=PageUtils.getLinkText(els);
		System.out.println("productionfirst is "+ productName);
		if (productName.equalsIgnoreCase(value)){
			
			System.out.println("send value is"+value);
			sign=true;
			
		}
		return sign;
	}
}
