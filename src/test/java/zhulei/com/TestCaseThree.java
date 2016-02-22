package zhulei.com;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.zhulei.page.CartPage;
import com.zhulei.page.MagentoHomePage;
import com.zhulei.page.MobilePage;
import com.zhulei.page.SonyDetailPage;

public class TestCaseThree extends DriverStart {

	
	/*Verify that you cannot add more productioon in cart than the production
	 * availabble in store
	 * step:
	 * 1.go to homepage
	 * 2.click on Mobile item
	 * 3.in  the list of mobile,click on "ADD TO CART" for sony
	 * 4.Change QTY value to 1000 and click update
	 * 5.Verify the error message
	 * 6.then click on "EMPTY CART" link in the footer of list of all mobiles
	 * 7
	 */
	@Test
	public void verifyProductionQty(){
		
		MagentoHomePage homepage=PageFactory.initElements(driver, MagentoHomePage.class);
		homepage.clickMobile();
		MobilePage mobilepage = PageFactory.initElements(driver, MobilePage.class);
		mobilepage.goToCartPage();
		CartPage cartpage= PageFactory.initElements(driver, CartPage.class);
		cartpage.changeQty("1000");
		Boolean checkResult = cartpage.checkError("The maximum quantity allowed for purchase is 500");
		Assert.assertTrue(checkResult, "no error appears");
		cartpage.emptyCart();
		Boolean emptyresult= cartpage.checkPageTitle("Shopping Cart is Empty");
		Assert.assertTrue(emptyresult, "not yet empty");
		PageUtils.takeScreenShot("./image", "cartpageEmpty");
		
		
	}
	
	
	@BeforeClass
	@Parameters({"browser"})
	public void setup(String browser) {
		
		DriverStart.startDriver("chrome");
		//System.out.println(Thread.currentThread().getId());
		PageUtils.getUrl(TestCaseOne.BASE_URL);

		
	}

	@AfterClass
	public void close() {
		
		driver.quit();
	}
	
}
