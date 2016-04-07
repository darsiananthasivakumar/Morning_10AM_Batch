package Io_stream;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

public class Actions_mouse {
	public WebDriver driver;
	
  @Test(enabled=false)
  public void f() throws Exception {
	  Actions a=new Actions(driver);
	  a.moveToElement(driver.findElement(By.linkText("About Us"))).build().perform();
	  Thread.sleep(1000);
	  driver.findElement(By.linkText("Cargo")).click();
	 // driver.findElement(By.xpath(".//*[@id='smoothmenu1']/ul/li[2]/ul/li[6]/a")).click();
	  a.keyDown(Keys.CONTROL).sendKeys(Keys.END).build().perform();
	  a.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).build().perform();
  }
  @Test
  public void g(){

		// TODO Auto-generated method stub
String str="one,two, three,four";
String s[]=str.split(",");
System.out.println(s.length);
	
for (int i = 0; i < s.length; i++) {
		if (s[i].equalsIgnoreCase("Three")) {
			System.out.println("number is String"+s[i]);
		}
	}
	
  }
  @BeforeTest(enabled=false)
  public void beforeTest() {
	  driver=new FirefoxDriver();
	  driver.get("http://spicejet.com/");
  }

}
