package Sikuli;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

public class HMS_upload {
	public WebDriver driver;
	public Screen s=new Screen();
	public void login(){
		driver.findElement(By.name("username")).sendKeys("user1");
		driver.findElement(By.name("password")).sendKeys("user1");
    	driver.findElement(By.name("submit")).click();
		}
	public void reg() throws Exception{
		 driver.findElement(By.linkText("Registration")).click();
		  driver.findElement(By.linkText("Permanent Registration")).click();
		  Thread.sleep(1000);
	}
  @Test
  public void f() throws Exception {
	  login();
	  reg();
	  s.click("F:\\sikuli.sikuli\\1436375413876.png");
	  s.click("F:\\sikuli.sikuli\\1436375469662.png");
	  s.type("F:\\sikuli.sikuli\\1436376016593.png","download.jpg");
	  s.click("F:\\sikuli.sikuli\\1436375585792.png");
	  
  }
  @BeforeTest
  public void beforeTest() {
	  driver=new FirefoxDriver();
		driver.get("http://selenium4testing.com/hms");
		driver.manage().window().maximize();
		
  }

}
