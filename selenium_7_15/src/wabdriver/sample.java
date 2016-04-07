package wabdriver;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class sample {
	public WebDriver driver;
  @Test
  public void f() {
	  driver.findElement(By.id("lst-ib")).sendKeys("selenium");
	 String str=driver.findElement(By.xpath("html/body/div/div[3]/form/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]")).getText();
	 System.out.println(str);
	 String s[]=str.split("\n");
	 for (int i = 0; i < s.length; i++) {
		 if(s[i].equalsIgnoreCase("selenium tutorial")){
			 System.out.println(s[i]);
			 driver.findElement(By.id("lst-ib")).clear();
			 driver.findElement(By.id("lst-ib")).sendKeys(s[i]);
		 }
		 
		
	}
	  
  }
  @BeforeTest
  public void beforeTest() {
	  driver=new FirefoxDriver();
	  driver.get("https://www.google.co.in");
  }

  @AfterTest
  public void afterTest() {
  }

}
