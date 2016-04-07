package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class spice_About {
	public WebDriver driver;
  @Test
  public void spice() throws Exception {
	  Actions a=new Actions(driver);
	  a.moveToElement(driver.findElement(By.linkText("About Us"))).build().perform();
	  Thread.sleep(1000);
	  a.moveToElement(driver.findElement(By.linkText("Cargo"))).click();
	  a.keyDown(Keys.CONTROL).sendKeys(Keys.END).build().perform();
	  Thread.sleep(1000);
	  a.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).build().perform();	  
  }
  @BeforeTest
  public void beforeTest() {
	  driver=new FirefoxDriver();
	  driver.get("http://spicejet.com/");
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
  }

}
