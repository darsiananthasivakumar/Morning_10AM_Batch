package wabdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sikuli.script.Screen;

public class G_mail {
	public WebDriver driver;
	Screen s=new Screen();
	public void login() throws Exception{
		driver=new FirefoxDriver();
		driver.get("https://accounts.google.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("Email")).sendKeys("svusudheer@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.id("next")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("Passwd")).sendKeys("sudheerbabu123");
		driver.findElement(By.id("signIn")).click();
	}
	public void link() throws Exception{
		driver.findElement(By.xpath(".//*[@id='gbwa']/div[1]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='gb23']/span[1]")).click();
		Thread.sleep(20000);
		//driver.findElement(By.xpath(".//*[@id=':hw']/div/div")).click();
		s.click("F:\\sikuli.sikuli\\1438162748399.png");
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		 G_mail g=new  G_mail();
		 g.login();
		 g.link();

	}

}
