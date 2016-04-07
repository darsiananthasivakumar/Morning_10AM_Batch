package Examples_TestNg;

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
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class data_driven {
	public WebDriver driver;
	String str;
  @Test
  public void datadriven() throws Exception {
	  DateFormat df=new SimpleDateFormat("yy_MMM_dd hh_mm_ss a");
	  Date d=new Date();
	  String time=df.format(d);
	  FileInputStream fi=new FileInputStream("E:\\Test data\\login.xls");
	  Workbook w=Workbook.getWorkbook(fi);
	  Sheet s=w.getSheet(0);
	  FileOutputStream fo=new FileOutputStream("E:\\Result\\res"+time+".xls");
	  WritableWorkbook wb=Workbook.createWorkbook(fo);
	  WritableSheet ws=wb.createSheet("Result", 0);
	  for (int c = 3; c < s.getColumns(); c++) {
		
		  for (int i = 1; i < s.getRows(); i++) {
			  try{

					if(s.getCell(2,i).getContents().equalsIgnoreCase("url")){
						driver.get(s.getCell(0,i).getContents());
					}
					else if(s.getCell(2,i).getContents().equalsIgnoreCase("dropdown")){
					new Select(driver.findElement(By.name(s.getCell(0,i).getContents()))).selectByVisibleText(s.getCell(c,i).getContents());
					}
					  
				  else if(s.getCell(2,i).getContents().equalsIgnoreCase("textbox")){
						driver.findElement(By.name(s.getCell(0,i).getContents())).sendKeys(s.getCell(c,i).getContents());
					}
				  else if(s.getCell(2,i).getContents().equalsIgnoreCase("button")||s.getCell(2,i).getContents().equalsIgnoreCase("radiobutton")){
					  driver.findElement(By.xpath(s.getCell(0,i).getContents())).click();
				  }
				  else if(s.getCell(2,i).getContents().equalsIgnoreCase("link")){
					  driver.findElement(By.linkText(s.getCell(0,i).getContents())).click();
				  }
				  else if(s.getCell(2,i).getContents().equalsIgnoreCase("alert")){
					  if(s.getCell(c,i).getContents().equalsIgnoreCase("ok")){
					  driver.switchTo().alert().accept();
					  }
					  else{
						  driver.switchTo().alert().dismiss();
					  }
				  }
				  else if(s.getCell(2,i).getContents().equalsIgnoreCase("wait")){
					  Thread.sleep(1000);
				  }
				str="pass";
			  }catch(Exception e){str="fail";}
			  Label rs=new Label(7,i,str);
			  ws.addCell(rs);
			  for (int j = 0; j < s.getColumns(); j++) {
				  
				Label l=new Label(j,i,s.getCell(j,i).getContents());
				ws.addCell(l);
			}		  
		  
		 
		  }
		  
	  }
  
	  Label r=new Label(7,0,"Result");
	  ws.addCell(r);
	  wb.write();
	  wb.close();
	  
  
  
  }
  
  
  @BeforeTest
  public void beforeTest() {
	  driver=new FirefoxDriver();
  }

  @AfterTest
  public void afterTest() {
  }

}
