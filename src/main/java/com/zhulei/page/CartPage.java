package com.zhulei.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
	public void changeQty(String value){
		PageUtils.clickElement(qty);
		PageUtils.inputText(qty, "10000");
		PageUtils.clickElement(updateqty);
	}
	
	public void checkError(){
		
		String s=errormsg.getText();
		if (s.contains("The maximum quantity allowed for purchase is 500.")){
			
			System.out.println("checkerror");
		}
	}
	
}
