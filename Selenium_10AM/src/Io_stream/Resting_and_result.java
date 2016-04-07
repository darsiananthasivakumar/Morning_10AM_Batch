package Io_stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Resting_and_result {
	public WebDriver driver;
	String str;
  @Test
  public void f() throws Exception {
	  DateFormat df=new SimpleDateFormat("yy_MMM_dd hh_mm_ss a");
	  Date d=new Date();
	  String time=df.format(d);
	  
	  FileInputStream fi=new FileInputStream("D:\\Test data\\login.xls");
	  Workbook w=Workbook.getWorkbook(fi);
	  Sheet s=w.getSheet(0);
	 
	  FileOutputStream fg=new FileOutputStream("D:\\Result\\reg"+time+".xls");
	  WritableWorkbook wb=Workbook.createWorkbook(fg);
	  WritableSheet ws=wb.createSheet("Result", 0);
	  
	  for (int i = 1; i < s.getRows(); i++) {
		  driver.findElement(By.name("username")).sendKeys(s.getCell(0,i).getContents());
		  driver.findElement(By.name("password")).sendKeys(s.getCell(1,i).getContents());
		  driver.findElement(By.name("submit")).click();
		   try{
				  driver.findElement(By.linkText("Logout")).click();
				  str="pass";
			  }catch(Exception e){str="fail";}
		  
		   Label result=new Label(2, i, str);//print the result coulmn  all data
			ws.addCell(result);
		 
		  for (int j = 0; j < s.getColumns(); j++) {
			  System.out.println(s.getCell(j,i).getContents());
			  Label r=new Label(j,i,s.getCell(j,i).getContents());
			  ws.addCell(r);
			
		}
		  
		
	}
	  Label un=new Label(0,0,"usernme");
	  Label pw=new Label(1,0,"password");
	  ws.addCell(un);
	  ws.addCell(pw);
           Label res=new Label(2,0,"Result");
           ws.addCell(res);
           wb.write();
           wb.close();
  
  }
  
  @BeforeTest
  public void beforeTest() {
	  driver=new FirefoxDriver();
	  driver.get("http://selenium4testing.com/hms/");
  }

  @AfterTest
  public void afterTest() {
  }

}
