package Selenium_Testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class HMS_AJAX {
	public WebDriver driver;
	@Test
	public void averifyLogin()  {  //TEST SCenarios
		  driver.findElement(By.name("username")).sendKeys("user1");
		  driver.findElement(By.name("password")).sendKeys("user1");
		  driver.findElement(By.name("submit")).click();
	  }
	@Test
	public void bverifyRegistration() throws Exception{
		  driver.findElement(By.linkText("Registration")).click();
		  driver.findElement(By.linkText("Permanent Registration")).click();
		  Thread.sleep(1000);
	  }
  @Test
  public void f() throws Exception {
	  driver.findElement(By.xpath(".//*[@id='navigation']/li[2]/a")).click();
	  driver.findElement(By.id("MR_NO")).sendKeys("PR");
	  Thread.sleep(1000);
	  String str;
      str=driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/table[1]/tbody/tr[1]/td[4]/p/div")).getText();
		 System.out.println(str);
		 String s[]=str.split("\n");
		 System.out.println(s.length);
		 for(int i=0;i<s.length;i++)
	     {
	    	 
	    	 if(s[i].equalsIgnoreCase("PR1341680337"))
	    	 {
	    		 System.out.println(s[i]);
	    		 driver.findElement(By.id("MR_NO")).clear();
	    		 driver.findElement(By.id("MR_NO")).sendKeys(s[i]);
	    	 }
	     }
	    	  }
		 
	  
  
  @BeforeTest
  public void beforeTest() throws Exception {
	  driver=new FirefoxDriver();
		driver.get("http://selenium4testing.com/hms/");
		driver.manage().window().maximize();
	
		
  }

  @AfterTest
  public void afterTest() {
  }

}
