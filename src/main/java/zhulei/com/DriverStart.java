package zhulei.com;
/*
 * 启动webdriver类
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverStart {
	
	public static WebDriver driver;
	
	public static WebDriverWait wait;
	
	//传递不同参数启动不同webdriver
	public static void startDriver(String device){
		
		
		if (device.equals("firefox")){
			
			ProfilesIni allProfiles = new ProfilesIni();
			FirefoxProfile profile = allProfiles.getProfile("Selenium");
			driver = new FirefoxDriver(profile);
			wait = new WebDriverWait(driver, 10);
			
		}
		
		if (device.equals("ie")){
			
			System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer.exe");
			DesiredCapabilities iecapability = DesiredCapabilities.internetExplorer();
			iecapability.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			driver = new InternetExplorerDriver(iecapability);
			wait = new WebDriverWait(driver, 10);
		}
		if (device.equals("chrome")){
			
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			ChromeOptions chromeOpt = new ChromeOptions();
			chromeOpt.addArguments("test-type");
			//chromeOpt.addArguments("start-maximized");
//	        chromeOpt.setExperimentalOption("excludeSwitches", "ignore-certificate-errors");
            DesiredCapabilities chromecapability = DesiredCapabilities.chrome();
            chromecapability.setCapability(ChromeOptions.CAPABILITY,chromeOpt);						
			driver = new ChromeDriver(chromecapability);	
			wait = new WebDriverWait(driver, 10);
		}
		
		
	}

}
