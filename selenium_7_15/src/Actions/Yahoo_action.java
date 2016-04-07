package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Yahoo_action {
	public WebDriver driver;
  @Test
  public void yahoo() throws Exception {
	  Actions a=new Actions(driver);
	  driver.findElement(By.id("login-username")).sendKeys("svusudheer");
	  driver.findElement(By.id("login-passwd")).sendKeys("upendhra123");
	  driver.findElement(By.name("signin")).click();
	  Thread.sleep(30000);
	  driver.findElement(By.linkText("Mail")).click();
	  Thread.sleep(30000);
	  try{
		  a.moveToElement(driver.findElement(By.xpath("/html/body/div[5]/div[3]/table/tbody/tr/td[3]/ul/li[2]/a/b"))).build().perform();
		  Thread.sleep(30000);
		  a.moveToElement(driver.findElement(By.xpath("/html/body/div[5]/div[3]/table/tbody/tr/td[3]/ul/li[2]/div/div/div/ul[2]/li/a"))).click();
		    
	  }catch(Exception e){}
	  
	  
  }
  @BeforeTest
  public void beforeTest() {
	  driver=new FirefoxDriver();
	  driver.get("https://login.yahoo.com/");
      driver.manage().window().maximize(); 
  }

  @AfterTest
  public void afterTest() {
  }

}
