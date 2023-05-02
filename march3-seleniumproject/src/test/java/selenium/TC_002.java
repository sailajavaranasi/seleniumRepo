package selenium;

import org.openqa.selenium.By;

public class TC_002 extends BaseTest
{

	public static void main(String[] args) throws Exception
	{
	 init();	// TODO Auto-generated method stub

	  launch("chrome");
	  NavigateUrl("https://www.amazon.com");
	  
	  	  
	  /* static way of finding webelements
	  
	   driver.findElement(By.id("searchDropdownBox")).sendKeys("Books");
	   driver.findElement(By.name("field-keywords")).sendKeys("Harry Potter");
	   driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();
	  */
	  
	  selectOption("amazon_id","Books");
	  typeText("amazonserach_name","Harry Potter");
	  clickElement("amazonbutton_Xpath");
	  
		
	  
	  
	}

	
  }
