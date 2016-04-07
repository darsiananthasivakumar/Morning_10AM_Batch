package Examples_TestNg;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class parintall_drop_text_bu_radio_ch_link {
	public WebDriver driver;
  @Test
  public void printall() {
	  
	List<WebElement> str=driver.findElements(By.tagName("a"));
	System.out.println(str.size());
	for (int i = 0; i < str.size(); i++) {
		if(!str.get(i).getText().equalsIgnoreCase("")){
		System.out.println("print all links"  +str.get(i).getText());
		}
	}
	List<WebElement> str1=driver.findElements(By.tagName("select"));
	System.out.println(str1.size());
	for (int i = 0; i < str1.size(); i++) {
		System.out.println("drop down loc is"+str1.get(i).getAttribute("name"));
	}
	List<WebElement> str2=driver.findElements(By.tagName("input"));
	System.out.println(str2.size());
	for (int i = 0; i < str2.size(); i++) {
		if(str2.get(i).getAttribute("type").equalsIgnoreCase("text")){
			System.out.println("textbox loc is"+str2.get(i).getAttribute("name"));
		}
		else if(str2.get(i).getAttribute("class").equalsIgnoreCase("log")){
			System.out.println("button loc is"+str2.get(i).getAttribute("value"));
		}
		else if(str2.get(i).getAttribute("type").equalsIgnoreCase("radio")){
			System.out.println("radio buttons loc is"+str2.get(i).getAttribute("id"));
		}
		else if(str2.get(i).getAttribute("type").equalsIgnoreCase("checkbox")){
			System.out.println("check box loc is"+str2.get(i).getAttribute("id"));
		}
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
