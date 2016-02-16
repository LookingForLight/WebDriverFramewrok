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
	
	@FindBy(className="price-box")
	List<WebElement> pricebox;
	
	@FindBy(id="product-collection-image-1")
	WebElement sonyimage;
	
	@FindBy(css="button.button.btn-cart")
	WebElement cartbt;
	//根据选择的方法排序 position price name
	public void sortBy(String value){
		
		PageUtils.DropDownBox(selectbt, value);
		
	}
	
	//检查排序是否正确
	/*
	 * @pram value 目标元素的链接文字
	 */
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
	
	//获取SONY XPERIA 手机的价格
	public String getCostOfSony(){
		String value = PageUtils.getValueOfElement(pricebox, 2, By.className("price"));
		System.out.println("cost of Sony is"+value);
		return value;
	}
	//进入sony的详情页面
	public void goToSonyDetailPage(){
		sonyimage.click();		
	}
	
	
	public void goToCartPage(){
		
		cartbt.click();
		System.out.println("go to cartpage");
	}
}
