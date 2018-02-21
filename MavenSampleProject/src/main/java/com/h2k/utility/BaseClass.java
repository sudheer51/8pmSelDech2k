package com.h2k.utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class BaseClass {
	protected WebDriver driver;
	@Parameters({ "browserType","url"})
	@BeforeClass
	public void invokeBrowser(String browserType,String url)
	{

		if(browserType.equals("FF"))
		{
			System.out.println("in FF");
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browserType.equals("CH"))
		{  	System.out.println("in CH");
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		}
		else
		{
			System.out.println("in IE");
			System.setProperty("webdriver.ie.driver","IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.get(url);
	}
 
	public String[][] readXlsFile() throws BiffException, IOException {

		File f = new File("DealsInfo.xls");
		Workbook wb = Workbook.getWorkbook(f);

		//Sheet sheet = wb.getSheet("sanity");
		Sheet sheet = wb.getSheet(0);

		int rows = sheet.getRows();
		int cols = sheet.getColumns();
		System.out.println(rows);
		System.out.println(cols);

		String data[][] = new String[rows-1][cols];
		int k=0;
		for(int i = 1; i<rows;i++)
		{
			for(int j=0;j<cols;j++)
			{
				data[k][j]=sheet.getCell(j, i).getContents();
				System.out.println(" k :: " + k );
				System.out.println(" j::: "  + j );
				System.out.println(data[k][j]);
			}
			k++;
		}
		return data;
	}
}


