package Selenium_Testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Gmail_Create {
	public WebDriver driver;
  @Test
  public void f() throws Exception {
	  
	  driver.findElement(By.linkText("Create account")).click();
	  driver.findElement(By.id("FirstName")).sendKeys("sudheer");
	  driver.findElement(By.id("LastName")).sendKeys("babu143");
	
	  driver.findElement(By.id("GmailAddress")).sendKeys("sudheerselenium");
	  Thread.sleep(20000);
	  
	  driver.findElement(By.id("password-label")).sendKeys("995948215");
	  driver.findElement(By.id("confirm-password-label")).sendKeys("9959482215");
	  
	  driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div/form/div[5]/fieldset/label[1]/span/div/div[1]")).click();
	 
	  driver.findElement(By.xpath("html/body/div[1]/div[2]/div/div[1]/div/form/div[5]/fieldset/label[1]/span/div[2]/div[5]/div")).sendKeys("February");
	  Thread.sleep(20000);
	  driver.findElement(By.name("BirthDay")).sendKeys("30");
	  Thread.sleep(1000);
	  driver.findElement(By.id("BirthYear")).sendKeys("1990");
	  Thread.sleep(1000);
	  driver.findElement(By.xpath(".//*[@id='Gender']/div[1]")).click();
	  
	  driver.findElement(By.xpath("html/body/div[1]/div[2]/div/div[1]/div/form/div[6]/label/div/div[2]/div[2]")).sendKeys("Male");
	  
	  
	  
  }
  @BeforeTest
  public void beforeTest() {
	  driver=new FirefoxDriver();
	  driver.get("https://accounts.google.com/");
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
  }

}
