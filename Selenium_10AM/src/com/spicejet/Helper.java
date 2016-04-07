package com.spicejet;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Helper {
	public WebDriver driver;
	public Screen s=new Screen();
	public void Verifysearch(String t,String a,String b,String c) throws Exception{
		driver.get("http:\\spicejet.com");
		driver.findElement(By.id(t)).click();
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.linkText("Hyderabad (HYD)")).click();
		Thread.sleep(1000);
	    driver.findElement(By.linkText("Bengaluru (BLR)")).click();
		driver.findElement(By.linkText("15")).click();
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Adult"))).selectByVisibleText(a);
		new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Child"))).selectByVisibleText(b);
		new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Infant"))).selectByVisibleText(c);
		
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
		
	}
	public void takecreenshot(String str) throws Exception{
		DateFormat df=new SimpleDateFormat("yy_MMM_dd hh_mm_ss a");
		Date d=new Date();
		String time=df.format(d);
		File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f,new File("E:\\"+time+str+".png"));
		driver.findElement(By.xpath(".//*[@id='header']/div[1]/div[1]/a")).click();
		
	}
	public void allfields(){

		  List<WebElement>str=driver.findElements(By.tagName("input"));
		  System.out.println(str.size());
		  for (int i = 0; i <str.size(); i++) {
			   if(str.get(i).getAttribute("type").equalsIgnoreCase("radio")){
				  System.out.println("raido loc:"+str.get(i).getAttribute("value"));
				   }
			  
			  else if(str.get(i).getAttribute("name").equalsIgnoreCase("ctl00_mainContent_ddl_originStation1_CTXT")){
				  System.out.println("leaving dropdown loc:"+str.get(i).getAttribute("id"));
			  }
			  else if(str.get(i).getAttribute("id").equalsIgnoreCase("ctl00_mainContent_ddl_destinationStation1_CTXT")){
				  System.out.println("Going dropdown loc:"+str.get(i).getAttribute("name"));
			  }
			   }
		 
	}

	public void ACI(){
List<WebElement> str=	new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Adult"))).getOptions();
	System.out.println(str.size());
	for (int i = 0; i < str.size(); i++) {
		
		System.out.println(str.get(i).getText());
		
	}
	List<WebElement> str1=new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Child"))).getOptions();
	System.out.println(str1.size());
	for (int i = 0; i <str1.size(); i++) {
		System.out.println(str1.get(i).getText());
	}
	List<WebElement> str2=new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Infant"))).getOptions();
	System.out.println(str2.size());
	for (int i = 0; i <str2.size(); i++) {
		System.out.println(str2.get(i).getText());
	}
	
		}
			
	public void Adults(){
		List<WebElement> str=	new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Adult"))).getOptions();
		System.out.println(str.size());
		for (int i = 0; i < str.size(); i++) {
			
			System.out.println(str.get(i).getText());
			
		}
		
	}
	public void child(){
		List<WebElement> str1=new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Child"))).getOptions();
		System.out.println(str1.size());
		for (int i = 0; i <str1.size(); i++) {
			System.out.println(str1.get(i).getText());
		}
		
	}
	public void infant(){
		List<WebElement> str2=new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Infant"))).getOptions();
		System.out.println(str2.size());
		for (int i = 0; i <str2.size(); i++) {
			System.out.println(str2.get(i).getText());
		}
		
	}
	
	public void links(String str) throws Exception{
		driver.get("http://spicejet.com/SiteMap.aspx");
		
	String str1=driver.findElement(By.xpath(str)).getText();
	          
	System.out.println(str1);

		driver.findElement(By.xpath(str1)).click();
		//Thread.sleep(1000);
	
	
}
	
	public void click() throws Exception{
		try{
			 driver.get("http://spicejet.com/");
			   s.hover("F:\\sikuli.sikuli\\1436339531966.png");
			    s.click("F:\\sikuli.sikuli\\faq1.png");
			    Thread.sleep(1000);
			  driver.findElement(By.xpath(".//*[@id='toursimUL']/li[10]/a")).click();
		}catch(Exception e){}
		
	}
	
 
 
@BeforeTest
  public void beforeTest() {
	  driver=new FirefoxDriver();
		driver.get("http:\\spicejet.com");
		driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
  }

}
