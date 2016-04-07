package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class slik_Grid {
	public WebDriver driver;
  @Test
  public void slick() throws Exception {
	  driver=new FirefoxDriver();
	 
	  Actions a=new Actions(driver);
	  Screen s=new Screen();
	  driver.get("http://mleibman.github.io/SlickGrid/examples/example4-model.html");
	  driver.manage().window().maximize();
	  Thread.sleep(1000);
	  s.click("F:\\sikuli.sikuli\\1436937706015.png");
	 
	  
	  for (int i = 0; i <=20; i++) {
		String str= driver.findElement(By.xpath(".//*[@id='myGrid']")).getText();
		System.out.println(str);
		a.moveToElement(driver.findElement(By.xpath(".//*[@id='myGrid']"))).sendKeys(Keys.PAGE_DOWN).build().perform();
		System.out.println("printed................."+i);
		
	}
	  
  }
  @BeforeTest
  public void beforeTest() {
	  
  }

  @AfterTest
  public void afterTest() {
  }

}
