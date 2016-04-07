package Examples_TestNg;

import java.util.List;

import org.apache.commons.exec.ExecuteException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class List_type_printalllinks {
	public WebDriver driver;
	
  @Test
  public void pritalllinks() {
List<WebElement> str=driver.findElements(By.tagName("a"));
System.out.println(str.size());
		String s[]=new String[str.size()];
		for (int i = 0; i < s.length; i++) {
			s[i]=str.get(i).getText();
			
		}
	
		for (int i = 0; i < s.length; i++) {
			
			try{
				if(s[i].equalsIgnoreCase("")){
					driver.findElement(By.linkText(s[i])).click();
				    System.out.println(i+"  "+s[i]);
					System.out.println("clicked");
					driver.get("http://spicejet.com/");
				}
				
			}catch(Exception e){}
			
		}
	
  }
  @BeforeTest
  public void beforeTest() {
	  driver=new FirefoxDriver();	 
	  driver.get("http://spicejet.com/");
  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
  }

}
