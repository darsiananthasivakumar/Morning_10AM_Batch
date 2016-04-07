package Selenium_Testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class GetFirstselect_testng {
	public WebDriver driver;
  @Test
  public void f() {
	  WebElement str=new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Adult"))).getFirstSelectedOption();
	  if(str.getText().equalsIgnoreCase("1 Adult")){
		  System.out.println(str.getText());
		  new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Adult"))).selectByVisibleText(str.getText());
		  
	  }
	 
  }
  @BeforeTest
  public void beforeTest() {
	  driver=new FirefoxDriver();
		driver.get("http://spicejet.com");
		driver.manage().window().maximize();
		
  }

  @AfterTest
  public void afterTest() {
  }

}
