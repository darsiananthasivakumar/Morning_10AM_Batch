package Data_driven;

import java.io.FileInputStream;
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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HMS {
	public WebDriver driver;
	String str;
	
  @Test
  public void HMS() throws Exception {
FileInputStream fi=new FileInputStream(".\\Test Data\\login.xls");
Workbook w=Workbook.getWorkbook(fi);
Sheet s=w.getSheet(0);

FileOutputStream fo=new FileOutputStream(".\\Results\\hms1.xls");
WritableWorkbook wb=Workbook.createWorkbook(fo);
WritableSheet ws=wb.createSheet("Results", 0);
for (int i = 0; i < s.getRows(); i++) {
	try{

		if(s.getCell(2,i).getContents().equalsIgnoreCase("url")){
			driver.get(s.getCell(0,i).getContents());
			
		}
		else if(s.getCell(2,i).getContents().equalsIgnoreCase("dropdown")){
			new Select(driver.findElement(By.name(s.getCell(0,i).getContents()))).selectByVisibleText(s.getCell(3,i).getContents());
			
		}
		else if(s.getCell(2,i).getContents().equalsIgnoreCase("textbox")){
			driver.findElement(By.name(s.getCell(0,i).getContents())).sendKeys(s.getCell(3,i).getContents());
		}
		else if(s.getCell(2,i).getContents().equalsIgnoreCase("button")){
			driver.findElement(By.xpath(s.getCell(0,i).getContents())).click();
		}
		else if(s.getCell(2,i).getContents().equalsIgnoreCase("link")){
			driver.findElement(By.linkText(s.getCell(0,i).getContents())).click();
		}
		else if(s.getCell(2,i).getContents().equalsIgnoreCase("alret")){
			if(s.getCell(3,i).getContents().equalsIgnoreCase("ok")){
			driver.switchTo().alert().accept();
			}else{
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
	Label re=new Label(4,i,str);
	ws.addCell(re);
}
Label r=new Label(4,0,"Results");
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
	  driver.quit();
  }

}
