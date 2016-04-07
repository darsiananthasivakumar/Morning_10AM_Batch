package Io_stream;

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

public class frist_Io_stream {
	public WebDriver driver;
  @Test
  public void login_txt() throws Exception {
	  FileInputStream fi=new FileInputStream("D:\\Test data\\login.xls");
	  Workbook w=Workbook.getWorkbook(fi);
	  Sheet s=w.getSheet(0);
	  driver.findElement(By.name("username")).sendKeys(s.getCell(0,1).getContents());
	  driver.findElement(By.name("password")).sendKeys(s.getCell(1,1).getContents());
	  driver.findElement(By.name("submit")).click();
	  
  }
  @BeforeTest
  public void beforeTest() {
	  driver=new FirefoxDriver();
	  driver.get("http://selenium4testing.com/hms/");
  }

  @AfterTest
  public void afterTest() {
  }

}
