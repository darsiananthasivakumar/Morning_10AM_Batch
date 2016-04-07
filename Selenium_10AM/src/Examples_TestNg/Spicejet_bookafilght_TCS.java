package Examples_TestNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Spicejet_bookafilght_TCS {
	public WebDriver driver;
	public void verifyoneway(String a,String b,String c) throws Exception{

		driver.get("http:\\spicejet.com");
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.linkText("Hyderabad (HYD)")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Bengaluru (BLR)")).click();
		driver.findElement(By.linkText("15")).click();
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Adult"))).selectByVisibleText(a);
		new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Child"))).selectByVisibleText(b);
		new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Infant"))).selectByVisibleText(c);
		//d.findElement(By.id("ctl00_mainContent_chk_StudentDiscount")).click();
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
		
	
	}
	public void verifyRoundtrip(String a,String c,String i) throws Exception{

		driver.get("http:\\spicejet.com");
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.linkText("Delhi (DEL)")).click();
		driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
		driver.findElement(By.linkText("Agartala (IXA)")).click();
		driver.findElement(By.linkText("15")).click();
		driver.findElement(By.linkText("20")).click();
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Adult"))).selectByVisibleText(a);
		new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Child"))).selectByVisibleText(c);
		new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Infant"))).selectByVisibleText(i);
		//d.findElement(By.id("ctl00_mainContent_chk_StudentDiscount")).click();
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
	
	}
  @Test(description="Verify the oneway search functionality with 1 adult")
  public void test08() throws Exception {
	  verifyoneway("1 Adult","0 Children","0 Infant");
	  
  }
  @Test(description="Verify the oneway search functionality with 2 adults and 1 child")
  public void test09() throws Exception {
	  verifyoneway("2 Adults","1 Child","0 Infant");
	  
  }
  @Test(description="Verify the oneway search functionality with 3 adults, 2 children and 1 infant")
  public void test10() throws Exception {
	  verifyoneway("3 Adults","2 Children","1 Infant");
	  
  }
  @Test(description="Verify the oneway search functionality with 9 passengers")
  public void test11() throws Exception {
	  verifyoneway("7 Adults","2 Children","1 Infant");
	  
  }
  @Test(description="Verify the Roundtrip search functionality with 1 adult")
  public void test22() throws Exception {
	  verifyRoundtrip("1 Adult","0 Children","0 Infant");
	  
  }
  @Test(description="Verify the Roundtrip search functionality with 2 adults and 1 child")
  public void test23() throws Exception {
	  verifyRoundtrip("2 Adults","1 Child","0 Infant");
	  
  }
  @Test(description="Verify the Roundtrip search functionality with 3 adults, 2 children and 1 infant")
  public void test24() throws Exception {
	  verifyRoundtrip("3 Adults","2 Children","1 Infant");
	  
  }
  @Test(description="Verify the Roundtrip search functionality with 9 adults")
  public void test25() throws Exception {
	  verifyRoundtrip("7 Adults","4 Children","1 Infant");
	  
  }
  
  
  @BeforeTest
  public void beforeTest() {
	  driver=new FirefoxDriver();
	  driver.get("http://spicejet.com/");
	  
  }

  @AfterTest
  public void afterTest() {
  }

}
