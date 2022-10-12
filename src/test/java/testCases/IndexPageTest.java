package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjects.HomePage;
import pageObjects.IndexPage;
import pageObjects.LoginPage;

public class IndexPageTest extends BaseClass
{
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
	public void verifyShopLogo() throws Throwable {
		indexpage= new IndexPage();
		boolean result= indexpage.validateLogo();
		Assert.assertTrue(result);
	}
	
	@Test
	public void verifyTitle() {
		String actTitle=indexpage.getMyStoreTitle();
		Assert.assertEquals(actTitle, "My Store");
	}
	
}
