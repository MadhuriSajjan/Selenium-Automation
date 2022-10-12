package baseClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;

import actionDriver.Action;
import io.github.bonigarcia.wdm.WebDriverManager;




 //BaseClass is used to load the config file and Initialize WebDriver
public class BaseClass {
	public static Properties prop;
	public static WebDriver driver;
	//loadConfig method is to load the configuration
	@BeforeTest
	public void loadConfig() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\Configuration\\Config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public void launchApp() {
		WebDriverManager.chromedriver().setup();
	 String browserName = prop.getProperty("browser");
		if (browserName.equals("Chrome")) {
			//WebDriverManager.chromedriver().setup();
			//Execute chrome Webdriver
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Madhuri\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.contains("FireFox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Madhuri\\geckodriver.exe");
			driver= new FirefoxDriver();
		} else if (browserName.contains("IE")) {
			driver= new InternetExplorerDriver();
		}
		
	
		Action.implicitWait(driver, 10);
		Action.pageLoadTimeOut(driver, 30);
		
		//Maximize the screen
		driver.manage().window().maximize();
		//Delete all the cookies
		driver.manage().deleteAllCookies();
		
		//Launching the URL
		driver.get(prop.getProperty("url"));
		
		
	}

	
	
}
