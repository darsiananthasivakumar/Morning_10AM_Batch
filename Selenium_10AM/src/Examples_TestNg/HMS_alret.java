package Examples_TestNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class HMS_alret {
	public WebDriver driver;
  @Test
  public void alert() throws Exception {
	  driver.findElement(By.linkText("Registration")).click();
	  driver.findElement(By.linkText("Permanent Registration")).click();
Thread.sleep(1000);
		new Select(driver.findElement(By.name("PATIENT_CAT"))).selectByVisibleText("Insurance");
		new Select(driver.findElement(By.name("RELATION"))).selectByVisibleText("Father");
		new Select(driver.findElement(By.name("TITLE"))).selectByVisibleText("Mr.");
		new Select(driver.findElement(By.name("PAT_IDENTITY"))).selectByVisibleText("Voter ID");
		driver.findElement(By.name("PAT_IDENTITY_PROOF")).sendKeys("12345678");
		driver.findElement(By.name("PNT_NAME")).sendKeys("shiva");
		driver.findElement(By.name("LAST_NAME")).sendKeys("kumar");
		driver.findElement(By.name("DOB")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='tcalGrid']/tbody/tr[6]/td[6]")).click();
		
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
	String s[]=str.split("\n");
	System.out.println(str.length());
	  for (int i = 0; i < s.length; i++) {
		if(s[i].contains("PR")){
			System.out.println(s[i]);
			
		}else if(s[i].equalsIgnoreCase("PR1473807877")){
		System.out.println(s[i]);	
		}
		driver.switchTo().alert().accept();
	}
	 Thread.sleep(1000);
	  driver.findElement(By.linkText("Search Registration")).click();
	  driver.findElement(By.xpath("html/body/div[2]/div/div[2]/form/div/table[1]/tbody/tr[1]/td[2]/input")).sendKeys("PR1473807877");
	  driver.findElement(By.name("submit")).click();
	  String str1;
	  str1=driver.findElement(By.xpath("html/body/div[2]/div[1]/div[2]/form/div/table[3]")).getText();
	  System.out.println(str1);
	  driver.findElement(By.xpath("html/body/div[2]/div[1]/div[2]/form/div/table[4]/tbody/tr/td[1]/a/input")).click();
	  driver.findElement(By.xpath(".//*[@id='form1']/div[1]/table/tbody/tr[3]/td[2]/input")).sendKeys("shiva");
	  
  }
  @BeforeTest
  public void beforeTest() throws Exception {

	  driver=new FirefoxDriver();
	  driver.get("http://selenium4testing.com/hms/");
	  driver.manage().window().maximize();
	  driver.findElement(By.name("username")).sendKeys("user1");
	  driver.findElement(By.name("password")).sendKeys("user1");
	  driver.findElement(By.name("submit")).click();
	  Thread.sleep(1000);
	  
	
	

  
  }

  @AfterTest
  public void afterTest() {
  }

}
