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

public class gmail_retest {
	public WebDriver driver;
	String str;
  @Test
  public void gmail() throws Exception {
	  DateFormat df=new SimpleDateFormat("yy_MMM_dd hh_mm_ss a");
	  Date d=new Date();
	  String time=df.format(d);
	  
	  FileInputStream fi=new FileInputStream("C:\\Workspace_6PM\\SeleniumAutomation\\Testdata\\gmai.xls");
	  Workbook w=Workbook.getWorkbook(fi);
	  Sheet s=w.getSheet(0);
	  FileOutputStream fo=new FileOutputStream("C:\\Workspace_6PM\\SeleniumAutomation\\Result\\gmail"+time+".xls");
	  WritableWorkbook wb=Workbook.createWorkbook(fo);
	  WritableSheet ws=wb.createSheet("Results", 0);
	
	  for(int c=3;c<s.getColumns();c++){
	  for (int i = 1; i <s.getRows() ; i++){
		  try{

			  if(s.getCell(2,i).getContents().equalsIgnoreCase("textbox")){
				  driver.findElement(By.xpath(s.getCell(0,i).getContents())).sendKeys(s.getCell(c,i).getContents());
			  }
			  else if(s.getCell(2,i).getContents().equalsIgnoreCase("button")){
				  driver.findElement(By.xpath(s.getCell(0,i).getContents())).click();
			  }
			  else if(s.getCell(2,i).getContents().equalsIgnoreCase("wait")){
				  Thread.sleep(1000);
				  
			  }
			  else if(s.getCell(2,i).getContents().equalsIgnoreCase("link")){
				  driver.findElement(By.xpath(s.getCell(0,i).getContents())).click();
			  }
			 
			
			str="pass";    
		  }catch(Exception e){str="fail";}
		  Label re=new Label(7,i,str);
		  ws.addCell(re);
		  for (int j = 0; j < s.getColumns(); j++) {
			Label l=new Label(j,i,s.getCell(j,i).getContents());
			ws.addCell(l);
		}
		  
	  }
	  }
	  Label r=new Label(7,0,"Results");
	  ws.addCell(r);
	  wb.write();
	  wb.close();
  }
  @BeforeTest
  public void beforeTest() {
	  driver=new FirefoxDriver();
	  driver.get("https://accounts.google.com/");
	  
  }

  @AfterTest
  public void afterTest() {
	  
  }

}
