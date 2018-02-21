package com.h2k.rmnot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) 
	{
		this.driver = driver;
	
	}
	public void navigateToProductDealsPage()
	{
		driver.findElement(By.xpath(".//*[@id='top']/div/nav/ul/li[3]/a/span")).click();
		driver.findElement(By.xpath(".//*[@id='top']/div/nav/ul/li[1]/div/div/a")).click();
		driver.findElement(By.linkText("Product Deals")).click();
	}

}
