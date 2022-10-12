package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjects.AccountCreationPage;
import pageObjects.AddToCartPage;
import pageObjects.IndexPage;
import pageObjects.LoginPage;
import pageObjects.SearchResultPage;

public class AddToCartPageTest extends BaseClass{

	public IndexPage indexpage;
	public LoginPage loginpage;
	public AccountCreationPage accountCreationPage;
	public SearchResultPage searchresultpage;
	public AddToCartPage addtocartpage;
	@BeforeMethod
	public void setup() {
		launchApp();
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	@Test
	public void addToCartTest() throws Throwable {
		indexpage = new IndexPage();
		addtocartpage = new AddToCartPage();
		searchresultpage=indexpage.searchProduct("t-shirt");
		addtocartpage=searchresultpage.clickOnProduct();
		addtocartpage.enterQuantity("2");
		addtocartpage.selectSize("S");
		addtocartpage.clickOnAddToCart();
		boolean result=addtocartpage.validateAddtoCart();
		Assert.assertTrue(result);
		
	}
}
