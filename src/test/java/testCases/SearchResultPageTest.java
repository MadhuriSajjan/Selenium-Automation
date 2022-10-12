package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjects.AccountCreationPage;
import pageObjects.IndexPage;
import pageObjects.LoginPage;
import pageObjects.SearchResultPage;

public class SearchResultPageTest extends BaseClass{
	public IndexPage indexpage;
	public LoginPage loginpage;
	public AccountCreationPage accountCreationPage;
	public SearchResultPage searchresultpage;
	
	@BeforeMethod
	public void setup() {
		launchApp();
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	@Test
	public void productAvailabilityTest() throws Throwable {
		indexpage = new IndexPage();
		searchresultpage = new SearchResultPage();
		searchresultpage=indexpage.searchProduct("t-shirt");
		boolean result=searchresultpage.isProductAvailable();
		Assert.assertTrue(result);
	}
}
