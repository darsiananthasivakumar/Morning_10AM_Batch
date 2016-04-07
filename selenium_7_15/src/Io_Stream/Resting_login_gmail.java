package Io_Stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import jxl.Sheet;
import jxl.Workbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Resting_login_gmail {
	public WebDriver driver;
		String str;
  @Test
  public void f() throws Exception {
	  FileInputStream fi=new FileInputStream("D:\\Workspace_10AM\\selenium_7_15\\testdata.xls");
	  Workbook w=Workbook.getWorkbook(fi);
	  Sheet s=w.getSheet(0);
	  for (int i = 1; i < s.getRows(); i++) {
		try{
			 driver.findElement(By.id("Email")).sendKeys(s.getCell(0,i).getContents());
			  driver.findElement(By.id("next")).click();
			  Thread.sleep(1000);
			  driver.findElement(By.id("Passwd")).sendKeys(s.getCell(1,i).getContents());
			  driver.findElement(By.id("signIn")).click();
			 // Thread.sleep(10000);
			  
			  driver.findElement(By.xpath(".//*[@id='gb']/div[1]/div[1]/div[2]/div[4]/div[1]/a/span")).click();
			  driver.findElement(By.xpath(".//*[@id='gb_71']")).click();
			  //driver.findElement(By.xpath("/html/body/div/div[2]/div[3]/p[1]/a")).click();
			  //driver.findElement(By.xpath("/html/body/div/div[2]/div[3]/ul/li[1]/a")).click();
			  
			  
		}catch(Exception e){driver.findElement(By.xpath("html/body/div/div[2]/div[2]/div[2]/div/div/p[1]/span[1]/a")).click();}
		//driver.findElement(By.xpath("html/body/div/div[2]/div[3]/ul/li[1]/a")).click();}
		
			 
			 
			  
	
	
	  }

  }
  @BeforeTest
  public void beforeTest() {
	  driver=new FirefoxDriver();
	  driver.get("https://accounts.google.com");
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
  }

}
