package webdriver;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class screen {
	public WebDriver driver;
	public void log(){
		driver=new FirefoxDriver();
		driver.get("http://spicejet.com/Cargo.aspx");
	}
	public void take(String str) throws Exception{
		DateFormat df=new SimpleDateFormat("yy_mmm_dd hh_mm_ss a");
		Date d=new Date();
		String time=df.format(d);
		
		File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f,new File("D:\\"+time+".png"));
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		screen s=new screen();
		s.log();
		s.take("Cargo");

	}

}
