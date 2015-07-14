package yahoo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test_prog 
{
  
	WebDriver driver;
	@Test
	@Parameters({"browser"})
	public void testing(String br) throws Exception
	{
		if(br.matches("firefox"))
		{
		  driver=new FirefoxDriver();
		}
		if(br.matches("ie"))
		{
			System.setProperty("webdriver.ie.driver","d:\\IEDriverServer.exe");
	        driver=new InternetExplorerDriver();		
		}
		Home h=new Home(driver);
		h.validate_links();
		h.createacc();
		h.login();
		
		Compose c=new Compose(driver);
		c.sendmail();
		c.signout();
	}
}
