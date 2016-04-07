package Examples_TestNg;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import com.thoughtworks.selenium.webdriven.commands.GetText;

public class Bugzilla_log {
	public WebDriver driver;
  @Test
  public void Bugzilla() throws Exception {
	
      try{
    	  driver.findElement(By.linkText("Bugzilla")).click();
    	  Thread.sleep(1000);
    	  driver.navigate().to("http://selenium4testing.org/");
    	  driver.findElement(By.name("Bugzilla_login")).sendKeys("jan30selenium@gmail.com");
          driver.findElement(By.name("Bugzilla_password")).sendKeys("selenium");
          driver.findElement(By.name("GoAheadAndLogIn")).click();
          Thread.sleep(1000);
          driver.findElement(By.linkText("Search")).click();
          Thread.sleep(1000);
          driver.findElement(By.linkText("Advanced Search")).click();
          Thread.sleep(1000);
   Select s= new Select(driver.findElement(By.xpath(".//*[@id='product']")));
   s.selectByVisibleText("HMS");
   s.selectByVisibleText("Spicejet");
   List<WebElement> web=s.getAllSelectedOptions();
         System.out.println(web.size());
        for (int i = 0; i < web.size(); i++) {
        	
			System.out.println(web.get(i).getText());
		}
    	  
      }catch(Exception e){}
  
  }
  @BeforeTest
  public void beforeTest() {
	  driver=new FirefoxDriver();
	  driver.get("http://selenium4testing.com/");
	  driver.manage().window().maximize();
	  driver.findElement(By.id("closediv")).click();
  }

}
