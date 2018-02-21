package com.h2k.rmnot.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductDealsPage {
	WebDriver driver;
	public ProductDealsPage(WebDriver driver)
	{
		this.driver = driver;
	}
	public int getItemDealsCount(String categoryName,String categoryID)
	{
		driver.findElement(By.linkText(categoryName)).click();
		List<WebElement> itemList = driver.findElements(By.xpath("//section[@id='"+categoryID+"']/div/div"));
		return itemList.size();
	 
	}

}
