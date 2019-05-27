package com.AutoPrac.Pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class objHomePage extends BasePage
{
	public objHomePage()
	{
			PageFactory.initElements(driver, this);
	}
		
		@FindBy(xpath = "//*[@id='block_top_menu']/ul/li[1]/a")
		public WebElement tabWomen;
		
		@FindBy(xpath = "//*[@id=\'block_top_menu\']/ul/li[2]/a")
		private WebElement tabDresses;
		
		@FindBy(xpath = "//*[@id=\'block_top_menu\']/ul/li[3]/a")
		private WebElement tabTShirts;
		
		@FindBy(id = "newsletter-input")
		private WebElement txtNewsletterEmail;
		
		@FindBy(name = "submitNewsletter")
		private WebElement btnEmailSubmit;
		
		@FindBy(xpath = "//*[@id=\'columns\']/p")
		private WebElement msgEmailSubscription;
		
		
		public Boolean checkWomenTab()
		{
			Boolean chkWomen = tabWomen.isDisplayed();
			return chkWomen;
		}

		public Boolean checkDressesTab()
		{
			Boolean chkDresses = tabDresses.isDisplayed();
			return chkDresses;
		}
		
		public Boolean checkTShirtsTab()
		{
			Boolean chkTShirts = tabTShirts.isDisplayed();
			return chkTShirts;
		}
		
		public String womenTabNavigation()
		{
			tabWomen.click();
			String womenPageTitle = driver.getTitle();
			return womenPageTitle;
		}
		
		public String dressesTabNavigation()
		{
			tabDresses.click();
			String dressesPageTitle = driver.getTitle();
			return dressesPageTitle;
		}
		
		public String tShirtsTabNavigation()
		{
			tabTShirts.click();
			String tShirtsPageTitle = driver.getTitle();
			return tShirtsPageTitle;
		}
		
		public String getEmailSubscription() 
		{
			return msgEmailSubscription.getText();
		}
		
		public void setEmailSubscription(String email) 
		{
			setText(txtNewsletterEmail, email);
			btnEmailSubmit.click();
		}		
	}