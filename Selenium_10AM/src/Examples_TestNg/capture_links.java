package Examples_TestNg;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class capture_links {
	public WebDriver driver;
 public void takescreenshot(String str) throws Exception{
	 DateFormat df=new SimpleDateFormat("YYYY_MMM_dd hh_mm_ss a");
	 Date d=new Date();
	 String time=df.format(d);
	 File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 FileUtils.copyFile(f ,new File("E:\\"+str+time+".png"));
 }
  @Test
  public void screenshot() throws Exception {
	  driver.findElement(By.linkText("Core Java FAQs")).click();
	  takescreenshot("Core Java FAQs");
	  Thread.sleep(1000);
	  driver.findElement(By.linkText("Manual FAQs")).click();
	  takescreenshot("Manual FAQs");
  }
  @BeforeTest
  public void beforeTest() {
	  driver=new FirefoxDriver();
	  driver.get("http://selenium4testing.com/");
	  driver.findElement(By.id("closediv")).click();
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
