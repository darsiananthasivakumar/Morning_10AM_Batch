package Examples_TestNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class HMS_printmanditoryfields {
	public WebDriver driver;
  @Test
  public void manditory() {
	  String str=driver.findElement(By.xpath("html/body/div[2]/div/div[2]")).getText();
	  System.out.println(str);
	  String s[]= str.split("");
	  System.out.println(str.length());
	  for (int i = 0; i < s.length; i++) {
		if(s[i].contains("*")){
			if(s[i].equalsIgnoreCase("Gender*")){
			System.out.println(s[i]);
			}
		}
	}
	  
  }
  @BeforeTest
  public void beforeTest() throws Exception {
	  driver=new FirefoxDriver();
	  driver.get("http://selenium4testing.com/hms/");
	  driver.manage().window().maximize();
	  driver.findElement(By.name("username")).sendKeys("user1");
	  driver.findElement(By.name("password")).sendKeys("user1");
	  driver.findElement(By.name("submit")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.linkText("Registration")).click();
	  driver.findElement(By.linkText("Permanent Registration")).click();
  }

  @AfterTest
  public void afterTest() {
  }

}
