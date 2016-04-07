package Examples_TestNg;

import java.sql.Array;

public class Spilt_method {

	public static void main(String[] args) {


		// TODO Auto-generated method stub
String str="one,two, three,four,/five/six,seven";
String []s=str.split("/");

System.out.println(s.length);
	
for (int i = 0; i < s.length; i++)
{

		if (s[i].contains("five")) {
			System.out.println(s[i]);
		}
	}
	
  
	}

}
