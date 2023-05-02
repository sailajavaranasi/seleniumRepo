package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserLauncher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
        WebDriver driver;
		
		WebDriverManager.chromedriver().setup();
	    //ChromeDriver driver = new ChromeDriver();
		driver = new ChromeDriver();
		
		WebDriverManager.iedriver().setup();
	//  InternetExplorerDriver driver1= new InternetExplorerDriver();
		driver = new InternetExplorerDriver();		
		
	}
	

}
