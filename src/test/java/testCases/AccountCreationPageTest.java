package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjects.AccountCreationPage;
import pageObjects.HomePage;
import pageObjects.IndexPage;
import pageObjects.LoginPage;

public class AccountCreationPageTest extends BaseClass{
	public IndexPage indexpage;
	public LoginPage loginpage;
	public AccountCreationPage accountCreationPage;
	
	@BeforeMethod
	public void setup() {
		launchApp();
		

	}
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	@Test
	public void verifyCreateAccountPageTest() throws Throwable {
		indexpage = new IndexPage();
		loginpage=indexpage.clickOnSignIn();
		accountCreationPage=loginpage.createNewAccount("abhisheksmr@gmail.com");
		boolean result=accountCreationPage.validateAcountCreatePage();
		Assert.assertTrue(result);
		
	}
}
