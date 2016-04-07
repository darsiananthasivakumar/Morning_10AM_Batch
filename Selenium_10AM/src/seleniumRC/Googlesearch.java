package seleniumRC;

import org.openqa.jetty.jetty.servlet.Default;

import com.thoughtworks.selenium.DefaultSelenium;

public class Googlesearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DefaultSelenium selenium =new  DefaultSelenium("localhost",4444,"*firefox","https://www.google.co.in/");
			selenium.start();
		    selenium.open("/");
		    selenium.windowMaximize();
			

	}

}
