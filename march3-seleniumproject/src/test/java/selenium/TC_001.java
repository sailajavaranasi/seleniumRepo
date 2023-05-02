package selenium;

public class TC_001 extends BaseTest
{

	public static void main(String[] args) throws InterruptedException 
	{
		// TODO Auto-generated method stub
		launch("chrome");
		driver.manage().window().maximize();
		
		String title = driver.getTitle();
		System.out.println(title);
		
		String url = driver.getCurrentUrl();
		System.out.println(url);
		
		driver.manage().deleteAllCookies();
		
		driver.navigate().back();

		// 1000milli sec = 1min
		Thread.sleep(4000); 
		driver.navigate().forward();
		
		Thread.sleep(4000); 

		driver.navigate().refresh();
		//driver.navigate().wait(4000);
		
		//closes current or active webpage -- driver.close();
		//quits / closes all the webpages belong to the driver --  driver.quit();
	}

	
}
