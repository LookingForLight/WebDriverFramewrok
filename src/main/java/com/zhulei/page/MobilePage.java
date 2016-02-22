package com.zhulei.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.internal.PackageUtils;

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
	
	@FindBy(className="link-compare")
	List<WebElement> comparelinks;
	
	@FindBy(xpath="//h2/a[@title='IPhone']")
	WebElement iphone;
	
	@FindBy(xpath="//h2/a[@title='Sony Xperia']")
	WebElement sony;
	
	@FindBy(css="button[title='Compare']")
	WebElement compare;
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
		wait.until(ExpectedConditions.elementToBeClickable(cartbt));
		cartbt.click();
		
	}
	
	public Boolean AddProductionToCompare() {
		Boolean sign = false;
		wait.until(ExpectedConditions.visibilityOfAllElements(comparelinks));
		String iphonetext=iphone.getText();
		//String sonytext=sony.getText();
		comparelinks.get(0).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		comparelinks.get(2).click();
		
		wait.until(ExpectedConditions.visibilityOf(compare));
		compare.click();
		
		PageUtils.switchToWindow();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='product_comparison']/tbody[1]/tr[1]/td[2]/h2/a")));
		String popiphonetext=driver.findElement(By.xpath("//*[@id='product_comparison']/tbody[1]/tr[1]/td[2]/h2/a")).getText();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='Close Window']")));
		if(iphonetext.equalsIgnoreCase(popiphonetext)){
			
			System.out.println("true");
			driver.findElement(By.xpath("//button[@title='Close Window']")).click();
			sign = true;
		}
		return sign;
	}
}
