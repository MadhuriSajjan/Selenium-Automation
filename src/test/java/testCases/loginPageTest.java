package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import baseClass.BaseClass;
import pageObjects.HomePage;
import pageObjects.IndexPage;
import pageObjects.LoginPage;

public class loginPageTest extends BaseClass
{
	public LoginPage loginpage;
	public IndexPage indexpage;
	public HomePage homepage;
	@BeforeMethod
	public void setup() {
		launchApp();
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	@Test
	public void LoginTest() throws Throwable 
	{
		indexpage= new IndexPage();
		loginpage=indexpage.clickOnSignIn();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		String actualURL=homepage.getCurrURL();
		String expectedURL="http://automationpractice.com/index.php?controller=my-account";
		Assert.assertEquals(actualURL, expectedURL);
		System.out.println("user logged in successfully ");
		
	}
}
