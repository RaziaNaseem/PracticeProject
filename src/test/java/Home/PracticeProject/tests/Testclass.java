package Home.PracticeProject.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Home.PracticeProject.abstracttest.parentTestClass;
import Home.PracticeProject.pageObjects.CartPage;
import Home.PracticeProject.pageObjects.CheckoutPage1;
import Home.PracticeProject.pageObjects.CheckoutPage2;
import Home.PracticeProject.pageObjects.LoginPage;
import Home.PracticeProject.pageObjects.OrderConfirmationPage;
import Home.PracticeProject.pageObjects.ProductCatalog;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Testclass extends parentTestClass {
	
	@Test(dataProvider ="getData")
	public void submitOrder(HashMap<String,String> input) throws InterruptedException, IOException 
	{

		String productName = input.get("product");
		String firstname = "john";
		String lastname = "peter";
		String pcode = "560022";
		
		
		ProductCatalog productCatalog =login.logIntoApplication(input.get("username"), input.get("password"));
		

		productCatalog.addProductToCart(input.get("product"));
		CartPage cartpage = productCatalog.goToCartPage();
		
		Assert.assertTrue(cartpage.verifyProductDisplay(productName));
		CheckoutPage1 checkoutpage1 = cartpage.checkoutCart();
		checkoutpage1.enterShippingDetails(firstname, lastname, pcode);
	
		CheckoutPage2 checkoutpage2 = checkoutpage1.continuetocheckout();
		OrderConfirmationPage ocp = checkoutpage2.finishcheckout();
		Assert.assertEquals(ocp.getTextInOrderPage(),"THANK YOU FOR YOUR ORDER");
		
	
	}
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		
		List<HashMap<String,String>> data =getJsonDataToMap("E:\\Eclipse workspace\\PracticeProject\\src\\test\\java\\Home\\PracticeProject\\data\\orderData.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}
	
	
	
	
}



