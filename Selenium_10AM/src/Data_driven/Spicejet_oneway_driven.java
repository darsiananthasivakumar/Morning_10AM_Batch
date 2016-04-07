package Data_driven;

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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Spicejet_oneway_driven {
	public WebDriver driver;
	String str;
	
  @Test
  public void oneway() throws Exception {
	  FileInputStream fi=new FileInputStream(".\\Test Data\\Spiceoneway.xls");
	  Workbook w=Workbook.getWorkbook(fi);
	  Sheet s=w.getSheet(0);
	  
	  FileOutputStream fo=new FileOutputStream("C:\\Workspace_6PM\\Selenium_10AM\\Results\\spiceres.xls");
	  WritableWorkbook wb=Workbook.createWorkbook(fo);
	  WritableSheet ws=wb.createSheet("Results", 0);
	  //for(int c=3;c<s.getColumns();c++){
	  
	  for (int i = 0; i < s.getRows(); i++) {
		  try{

				 
			  if(s.getCell(2,i).getContents().equalsIgnoreCase("url")){
				  driver.get(s.getCell(0,i).getContents());
				  Thread.sleep(1000);
			  }
			  else if(s.getCell(2,i).getContents().equalsIgnoreCase("radio button")
					  ||s.getCell(2,i).getContents().equalsIgnoreCase("checkbox")
					  ||s.getCell(2,i).getContents().equalsIgnoreCase("button")){
				  driver.findElement(By.xpath(s.getCell(0,i).getContents())).click();
				  
			  }
			  else if(s.getCell(2,i).getContents().equalsIgnoreCase("dropdown")){
				 new Select(driver.findElement(By.name(s.getCell(0,i).getContents()))).selectByVisibleText(s.getCell(3,i).getContents());
			  }
			  else if(s.getCell(2,i).getContents().equalsIgnoreCase("link")){
				  driver.findElement(By.linkText(s.getCell(0,i).getContents())).click();
			  }
			  else if(s.getCell(2,i).getContents().equalsIgnoreCase("wait")){
				  Thread.sleep(1000);
			  }
			
		 str="pass";
		  }catch(Exception e){str="fail";}
		
		  for(int j=0;j<s.getColumns();j++){
			  Label l=new Label(j,i,s.getCell(j,i).getContents());
			  ws.addCell(l);
		  }
		  Label rs=new Label(4,i,str);
		  ws.addCell(rs);
		  
	  }
	 //driver.navigate().to("url");
	  Label re=new Label(4,0,"Results");
	  ws.addCell(re);
	  wb.write();
	  wb.close();
	  }

  @BeforeTest
  public void beforeTest() {
	  
		 // System.setProperty("webdriver.ie.driver","D:\\library\\IEDriverServer.exe" );
			driver=new FirefoxDriver();
			driver.get("http://spicejet.com/");
		  
	  
	 
  }

  @AfterTest
  public void afterTest() {
  driver.quit();
  }

}
