package Datadriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

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

public class HMS {
	public WebDriver driver;
	String str;
	
	FileInputStream fi;
	  Workbook w;
	  Sheet s;
	  FileOutputStream fo;
	  WritableWorkbook wb;
	  WritableSheet ws;
	  
	
  @Test
  public void f() throws Exception {
	   fi=new FileInputStream("D:\\Workspace_10AM\\selenium_7_15\\Testdata\\hms.xls");
	   w=Workbook.getWorkbook(fi);
	   s=w.getSheet(0);
	  
	  fo=new FileOutputStream("D:\\Workspace_10AM\\selenium_7_15\\Result\\hmsr.xls");
	  wb=Workbook.createWorkbook(fo);
	  ws=wb.createSheet("login", 0);
	  for (int i = 1; i < s.getRows(); i++) {
		  try{

			  if((s.getCell(2,i).getContents().equalsIgnoreCase("url"))){
				 
				  driver.get(s.getCell(0,i).getContents());
				  
			  }
			  else if(s.getCell(2,i).getContents().equalsIgnoreCase("textbox")){
				  
				  driver.findElement(By.name(s.getCell(0,i).getContents())).sendKeys(s.getCell(3,i).getContents());
				  
			  }
			  else if(s.getCell(2,i).getContents().equalsIgnoreCase("dropdown")){
				  driver.findElement(By.name(s.getCell(0,i).getContents())).sendKeys(s.getCell(3,i).getContents());
			  }
			  else if(s.getCell(2,i).getContents().equalsIgnoreCase("button")||s.getCell(2,i).getContents().equalsIgnoreCase("radiobutton")||
					  s.getCell(2,i).getContents().equalsIgnoreCase("checkbox")){
				  driver.findElement(By.xpath(s.getCell(0,i).getContents())).click();
				  
			  }
			  else if(s.getCell(2,i).getContents().equalsIgnoreCase("link")){
				  driver.findElement(By.linkText(s.getCell(0,i).getContents())).click();
			  }
			  else if(s.getCell(2,i).getContents().equalsIgnoreCase("alret")){
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
		  Label rs=new Label(4,i,str);
		  ws.addCell(rs);
		  
		  Label r=new Label(4,0, "Result");
		  ws.addCell(r);
		  
		  
	  }

	  try{
		  s=w.getSheet(1);
		  
		  ws=wb.createSheet("result", 1);
	 
		  for (int i = 1; i < s.getRows(); i++) {
			  try{

				  if(s.getCell(4,i).getContents().equalsIgnoreCase("url")){
					  driver.get(s.getCell(2,i).getContents());
					  
				  }
				  else if(s.getCell(4,i).getContents().equalsIgnoreCase("textbox")){
					  driver.findElement(By.name(s.getCell(2,i).getContents())).sendKeys(s.getCell(5,i).getContents());
					  
				  }
				  else if(s.getCell(4,i).getContents().equalsIgnoreCase("dropdown")){
					  driver.findElement(By.name(s.getCell(2,i).getContents())).sendKeys(s.getCell(5,i).getContents());
				  }
				  else if(s.getCell(4,i).getContents().equalsIgnoreCase("button")||s.getCell(4,i).getContents().equalsIgnoreCase("radiobutton")||
						  s.getCell(4,i).getContents().equalsIgnoreCase("checkbox")){
					  driver.findElement(By.xpath(s.getCell(2,i).getContents())).click();
					  
				  }
				  else if(s.getCell(4,i).getContents().equalsIgnoreCase("link")){
					  driver.findElement(By.linkText(s.getCell(2,i).getContents())).click();
				  }
				  else if(s.getCell(4,i).getContents().equalsIgnoreCase("alret")){
					  if(s.getCell(5,i).getContents().equalsIgnoreCase("ok")){
						  driver.switchTo().alert().accept();
						  
					  }
					  else{
						  driver.switchTo().alert().dismiss();
					  }
					  
				  }
				  else if(s.getCell(4,i).getContents().equalsIgnoreCase("wait")){
					  Thread.sleep(1000);
				  }
				  
				
			str="pass";
			
			
			  }catch(Exception e){str="invalid" ; }
			 
			  for (int j = 2; j < s.getColumns(); j++) {
				  Label l=new Label(j,i,s.getCell(j,i).getContents());
				  ws.addCell(l);
				
			}
			if(str=="pass"){
			  Label rs=new Label(0,i,str);
			  ws.addCell(rs);
			} 
			else{
			  Label k=new Label(1,i,str);
			  ws.addCell(k);
			}
			  Label p=new Label(6,i,str);
			  ws.addCell(p);  
				  
			
			  
			  Label r=new Label(0,0, "Result");
			  ws.addCell(r);
			  Label o=new Label(1,0,"result");
			  ws.addCell(o);
			  Label z=new Label(6,0,"Result");
			  ws.addCell(z);
			  
			  
		  }
	  }catch(Exception e){e.printStackTrace();}
		  
try{
	 s=w.getSheet(2);
	  ws=wb.createSheet("siva",2);
	  for (int i = 0; i <s.getRows(); i++) {
	System.out.println(s.getCell(0,i).getContents());
	  
	
	for (int j = 0; j < s.getColumns(); j++) {
		Label l=new Label(j,i,s.getCell(j,i).getContents());
		ws.addCell(l);
	}
	  
	  } 
}catch(Exception e){}

 
	  wb.write();
	  wb.close();
  
		  
  }
  
	  
  
  @BeforeTest
  public void beforeTest() {
	  driver=new FirefoxDriver();
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
  }

}
