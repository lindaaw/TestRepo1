package com.AutoPrac.Testcases;

import org.testng.Assert;
import com.AutoPrac.Pages.BasePage;
import com.AutoPrac.Pages.objDressesPage;
import com.AutoPrac.Pages.objHomePage;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

public class tstDressesPage
{
	objDressesPage odp;
	BasePage bp;
	objHomePage ohp;
	
		public tstDressesPage()
		{
			odp = new objDressesPage();
			bp = new BasePage();
			ohp = new objHomePage();
		}
	
	@BeforeClass
	public void navigateToDressesTab() throws Exception
	{
		ohp.dressesTabNavigation();
		Thread.sleep(3000);
	}
		
	@Test(enabled = false)
	public void verifySizesDisplay()
	{
		Assert.assertTrue(odp.sizeDisplayS(), "Failed: Size S not displayed.");
		Assert.assertTrue(odp.sizeDisplayM(), "Failed: Size M not displayed.");
		Assert.assertTrue(odp.sizeDisplayS(), "Failed: Size L not displayed.");
	}
	
	@Test
	public void verifyProductCount()
	{
		Assert.assertEquals(odp.pdtCountText(), odp.pdtDisplayGrid());
	}
	
	@Test
	public void verifyProdAddToCart()
	{
		odp.AddFirstObject();
		Assert.assertTrue(odp.PdtSuccessfullyAddedNotif(), "Failed: Product not successfully added.");
		odp.proceedToCheckout();
		Assert.assertEquals(odp.pdtCart(), 1);
	}
	
}
