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

public class OR_IO_Stream {
	public WebDriver  driver;
	FileInputStream fi;
	Workbook w;
	Sheet s;
	
  @Test
  public void OR_ObjectRepositry() throws Exception {
	   fi=new FileInputStream("D:\\OR(OBJECTREPOSITRY)\\OR.xls");
	   w=Workbook.getWorkbook(fi);
	   s=w.getSheet("login");
	   driver.findElement(By.name(s.getCell(0,1).getContents())).sendKeys("user1");
	   driver.findElement(By.name(s.getCell(1,1).getContents())).sendKeys("user1");
	   driver.findElement(By.name(s.getCell(2,1).getContents())).click();
	  
  }
  @Test
  public void logout(){
	  try{
		  s=w.getSheet("logout");
		  driver.findElement(By.linkText("Logout")).click();
		  System.out.println("valid");
	  }catch(Exception e){System.out.println("invalid");}
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
