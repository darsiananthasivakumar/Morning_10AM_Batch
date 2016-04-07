package Test_ng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Ajax {
	public WebDriver driver;
  @Test
  public void f() {
	  driver.findElement(By.xpath(".//*[@id='lst-ib']")).sendKeys("selenium");
	  String str=driver.findElement(By.xpath(".//*[@id='sbtc']/div[2]/div[2]/div[1]")).getText();
	  System.out.println(str);
	  String s[]=str.split("\n");
for (int i = 0; i < s.length; i++) {
	if(s[i].equalsIgnoreCase("selenium tutorial")){
		System.out.println(s[i]);
		
	}
}
  
  
  }
  @BeforeTest
  public void beforeTest() {
	  driver=new FirefoxDriver();
	  driver.get("https://www.google.co.in");
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
  }

}
