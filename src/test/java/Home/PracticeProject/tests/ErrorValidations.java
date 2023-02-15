package Home.PracticeProject.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Home.PracticeProject.abstracttest.Retry;
import Home.PracticeProject.abstracttest.parentTestClass;
import Home.PracticeProject.pageObjects.ProductCatalog;

public class ErrorValidations extends parentTestClass {

	@Test
	public void lockedOutUserValidation() {

		login.logIntoApplication("locked_out_user", "secret_sauce");
		Assert.assertEquals("Epic sadface: Sorry, this user has been locked out.", login.checkLogin());
	}
	
	@Test(retryAnalyzer =Retry.class)
	public void performanceGlitchUserValidation() {

		ProductCatalog productCatalog = login.logIntoApplication("performance_glitch_user", "secret_sauce");
		WebElement product = productCatalog.getProductByName("Sauce Labs Onesie");
		if(product.isDisplayed())
		{
			Assert.assertTrue(true);
		}
		else {
		
		Assert.assertTrue(false);
		}
		
	}
	

}
