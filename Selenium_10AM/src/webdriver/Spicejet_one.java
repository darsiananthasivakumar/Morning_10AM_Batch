package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Spicejet_one {
	public WebDriver d;
	public void openURL(){
		d=new FirefoxDriver();
		d.get("http://spicejet.com/");
		d.manage().window().maximize();
		
	}
	public void onewaysearch() throws Exception{

		d.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		d.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		d.findElement(By.linkText("Hyderabad (HYD)")).click();
		Thread.sleep(1000);
	    d.findElement(By.linkText("Bengaluru (BLR)")).click();
		d.findElement(By.linkText("29")).click();
		Thread.sleep(1000);
		new Select(d.findElement(By.id("ctl00_mainContent_ddl_Adult"))).selectByVisibleText("2 Adults");
		new Select(d.findElement(By.id("ctl00_mainContent_ddl_Child"))).selectByVisibleText("1 Child");
		new Select(d.findElement(By.id("ctl00_mainContent_ddl_Infant"))).selectByVisibleText("0 Infant");
		//d.findElement(By.id("ctl00_mainContent_chk_StudentDiscount")).click();
		d.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
		
	
		
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Spicejet_one s=new Spicejet_one();
		s.openURL();
		s.onewaysearch();
		

	}

}
