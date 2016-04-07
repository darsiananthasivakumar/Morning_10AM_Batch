package Selenium_Testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class HMS_EX {
	public WebDriver driver;
	public void clicklinks(String str){
		
		driver.findElement(By.linkText(str)).click();
	}
	
  @Test
  public void login() {
	  clicklinks("Manual FAQs");
	  clicklinks("Selenium FAQs");
  }
  @BeforeTest
  public void beforeTest() {
	  driver=new FirefoxDriver();
	  driver.get("http://selenium4testing.com/");
	  driver.findElement(By.id("closediv")).click();
	  
  }

  @AfterTest
  public void afterTest() {
  }

}
