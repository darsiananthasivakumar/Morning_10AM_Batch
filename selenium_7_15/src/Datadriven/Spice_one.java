package Datadriven;


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

public class Spice_one {
	public WebDriver driver;
	String str;
  @Test
  public void spice() throws Exception {
	  DateFormat df=new SimpleDateFormat("yy_mmm_dd hh_mm_ss a");
	  Date d=new Date();
	  String time=df.format(d);
	 
	  FileInputStream fi=new FileInputStream("D:\\Workspace_10AM\\selenium_7_15\\Testdata\\spice.xls");
	  Workbook w=Workbook.getWorkbook(fi);
	  Sheet s=w.getSheet(0);
	  
	  FileOutputStream fo=new FileOutputStream("D:\\Workspace_10AM\\selenium_7_15\\Result\\spiceres"+time+".xls");
	  WritableWorkbook wb=Workbook.createWorkbook(fo);
	  WritableSheet ws=wb.createSheet("Results", 0);
	  
		

 for (int i = 1; i <s.getRows(); i++) {
		  try{
			  if(s.getCell(2,i).getContents().equalsIgnoreCase("url")){
					driver.get(s.getCell(0,i).getContents());
				}
				else if(s.getCell(2,i).getContents().equalsIgnoreCase("radiobutton")||s.getCell(2,i).getContents().equalsIgnoreCase("button")){
					driver.findElement(By.xpath(s.getCell(0,i).getContents())).click();
				}
				else if(s.getCell(2,i).getContents().equalsIgnoreCase("link")){
					driver.findElement(By.linkText(s.getCell(0,i).getContents())).click();
				}
				else if(s.getCell(2,i).getContents().equalsIgnoreCase("dropdown")){
					new Select(driver.findElement(By.name(s.getCell(0,i).getContents()))).selectByVisibleText(s.getCell(3,i).getContents());
				}
				else if(s.getCell(2,i).getContents().equalsIgnoreCase("alert")){
					if(s.getCell(3,i).getContents().equalsIgnoreCase("ok")){
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

	
		  for (int j = 0; j < s.getColumns(); j++) {
			  Label l=new Label(j,i,s.getCell(j,i).getContents());
			  ws.addCell(l);
			
		}
		 
			  Label re=new Label(6,i,str);
			  ws.addCell(re);
		 }
	  Label r=new Label(6,0,"Result");
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
	  //driver.quit();
  }

}
