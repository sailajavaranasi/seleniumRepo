	
	
	package selenium;

	import java.util.List;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class dattepicker 
	{

	public static void main(String[] args) throws Exception
	{


	WebDriverManager.chromedriver().setup();
	WebDriver driver =  new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.goibibo.com/");
	
	
	//Close popup Window
	driver.findElement(By.xpath("//span[@class=\"logSprite icClose\"]")).click();
	
	driver.findElement(By.xpath("//span[contains(text(),'Departure')]")).click();
		
	String month="August 2023";
	String exp_date="15";
	
	while(true)
	{
		//Your Code only reads the first month and check if its equal or not.
		
		//String text= driver.findElement(By.xpath("//div[contains(text(),'2023')]")).getText();
		
		//Below code gets both the months and checks is either one of them matches with August or not
		List<WebElement> text1=  driver.findElements(By.xpath("//div[contains(text(),'2023')]"));
		
		if(text1.get(0).getText().equals(month)||text1.get(1).getText().equals(month))
		{
			System.out.println("text and month are  same " + text1.get(0).getText()+ text1.get(1).getText());
			break;
		}
		else
			driver.findElement(By.xpath("//div[@class=\"DayPicker-wrapper\"]/div[1]/span[2]")).click();
				//System.out.println("ELSE : text and month are NOT same " + text);
				//driver.findElement(By.xpath("//body/div[@id='root']/div[3]/div[1]/div[1]/div[1]/div[3]/div[2]/div[2]/div[1]/div[1]/div[1]/span[2]")).click();
				

	 }

		
	
	


	//	List<WebElement>alldates= driver.findElements(By.xpath("//body/div[@id='root']/div[3]/div[1]/div[1]/div[1]/div[3]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[3]/div/div"));
	

	List<WebElement> alldates= driver.findElements(By.xpath("//div[@class=\"DayPicker-Month\"][2]/div[@class=\"DayPicker-Body\"]//div"));

	     for(WebElement ele:alldates)
	      {
	    	 String date_text= ele.getText();
	    	 System.out.println("date_text --> " + date_text); 
	    	 // String date[] = date_text.split("/n");
	   
	    	 if (date_text.equals(exp_date))
	    	 {
	    		 
	    		 ele.click();
	      
	    		 //After selecting the date - Click on Done Button
	    		 driver.findElement(By.xpath("//span[@class=\"fswTrvl__done\"]")).click();
	    		 //Later By default Traveler & Class Popup opensup , so we have click cancel to close the popup
	    		 driver.findElement(By.xpath("//a[@class=\"sc-gjNHFA eqHvKO\"]")).click();
	    		 break;
	    	 }
	   
	      }

	
		     
	}
	}
	
	

	
	
	


