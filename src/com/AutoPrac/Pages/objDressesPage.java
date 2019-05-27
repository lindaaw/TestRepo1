package com.AutoPrac.Pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBys;
import java.util.List;
import org.openqa.selenium.interactions.Actions;

public class objDressesPage extends BasePage
{
		public objDressesPage()
		{
			PageFactory.initElements(driver, this);
		}

	@FindBy(xpath = "//*[@id=\\'ul_layered_id_attribute_group_1\\']/li[1]")
	private WebElement sizeS;
	
	@FindBy(xpath = "//*[@id=\"ul_layered_id_attribute_group_1\"]/li[1]/label/a")
	private WebElement sizeM;
	
	@FindBy(id = "layered_id_attribute_group_3")
	private WebElement sizeL;
	
	@FindBy(xpath = "//*[@id='center_column']/h1/span[2]")
	private WebElement pdtCountText;
	
	@FindBys(@FindBy(xpath = "//*[@class = 'product_list grid row']/li"))
	private List<WebElement> pdtDisplayGrid;
	
	@FindBy(xpath = "//*[@id=\'center_column\']/ul/li[1]")
	private WebElement prodOne;
	
	@FindBy(xpath = "//*[@id=\'center_column\']/ul/li[1]/div/div[2]/div[2]/a[1]/span")
	private WebElement AddToCart;
	
	@FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[1]/h2")
	private WebElement notifPdtSuccessful;
	
	@FindBy(xpath = "//*[@class = 'btn btn-default button button-medium']\"")
	private WebElement btnCheckout;
	
	@FindBys(@FindBy(id = "center_column"))
	private List<WebElement> pdtsInCart;
		
	@FindBy(xpath = "//*[@id='layer_cart']/div[1]/div[2]/div[1]")
	private WebElement checktext;
	
	Actions action = new Actions(driver);
	
	
	public Boolean sizeDisplayS()
	{
		Boolean sizeDisplayS = sizeS.isDisplayed();
		return sizeDisplayS;
	}
	
	public Boolean sizeDisplayM()
	{
		Boolean sizeDisplayM = sizeM.isDisplayed();
		return sizeDisplayM;
	}
	
	public Boolean sizeDisplayL()
	{
		Boolean sizeDisplayL = sizeL.isDisplayed();
		return sizeDisplayL;
	}
	
	public int pdtCountText()
	{
		String text = pdtCountText.getText();
		String[] arr = text.split(" ");
		String number = arr[2];
		int count = Integer.parseInt(number);
		return count;
	}
	
	public int pdtDisplayGrid()
	{
		return pdtDisplayGrid.size();
	}
	
	public void AddFirstObject()
	{
		action.moveToElement(prodOne).perform();
		AddToCart.click();
	}
	
	public Boolean PdtSuccessfullyAddedNotif()
	{
		return notifPdtSuccessful.isDisplayed();
	}
	
	public WebElement proceedToCheckout()
	{
		action.moveToElement(btnCheckout).perform();
		btnCheckout.click();
		return checktext;
	}
	
	public int pdtCart()
	{
		return pdtsInCart.size();
	}
	
}
	