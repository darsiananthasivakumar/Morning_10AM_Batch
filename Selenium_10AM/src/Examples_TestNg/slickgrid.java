package Examples_TestNg;

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

public class slickgrid {
	public WebDriver driver;
	
	
  @Test
  public void f() throws Exception {
	  driver=new FirefoxDriver();
	  Actions a=new Actions(driver);
	  Screen s=new Screen();
	  driver.get("http://mleibman.github.io/SlickGrid/examples/example1-simple.html");
	  s.click("D:\\slickgrid\\slick.PNG");
	  for (int i = 0; i <=20; i++) {
	String str=driver.findElement(By.xpath("html/body/table/tbody/tr/td[1]/div")).getText();
	System.out.println(str);
	Thread.sleep(1000);
	a.moveToElement(driver.findElement(By.xpath("html/body/table/tbody/tr/td[1]/div"))).sendKeys(Keys.PAGE_DOWN).build().perform();
	System.out.println("printed......................................"+i);
	}
  }

}
