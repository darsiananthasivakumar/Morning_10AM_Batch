package wabdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Hms_Login {
	public WebDriver driver;
	public void openURL()
	{
		driver=new FirefoxDriver();
		driver.get("http://selenium4testing.com/hms/");
	}
	public void login(){
		driver.findElement(By.name("username")).sendKeys("user1");
		driver.findElement(By.name("password")).sendKeys("user1");
		driver.findElement(By.name("submit")).click();
					
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hms_Login h=new Hms_Login();
		h.openURL();
		h.login();
		
	}

}
