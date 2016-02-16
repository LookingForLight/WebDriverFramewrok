package zhulei.com;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.zhulei.page.CartPage;
import com.zhulei.page.MagentoHomePage;
import com.zhulei.page.MobilePage;
import com.zhulei.page.SonyDetailPage;

public class TestCaseTwo extends DriverStart {

	
	/*Verify that cost of production in list page and details page are equal
	 * step:
	 * 1.go to homepage
	 * 2.click on Mobile item
	 * 3.in  the list of mobile,read the cost of Sony mobile,note the value
	 * 4.click on sony mobile
	 * 5.read the sony from sony detail page
	 * 6.compare value of step3 &step5
	 */
	@Test
	public void verifyCostOfProduction(){
		

		
		MagentoHomePage homepage=PageFactory.initElements(driver, MagentoHomePage.class);
		homepage.clickMobile();
		MobilePage mobilepage = PageFactory.initElements(driver, MobilePage.class);
		String cost = mobilepage.getCostOfSony();
		mobilepage.goToSonyDetailPage();
		SonyDetailPage sonypage = PageFactory.initElements(driver, SonyDetailPage.class);
		String cost1 = sonypage.getCost();
		Assert.assertTrue(cost.equalsIgnoreCase(cost1), "the value is not same");
		PageUtils.takeScreenShot("./image", "sonydetail");
		
	}
	
	
	@BeforeTest
	public void beforeTest() {
		
		DriverStart.startDriver("chrome");
		PageUtils.getUrl(TestCaseOne.BASE_URL);
		
	}

	@AfterTest
	public void afterTest() {
		
		driver.quit();
	}
	
}
