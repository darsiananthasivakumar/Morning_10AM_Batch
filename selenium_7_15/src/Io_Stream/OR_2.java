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

public class OR_2 {
	public WebDriver driver;
	FileInputStream fi;
	Workbook w;
	Sheet s;
  @Test
  public void f() throws Exception {
	  fi=new FileInputStream("D:\\Workspace_10AM\\selenium_7_15\\1.io.xls");
	  w=Workbook.getWorkbook(fi);
	  s=w.getSheet(0);
	  driver.findElement(By.name(s.getCell(0,1).getContents())).sendKeys("user1");
	  driver.findElement(By.name(s.getCell(1,1).getContents())).sendKeys("user1");
   driver.findElement(By.name(s.getCell(2,1).getContents())).click();
  }
  @Test
  public void logout(){
	  s=w.getSheet("logout");
	  driver.findElement(By.linkText(s.getCell(0,1).getContents())).click();
	  
  }
  @BeforeTest
  public void beforeTest() {
	  driver=new FirefoxDriver();
	  driver.get("http://selenium4testing.com/hms/");
	  driver.manage().window().maximize();
  }

}
