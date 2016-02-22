package zhulei.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import zhulei.com.DriverStart;

import com.gargoylesoftware.htmlunit.Page;
import com.zhulei.page.MagentoHomePage;
import com.zhulei.page.MobilePage;


public class TestCaseOne extends DriverStart {
	
	public static final String BASE_URL="http://live.guru99.com/";
	
	/* Verfiy item in mobile list page can be sorted by Price
	 * Step:
	 * 1.go to http://live.gruru99.com
	 * 2.verify the title of the page
	 * 3.click on mobile menu
	 * 4.verify the title of the page
	 * 5.in the list of all mobile,select "SORT BY" dropdwon as "name"
	 * 6.verify all products are sorted by name
	 */
	@Test
	//@Parameters({"sortby"})
	public void VerifyMobilePage() {

		MagentoHomePage page=PageFactory.initElements(driver, MagentoHomePage.class);
		
		String homeTitle=PageUtils.getTitle();		
		Assert.assertEquals("Home page", homeTitle);
		page.clickMobile();
		MobilePage mobilepage=PageFactory.initElements(driver, MobilePage.class);
		String mobileTitle=PageUtils.getTitle();
		Assert.assertEquals("Mobile", mobileTitle);		
		mobilepage.sortBy("Name");		
		System.out.println(driver.getCurrentUrl());
		Boolean result=mobilepage.checkFirstProductName("IPHONE");
		Assert.assertTrue(result);
		System.out.println("success");
		
	}

	@BeforeClass
	@Parameters({"browser"})
	public void setup(String browser) {
		
		DriverStart.startDriver("chrome");
		//System.out.println(Thread.currentThread().getId());
		PageUtils.getUrl(BASE_URL);

		
	}

	@AfterClass
	public void close() {
		
		driver.quit();
	}

}
