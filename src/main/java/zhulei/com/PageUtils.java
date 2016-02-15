package zhulei.com;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;


/**
 * 页面操作
 *
 */
public class PageUtils extends DriverStart{
	
	
	
	//打开目标地址
	public static void getUrl(String url){
		
		driver.get(url);
		
	}
	
	//点击目标元素
	public static void clickElement(WebElement el){
		
		el.click();
	}
	
	//获取元素
	
	public static WebElement findElement(String type,String value){
		WebElement element = null;
		if (type.equals("id")){
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(value)));
			element=driver.findElement(By.id(value));
			
		}
		if (type.equals("classname")){
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.className(value)));
			element=driver.findElement(By.className(value));
			
		}
		if (type.equals("cssSelector")){
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(value)));
			element=driver.findElement(By.cssSelector(value));
		} 
		if (type.equals("xpath")){
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(value)));
			element=driver.findElement(By.xpath(value));
		}
		if (type.equals("name")){
			wait.until(ExpectedConditions.presenceOfElementLocated(By.name(value)));
			element=driver.findElement(By.name(value));
		}
		return element;
	}
	
	//文本框输入值
	public static void inputText(WebElement el,String text){
		
		el.clear();
		el.sendKeys(text);
	}
	
	//过去当前页面的title
	public static  String getTitle(){
		
		return driver.getTitle();
	}
	
	
	//下拉框
	public static void DropDownBox(List<WebElement> elements,String text){
		
		WebElement el=elements.get(0);
		//el.click();
		Select select=new Select(el);
		//select.deselectAll();
		select.selectByVisibleText(text);
		System.out.println("select"+text);
	}
	public static void DropDownBox(List<WebElement> elements,int i,String text){
		
		WebElement el=elements.get(i);
		Select select=new Select(el);
		//select.deselectAll();
		select.selectByVisibleText(text);
	}
	
	//获取目标超链接文字
	public static String getLinkText(List<WebElement> elements){
		String text=null;
		WebElement el=elements.get(0).findElement(By.tagName("a"));
		text=el.getText();
		System.out.println("linktext is "+text);
		return text;
	}



}

