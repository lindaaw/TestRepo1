package com.AutoPrac.Testcases;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import java.util.Random;

import org.testng.Assert;
import com.AutoPrac.Pages.BasePage;
import com.AutoPrac.Pages.objHomePage;

public class tstHomePage 
{
	BasePage bp;
	objHomePage ohp;
	int randomint = new Random().nextInt(5000);
	public String email = "a" + randomint + "@g.com";	
	
	public tstHomePage()
	{
		bp = new BasePage();
		ohp = new objHomePage();
	}
	
	@Test
	public void verifyTabDisplay()
	{
		Assert.assertTrue(ohp.checkWomenTab(), "Failed: Women tab isn't displayed");
		Assert.assertTrue(ohp.checkDressesTab(), "Failed: Dresses tab isn't displayed");
		Assert.assertTrue(ohp.checkDressesTab(), "Failed: T-Shirts tab isn't displayed");
	}
	
	@Test
	public void verifySuccessfulSubscription()
	{
		ohp.setEmailSubscription(email);
		String msg = ohp.getEmailSubscription();
		Assert.assertTrue(msg.contains("successfully"), "Failed");
	}
	
	@Test
	public void verifyTabNavigation()
	{
		Assert.assertTrue(ohp.womenTabNavigation().contains("Women"), "Failed to navigate to Women tab");
		Assert.assertTrue(ohp.dressesTabNavigation().contains("Dresses"), "Failed to navigate to Dresses tab");
		Assert.assertTrue(ohp.tShirtsTabNavigation().contains("Shirts"), "Failed to navigate to T-Shirts tab");
	}
	
	@AfterClass
	public void quit()
	{
		bp.quitDriver();
	}
}