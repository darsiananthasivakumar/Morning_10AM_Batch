package J_unit_Examples;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class j_unit1 {
	public WebDriver driver;

	@Before
	public void setUp() throws Exception {
	driver=new FirefoxDriver();
	driver.get("http://spicejet.com/");
	driver.manage().window().maximize();
	
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() throws Exception {
		
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Belgaum (IXG)")).click();
		driver.findElement(By.linkText("Chennai (MAA)")).click();
	}

}
