package com.zhulei.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import zhulei.com.DriverStart;
import zhulei.com.PageUtils;

public class CartPage extends DriverStart {

	@FindBy(css="input[title=\"Qty\"]")
	WebElement qty;
	
	@FindBy(css="button.button.btn-update")
	WebElement updateqty;
	
	@FindBy(id="empty_cart_button")
	WebElement emptybt;
	
	@FindBy(css="p.item-msg.error")
	WebElement errormsg;
	
	@FindBy(className="page-title")
	WebElement pagetitle;
	
	public void changeQty(String value){
		PageUtils.clickElement(qty);
		PageUtils.inputText(qty, "10000");
		PageUtils.clickElement(updateqty);
	}
	
	public Boolean checkError(String value){
		Boolean sign=false;
		String s=errormsg.getText();
		if (s.contains(value)){
			sign=true;
			System.out.println("checkerror");
		}
		
		return sign;
	}
	
	public void emptyCart(){
		
		emptybt.click();
	}
	
	public Boolean checkPageTitle(String value){
		
		Boolean sign=false;
		wait.until(ExpectedConditions.visibilityOf(pagetitle));
		if (pagetitle.getText().equalsIgnoreCase(value)){
			System.out.println("page title"+pagetitle.getText());
			sign=true;
		}
		
		return sign;
	}
}
