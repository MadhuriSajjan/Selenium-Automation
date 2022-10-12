package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjects.HomePage;
import pageObjects.IndexPage;
import pageObjects.LoginPage;

public class HomePageTest extends BaseClass{
	
	public IndexPage indexpage;
	public LoginPage loginpage;
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
	public void WishlistTest() throws Throwable {
		indexpage = new IndexPage();
		loginpage=indexpage.clickOnSignIn();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));	
		boolean result=homepage.validateMyWishList();
		Assert.assertTrue(result);
	
	}
	@Test
	public void orderHistoryandDetailsTest() throws Throwable {
		indexpage = new IndexPage();
		loginpage=indexpage.clickOnSignIn();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));	
		boolean result=homepage.validateOrderHistory();
		Assert.assertTrue(result);
	
	}
}
