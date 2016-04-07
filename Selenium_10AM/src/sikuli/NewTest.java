package sikuli;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class NewTest {
	public WebDriver driver;
	Screen s=new Screen();
  @Test
  public void f() throws Exception {
	  s.hover("D:\\sikuli.sikuli\\1433501948262.png");
	  s.click("D:\\sikuli.sikuli\\cargo.png");
	  
	  
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
