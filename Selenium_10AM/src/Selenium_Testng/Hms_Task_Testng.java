package Selenium_Testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Hms_Task_Testng {
	public WebDriver driver;
	public void login(){
	    driver.findElement(By.name("username")).sendKeys("user1");
	     driver.findElement(By.name("password")).sendKeys("user1");
		  driver.findElement(By.name("submit")).click();
			
		}
		public void reg() throws Exception{
			 driver.findElement(By.linkText("Registration")).click();
			  driver.findElement(By.linkText("Permanent Registration")).click();
			  Thread.sleep(1000);
		}
  @Test
  public void f() throws Exception {

	  
	  new Select(driver.findElement(By.name("PATIENT_CAT"))).selectByVisibleText("Insurance");
		new Select(driver.findElement(By.name("RELATION"))).selectByVisibleText("Father");
		new Select(driver.findElement(By.name("TITLE"))).selectByVisibleText("Mr.");
		new Select(driver.findElement(By.name("PAT_IDENTITY"))).selectByVisibleText("Voter ID");
		driver.findElement(By.name("PAT_IDENTITY_PROOF")).sendKeys("12345678");
		driver.findElement(By.name("PNT_NAME")).sendKeys("shiva");
		driver.findElement(By.name("LAST_NAME")).sendKeys("kumar");
		driver.findElement(By.name("DOB")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='tcalGrid']/tbody/tr[4]/td[6]")).click();
		
		driver.findElement(By.name("AGE")).sendKeys("40");
		new Select(driver.findElement(By.name("SEX"))).selectByVisibleText("Male");
		new Select(driver.findElement(By.name("MTRL_STATUS"))).selectByVisibleText("Married");
		new Select(driver.findElement(By.name("RELIGION"))).selectByVisibleText("Hindu");
		new Select(driver.findElement(By.name("PLANGUAGE"))).selectByVisibleText("Telugu");
		new Select(driver.findElement(By.name("NATIONALITY"))).selectByVisibleText("Indian");
		new Select(driver.findElement(By.name("IS_MLC"))).selectByVisibleText("No");
		new Select(driver.findElement(By.name("EDUCATION"))).selectByVisibleText("MCA");
		new Select(driver.findElement(By.name("OCCUPATION"))).selectByVisibleText("Employee");
		new Select(driver.findElement(By.name("BLOOD_GRP_CODE"))).selectByVisibleText("A+");
		new Select(driver.findElement(By.name("CITIZENSHIP"))).selectByVisibleText("Indian");
		new Select(driver.findElement(By.name("SC_PROOF"))).selectByVisibleText("Yes");
		driver.findElement(By.name("ADDRESS1")).sendKeys("1/2/5,ATCHAMPET");
		driver.findElement(By.name("MOBILE_NO")).sendKeys("9959482215");
		driver.findElement(By.name("EMAIL_ID")).sendKeys("SVUSUDHEER@GMAIL.COM");
		driver.findElement(By.name("ZIP")).sendKeys("522409");
		new Select(driver.findElement(By.name("COUNTRY_CODE"))).selectByVisibleText("India");
		driver.findElement(By.name("image")).sendKeys("F:\\download.jpg");
		
		driver.findElement(By.name("submit")).click();	
		String str;
		str=driver.switchTo().alert().getText();
		//System.out.println(str);
		driver.switchTo().alert().accept();
		String s[]=str.split("\n");
		System.out.println(s.length);
		for (int i = 0; i < s.length; i++) 
		{
			if(s[i].contains("PR")){
				System.out.println(s[i]);
			}
		}
			for(int i=0;i<s.length;i++){
				if(s[i].equalsIgnoreCase(".//*[@id='navigation']/li[2]")){
					driver.findElement(By.xpath(".//*[@id='navigation']/li[2]")).click();
			}
			
			Thread.sleep(20000);
			driver.findElement(By.xpath(".//*[@id='navigation']/li[1]/ul/li[3]/a")).click();
			//driver.findElement(By.xpath("html/body/div[2]/div/div[2]/form/div/table[1]/tbody/tr[1]/td[2]/input")).clear();
				driver.findElement(By.xpath("html/body/div[2]/div/div[2]/form/div/table[1]/tbody/tr[1]/td[2]/input")).sendKeys("PR4064445275");
				driver.findElement(By.xpath("html/body/div[2]/div/div[2]/form/div/table[1]/tbody/tr[2]/td[2]/input")).click();
				str=driver.findElement(By.xpath("html/body/div[2]/div[1]/div[2]/form/div/table[3]")).getText();
				System.out.println(str);
			//driver.findElement(By.name("submit")).click();
			
			}
			
				
			}
			
				
		
  
  
  @BeforeTest
  public void beforeTest() throws Exception {
	  driver=new FirefoxDriver();
		driver.get("http://selenium4testing.com/hms/");
		driver.manage().window().maximize();
		login();
		reg();
  }

  @AfterTest
  public void afterTest() {
  }

}
