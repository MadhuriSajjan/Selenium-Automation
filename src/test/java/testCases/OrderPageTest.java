package testCases;

import org.testng.Assert;

import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjects.AddToCartPage;
import pageObjects.IndexPage;
import pageObjects.OrderPage;
import pageObjects.SearchResultPage;


public class OrderPageTest extends BaseClass {

	public IndexPage indexpage;
	public SearchResultPage searchresultpage;
	public AddToCartPage addtocartpage;
	public OrderPage orderpage;
	
	public void setup() {
		launchApp(); 
	}
	
	public void tearDown() {
		driver.quit();
	}
	@Test
	public void verifyTotalPrice() throws Throwable {
		
		indexpage= new IndexPage();
		searchresultpage=indexpage.searchProduct("t-shirt");
		addtocartpage=searchresultpage.clickOnProduct();
		addtocartpage.enterQuantity("2");
		addtocartpage.selectSize("M");
		addtocartpage.clickOnAddToCart();
		orderpage=addtocartpage.clickOnCheckOut();
		Double unitPrice=orderpage.getUnitPrice();
		Double totalPrice=orderpage.getTotalPrice();
		Double totalExpectedPrice=(unitPrice*2)+2;
		Assert.assertEquals(totalPrice, totalExpectedPrice);
		
	}
}
