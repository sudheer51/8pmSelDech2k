package com.h2k.mvn;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.h2k.rmnot.pages.HomePage;
import com.h2k.rmnot.pages.ProductDealsPage;
import com.h2k.utility.BaseClass;

import jxl.read.biff.BiffException;

public class RetailMeNotTests extends BaseClass{

	@DataProvider(name="DP")
	public String[][] feedDP() throws BiffException, IOException
	{
		String arr[][] = readXlsFile();
		System.out.println("Array Length::" + arr.length);
		return arr;
	}
	@Test(dataProvider="DP")
	public void validateCategoryInformation(String cName,String cID,String cCount)
	{
		HomePage hPage= new HomePage(driver);
		hPage.navigateToProductDealsPage();
		
		ProductDealsPage dealsPage = new ProductDealsPage(driver);
		int actual = dealsPage.getItemDealsCount(cName,cID);
		int expected =Integer.parseInt(cCount);//Covert a string to a Integer
		Assert.assertEquals(actual, expected);
	
	}
}
