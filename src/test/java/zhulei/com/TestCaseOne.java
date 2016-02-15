package zhulei.com;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import com.zhulei.page.MagentoHomePage;
import com.zhulei.page.MobilePage;


public class TestCaseOne extends DriverStart {
	
	public static final String BASE_URL="http://live.guru99.com/";
	
	@Test
	@Parameters({"sortby"})
	public void VerifyMobilePage(String sortby) {
			    
		MagentoHomePage page=PageFactory.initElements(driver, MagentoHomePage.class);
		String homeTitle=PageUtils.getTitle();		
		Assert.assertEquals("Home page", homeTitle);
		page.clickMobile();
		MobilePage mobilepage=PageFactory.initElements(driver, MobilePage.class);
		String mobileTitle=PageUtils.getTitle();
		Assert.assertEquals("Mobile", mobileTitle);		
		mobilepage.sortBy(sortby);		
		System.out.println(driver.getCurrentUrl());
		Boolean result=mobilepage.checkFirstProductName("Sony Xperia");
		Assert.assertTrue(result);
		System.out.println("success");
		
	}

	@BeforeTest
	public void beforeTest() {
		
		DriverStart.startDriver("firefox");
		PageUtils.getUrl(BASE_URL);
		
	}

	@AfterTest
	public void afterTest() {
		
		driver.quit();
	}

}
