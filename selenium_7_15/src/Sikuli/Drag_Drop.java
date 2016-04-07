package Sikuli;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

public class Drag_Drop {
	public Screen s=new Screen();
	
  @Test
  public void f() throws Exception {
	  s.drag("F:\\sikuli.sikuli\\1436422400878.png");
	  s.dropAt("F:\\sikuli.sikuli\\1436422410448.png");
	  
  }
  @BeforeTest
  public void beforeTest() {
  }

}
