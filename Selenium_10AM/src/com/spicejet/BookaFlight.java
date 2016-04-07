package com.spicejet;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

import com.opera.core.systems.scope.protos.ExecProtos;
import com.sun.jna.platform.FileUtils;

public class BookaFlight extends Helper {
	
	public void Verifysearch(String t,String a,String b,String c) throws Exception{
		driver.get("http:\\spicejet.com");
		driver.findElement(By.id(t)).click();
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.linkText("Hyderabad (HYD)")).click();
		Thread.sleep(1000);
	    driver.findElement(By.linkText("Bengaluru (BLR)")).click();
		driver.findElement(By.linkText("15")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("25")).click();
		new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Adult"))).selectByVisibleText(a);
		new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Child"))).selectByVisibleText(b);
		new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Infant"))).selectByVisibleText(c);
		
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
		
	}
	
  @Test(enabled=false)//description="Verify the GUI of the Bookaflight page")
  public void test01() throws Exception {
	  takecreenshot("spicejet_logo");
  }
  @Test(enabled=false)//description="Verify the availability of the fields in BookaFlight page")
  public void test02() throws Exception{
	  allfields();
  }
  @Test(enabled=false)//description="Verify the functionality of oneway radio button")
  public void test03() throws Exception{

		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
  }
  @Test(enabled=false)//description="Verify the functionality of Roundtrip radio button")
  public void test04() throws Exception{

	  driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
  }
  @Test(enabled=false)//description="Verify the availability of origons in Leaving from field")
  public void test05() throws Exception{

	  driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
  }
  @Test(enabled=false)//description="Verify the functionality of date picker field")
  public void test06() throws Exception{

	  driver.findElement(By.linkText("15")).click();
  }
  @Test(enabled=false)//description="Verify the availability of the dropdown fields with values")
  public void test07() throws Exception{
	  ACI();
  }
  @Test(enabled=false)//description="Verify the oneway search functionality with 1 adult")
  public void test08() throws Exception {
	  Verifysearch("ctl00_mainContent_rbtnl_Trip_1","1 Adult","0 Children","0 Infant");
  	  
  }
  @Test(enabled=false)//description="Verify the oneway search functionality with 2 adults and 1 child")
  public void test09() throws Exception {
	  Verifysearch("ctl00_mainContent_rbtnl_Trip_1","2 Adults","1 Child","0 Infant");
  	  
  }
  @Test(enabled=false)//description="Verify the oneway search functionality with 3 adults, 2 children and 1 infant")
  public void test10() throws Exception {
	  Verifysearch("ctl00_mainContent_rbtnl_Trip_1","3 Adults","2 Children","1 Infant");
  	  
  }

  @Test(enabled=false)//description="Verify the oneway search functionality with 9 passengers")
  public void test11() throws Exception {
	  Verifysearch("ctl00_mainContent_rbtnl_Trip_1","5 Adults","4 Children","2 Infants");
  	  
  }
  @Test(enabled=false)//description="Verify the oneway search functionality with more than 9 adults")
  public void test13() throws Exception {
	  Verifysearch("ctl00_mainContent_rbtnl_Trip_1","7 Adults","4 Children","1 Infant");
  	  
  }

  @Test(enabled=false)//description="Verify the oneway search functionality with more infant count")
  public void test14() throws Exception {
	  Verifysearch("ctl00_mainContent_rbtnl_Trip_1","1 Adults","1 Children","4 Infant");
  	  
  }
  @Test(enabled=false)//description="Verify the oneway search functionality with Student")
  public void test15() throws Exception {
	  Verifysearch("ctl00_mainContent_rbtnl_Trip_1","1 Adults","0 Children","0 Infant");
  	driver.findElement(By.id("ctl00_mainContent_chk_StudentDiscount")).click();
  	  
  }
  @Test(enabled=false)//description="Verify the oneway search functionality with indian armed forces")
  public void test16() throws Exception {
	  Verifysearch("ctl00_mainContent_rbtnl_Trip_1","1 Adults","1 Children","1 Infant");
  	driver.findElement(By.id("ctl00_mainContent_chk_IndArm")).click();
  	  
  }
  @Test(enabled=false)//description="Verify that when we select one origon from the Leaving From filed,Can we select the same destination in the Going To filed ")
  public void test17() throws Exception {
	  try{
		  driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
			driver.findElement(By.linkText("Hyderabad (HYD)")).click();
			Thread.sleep(1000);
		    driver.findElement(By.linkText("Hyderabad (HYD)")).click();
	  }catch(Exception e){}
	 
  }
  @Test(enabled=false)//description="Verify the values in Adult dropdown field ")
  public void test18() throws Exception {
	  Adults();
  	  
  }
  @Test(enabled=false)//description="Verify the values in Child dropdown field ")
  public void test19() throws Exception {
	  child();
  	  
  }
  @Test(enabled=false)//description="Verify the values in Infant dropdown field ")
  public void test20() throws Exception {
	  infant();
  	  
  }
  @Test(enabled=false)//description="Verify that user can book 10 tickets at a time ")
  public void test21() throws Exception {
	super. Verifysearch("ctl00_mainContent_rbtnl_Trip_1","5 Adults","4 Children","1 Infant");
  	  
  }
  @Test(enabled=false)//description="Verify the Roundtrip search functionality with 1 adul")
  public void test22() throws Exception {
	 Verifysearch("ctl00_mainContent_rbtnl_Trip_0","1 Adults","0 Children","0 Infant");
  	  
  }
  @Test(enabled=false)//description="Verify the Roundtrip search functionality with 2 adults and 1 child")
  public void test23() throws Exception {
	 Verifysearch("ctl00_mainContent_rbtnl_Trip_0","2 Adults","1 Children","0 Infant");
  	  
  }
  @Test(enabled=false)//description="Verify the Roundtrip search functionality with 3 adults, 2 children and 1 infant")
  public void test24() throws Exception {
	 Verifysearch("ctl00_mainContent_rbtnl_Trip_0","3 Adults","2 Children","1 Infant");
  	  
  }
  @Test(enabled=false)//description="Verify the Roundtrip search functionality with 9 adults")
  public void test25() throws Exception {
	 Verifysearch("ctl00_mainContent_rbtnl_Trip_0","7 Adults","4 Children","1 Infant");
  	  
  }
  @Test(enabled=false)//description="Verify the Roundtrip search functionality with more infant count")
  public void test28() throws Exception {
	 Verifysearch("ctl00_mainContent_rbtnl_Trip_0","1 Adults","4 Children","4 Infant");
  	  
  }
  @Test(enabled=false)//description="Verify the Roundtrip search functionality with Student")
  public void test29() throws Exception {
	 Verifysearch("ctl00_mainContent_rbtnl_Trip_0","1 Adults","0 Children","0 Infant");
	 driver.findElement(By.id("ctl00_mainContent_chk_StudentDiscount")).click();
  	  
  }
  @Test(enabled=false)//description="Verify the Roundtrip search functionality with indian armed forces")
  public void test30() throws Exception {
	 Verifysearch("ctl00_mainContent_rbtnl_Trip_0","1 Adults","1 Children","1 Infant");
	 driver.findElement(By.id("ctl00_mainContent_chk_IndArm")).click();
 	  
  }
  @Test(enabled=false)//description="Verify all the links in home page")
  public void test31() throws Exception {
List<WebElement> str=driver.findElements(By.tagName("a"));
System.out.println(str.size());
String []s= new String[str.size()]; 
for (int i = 0; i < str.size(); i++) {
	if(!str.get(i).getText().equalsIgnoreCase("")){
	System.out.println(str.get(i).getText());
	 
	s[i]=str.get(i).getText();
	System.out.println(s[i]);
	
	}
}

for (int i = 0; i < s.length; i++) {
	try{
		driver.findElement(By.linkText(s[i])).click();
		System.out.println("clicked");
		System.out.println(s[i] +"  "+s[i]);
		driver.get("http:\\spicejet.com");	
	}catch(Exception e){}
	
	
}
	
 	  
  }
  @Test(enabled=false)//description="Verify the fields in homepage")
  public void test32() throws Exception {
	links(".//*[@id='staticmainContentFullpage']/ul/li[1]/a");
	links(".//*[@id='routemapAction']");
	links(".//*[@id='staticmainContentFullpage']/ul/li[3]/a");
    
    links(".//*[@id='staticmainContentFullpage']/ul/li[4]/a");
    links(".//*[@id='staticmainContentFullpage']/ul/li[5]/a");
  
	  
		   
		 }
  @Test(enabled=false)//description="Verify the functionality of  Latest Flight Schedules in home page")
  public void test33() throws Exception {
	  links(".//*[@id='footer']/div/div[2]/ul/li[8]/a");
	  
  }
  @Test(enabled=false)//description="Verify the functionality of  Route Map in home page")
  public void test34() throws Exception {
	  links(".//*[@id='routemapAction']");
	  
	  
  }
  @Test(enabled=false)//description="Verify the functionality of  Spice Destinations link in home page")
  public void test35() throws Exception {
	  links(".//*[@id='staticmainContentFullpage']/ul/li[3]/a");
	  
	  
  }
  @Test(enabled=false)//description="Verify the functionality of  Corporate Benefit Program link in home page")
  public void test36() throws Exception {
	 click();
	 
	  
	 }
  @Test(enabled=false)//description="Verify the functionality of  Group Bookings link in home page")
  public void test37() throws Exception {
	 // driver.get("http://spicejet.com/SiteMap.aspx");
		
	  links(".//*[@id='staticmainContentFullpage']/ul/li[4]/a");
	  
	  
  }
  @Test(enabled=false)//description="Verify the functionality of  Spice Connect link in home page")
  public void test38() throws Exception {
	  driver.get("http://spicejet.com/");
s.click("F:\\sikuli.sikuli\\1436361005983.png");
	   }
  @Test(enabled=false)//description="Verify the functionality of  Spice Connect link in home page")
  public void test39() throws Exception {
	  
	   }
  @Test(description="Verify the GUI of the Select page")
  public void test40() throws Exception {
	 driver.get("http://book.spicejet.com/Select.aspx");
	  
	  takecreenshot(".//*[@id='wrapper']/div");
	  
	   }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}
