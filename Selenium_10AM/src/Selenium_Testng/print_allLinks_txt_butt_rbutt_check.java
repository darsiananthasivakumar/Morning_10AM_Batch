package Selenium_Testng;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class print_allLinks_txt_butt_rbutt_check {
	public WebDriver driver;
  @Test(enabled=false)
  public void f() {
	  List<WebElement> str=driver.findElements(By.tagName("a"));
	  System.out.println(str.size());
	  int k=0;// links counte in all links sub links 
	  for (int i = 0; i < str.size(); i++) {
		  if(!str.get(i).getText().equalsIgnoreCase("")){
			  System.out.println("print All Links:"+str.get(i).getText());
			  k=k+1;
			  
		  }
		  
		  System.out.println(k);//links counte in all links sub links 
	}
	  
  }
  @Test
  public void g(){
	  List<WebElement> str1=driver.findElements(By.tagName("input"));
	  System.out.println(str1.size());
	  for (int i = 0; i <str1.size(); i++) {
		 System.out.println("drop down loc:"+str1.get(i).getAttribute("name"));
		  
		  if(str1.get(i).getAttribute("type").equalsIgnoreCase("text")){
			  System.out.println("textBox loc is:"+str1.get(i).getAttribute("name"));
			  
		  }
		  else if(str1.get(i).getAttribute("class").equalsIgnoreCase("log")){
			  System.out.println("Buttons loc is:"+str1.get(i).getAttribute("value"));
			  
			   }
		  else if(str1.get(i).getAttribute("type").equalsIgnoreCase("radio")){
			  System.out.println(" radio Buttons loc is:"+str1.get(i).getAttribute("id"));
			  
		  }
		  else if(str1.get(i).getAttribute("type").equalsIgnoreCase("checkbox")){
			  System.out.println(" checkbox loc is:"+str1.get(i).getAttribute("id"));
			  
	}
	  }
  }
  @BeforeTest
  public void beforeTest() {
	  driver=new FirefoxDriver();
		driver.get("http://spicejet.com");
		driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
  }

}
