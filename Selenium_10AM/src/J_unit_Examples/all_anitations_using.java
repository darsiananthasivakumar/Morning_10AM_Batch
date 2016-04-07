package J_unit_Examples;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class all_anitations_using {
	public WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("started");
		System.setProperty("webdriver.chrome.driver", "D:\\library\\chromedriver.exe");
		}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("ended");
	}

	@Before
	public void setUp() throws Exception {
		driver=new ChromeDriver();
		driver.get("http://selenium4testing.com/");
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		driver.findElement(By.id("closediv")).click();
		driver.findElement(By.linkText("Manual FAQs")).click();
			}

}
