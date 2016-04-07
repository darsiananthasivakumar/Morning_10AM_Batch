package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Hms_popupwindow {
	public WebDriver driver;
	public void openURL(){

		driver=new FirefoxDriver();
		driver.get("http://selenium4testing.com/hms");
		driver.manage().window().maximize();
		
	}
	public void login(){
		driver.findElement(By.name("username")).sendKeys("user1");
		driver.findElement(By.name("password")).sendKeys("user1");
    	driver.findElement(By.name("submit")).click();
		}
	public void popupwindow() throws Exception{

		String str;
		str=driver.getWindowHandle();
		
		driver.findElement(By.xpath(".//*[@id='navigation']/li[3]/a")).click();
		Thread.sleep(1000);
		driver.switchTo().window("mywindow");
		driver.findElement(By.id("name")).sendKeys("babu");
		driver.findElement(By.id("email")).sendKeys("svusudheer@gmail.com");
		new Select(driver.findElement(By.id("car"))).selectByVisibleText("Mercedes");
		driver.findElement(By.name("radio")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div/div/form/ul/li[5]/label/input")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div/div/form/ul/li[6]/input")).sendKeys("F:\\download.jpg");
		driver.findElement(By.id("message")).sendKeys("sudheer hi");
		driver.findElement(By.className("action")).click();
		Thread.sleep(1000);
		driver.switchTo().window(str);
		driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/ul/li[2]/a")).click();
		
		}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Hms_popupwindow h=new Hms_popupwindow();
		h.openURL();
		h.login();
		h.popupwindow();
	}

}
