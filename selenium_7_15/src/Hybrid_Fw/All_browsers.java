package Hybrid_Fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class All_browsers {
	public WebDriver driver;
	public void onewaysearch() throws Exception{
		
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.linkText("Hyderabad (HYD)")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Bengaluru (BLR)")).click();
		driver.findElement(By.linkText("15")).click();
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Adult"))).selectByVisibleText("1 Adult");
		new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Child"))).selectByVisibleText("2 Children");
		new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Infant"))).selectByVisibleText("1 Infant");
		//d.findElement(By.id("ctl00_mainContent_chk_StudentDiscount")).click();
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
	}
  @Test
  public void f() throws Exception {
	  onewaysearch();
	    }
  @Parameters("browser")
  @BeforeTest
  public void beforeTest(String str) {
	  if(str.equalsIgnoreCase("firefox")){
	  driver=new FirefoxDriver();
	  driver.get("http://spicejet.com/");
	  }
	  else if(str.equalsIgnoreCase("chrome")){
		  System.setProperty("webdriver.chrome.driver","D:\\library\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.get("http://spicejet.com/");
	  }
	  else if(str.equalsIgnoreCase("ie")){
		  System.setProperty("webdriver.ie.driver","D:\\library\\IEDriverServer.exe" );
			driver=new InternetExplorerDriver();
			driver.get("http://spicejet.com/");
		}
	  }
	  
  

  @AfterTest
  public void afterTest() {
  }

}
