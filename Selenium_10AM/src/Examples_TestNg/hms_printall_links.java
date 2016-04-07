package Examples_TestNg;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class hms_printall_links {
	public WebDriver driver;
	public void takescreenshot() throws Exception{
		DateFormat df=new SimpleDateFormat("yyy_MMM_dd hh_mm_ss a");
		Date d=new Date();
		String time=df.format(d);
		File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(f,new File("D:\\"+time+".png"));
	}
  @Test
  public void printalllinks() throws Exception {
	 List<WebElement>str=driver.findElements(By.tagName("a"));
	 System.out.println(str.size());
	 String s[]= new String[str.size()];
	 int k =0;
	 for (int i = 0; i < str.size(); i++) {
		 s[i]=str.get(i).getText();
		 try{
			 	if(!str.get(i).getText().equalsIgnoreCase(""))	
			 		
				System.out.println(s[i]);
				k=k+1;
				
				System.out.println(k); 
		 }catch(Exception e){}
		
		
		 }
	 for (int i = 0; i < s.length; i++) {
		 try{
			 int j=0;
			 driver.findElement(By.linkText(s[i])).click();
			 j=j+1;
				System.out.println("cicked");
				System.out.println(j+"  "+s[i]);
				takescreenshot();
		  	     System.out.println(i+"  "+s[i]);
		  	     driver.get("http://selenium4testing.com/hms/master.php");
		  	   driver.findElement(By.name("username")).sendKeys("user1");
		 	  driver.findElement(By.name("password")).sendKeys("user1");
		 	  driver.findElement(By.name("submit")).click();
		 	  Thread.sleep(2000);
		       driver.get("http://selenium4testing.com/hms/master.php");
		  	  Thread.sleep(1000);
		 }catch(Exception e){}
		
  	     
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
  }

  @AfterTest
  public void afterTest() {
  }

}
