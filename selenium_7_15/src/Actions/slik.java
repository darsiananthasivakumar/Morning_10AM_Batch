package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

public class slik {
	public WebDriver driver;
  @Test
  public void slikgrid() throws Exception {
	  driver=new FirefoxDriver();
	  driver.get("http://mleibman.github.io/SlickGrid/examples/example4-model.html");
	  driver.manage().window().maximize();
	  Thread.sleep(1000);
	  Actions a=new Actions(driver);
	  Screen s=new Screen();
	  s.click("F:\\sikuli.sikuli\\1436937706015.png");
	  for (int i = 0; i <10; i++) {
		  String str=driver.findElement(By.xpath(".//*[@id='myGrid']")).getText();
		  System.out.println(str);
		  a.moveToElement(driver.findElement(By.xpath(".//*[@id='myGrid']"))).sendKeys(Keys.PAGE_DOWN).build().perform();
		System.out.println(""+i);
		  
		  
		  
		
	}
	  
  }
}
