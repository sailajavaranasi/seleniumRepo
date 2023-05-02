package selenium;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest
{
	public static WebDriver driver;
	public static String Projectpath = System.getProperty("user.dir")+ "/src/test/resources/" ;
	//public static Properties P = new Properties();
	public static Properties orProp;

	public static void init() throws Exception
	{
		//FileInputStream fis = new FileInputStream("C:\\Users\\HP\\eclipse-workspace\\march3-seleniumproject\\src\\test\\resources\\data.properties");
		
		//FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/data.properties");
		
		FileInputStream fis = new FileInputStream(Projectpath+"data.properties");
		Properties P = new Properties();
		P.load(fis);
		String str = P.getProperty("amazonurl");
		System.out.print(str);
	//	WebDriverManager.chromedriver().setup();
		//driver = new ChromeDriver();
		//driver.get(str);
		fis.close();
		
		//Reading environment properties file
		FileInputStream fis1 = new FileInputStream(Projectpath+"environment.properties");
		Properties env = new Properties();
		env.load(fis1);
	
		String en = env.getProperty("env");
		System.out.println(en);
		
		//Reading the corresponding child file of the environment file
		fis1 = new FileInputStream(Projectpath+en+".properties");
		//System.out.print(Projectpath+en+".properties");
		Properties child = new Properties();
		child.load(fis1);
		System.out.println(child.getProperty("amazonurl"));
		//driver.get(child.getProperty("amazonurl"));
		
		fis1.close();	
		
		//For reading OR Properties file
		fis = new FileInputStream(Projectpath+"or.properties");
	 	orProp = new Properties();
	 	orProp.load(fis);
	 	

		
	}
	public static void launch(String browser)
	{
				
		if(browser.equals("chrome"))
		{
			//Initiate Chrome Driver
			WebDriverManager.chromedriver().setup();
			//Create object for chrome driver
			driver = new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		//driver.get("https://www.amazon.com");
		driver.manage().window().maximize();
	}
	
	//the below method is for navigating URL
	public static void NavigateUrl(String url)
	{
		//Connects to the server to get to the page
		driver.get(url);
		//First time it connects to the server and later on it get the page from the cache ---- driver.navigate().to(Url);
		
	}
	public static void clickElement(String locatorKey)
	{
		//for Button click
		getElement(locatorKey).click();;
	}

	public static void typeText(String locatorKey, String text) 
	{
		//Enter data in search box
		getElement(locatorKey).sendKeys(text);
	}

 static void selectOption(String locatorKey, String option) throws IOException 
	{
	 	//Search Dropdownbox
	    getElement(locatorKey).sendKeys(option);		
	}
 private static WebElement getElement(String locatorKey) 
 {
	 	WebElement element = null;
	 	
	 	if(!isElementPresent(locatorKey)) // report as failure
	 		System.out.println("WebElement is not present : " + locatorKey);
	 	
	 	element = driver.findElement(getLocator(locatorKey));
	 	
	 	/* 
	 	 if (locatorKey.endsWith("_id"))
	 	 {
	 		element = driver.findElement(By.id(orProp.getProperty(locatorKey)));
		}
	 	else if (locatorKey.endsWith("_name"))
	 	{
	 		element = driver.findElement(By.name(orProp.getProperty(locatorKey)));
	 	}
	 	else if (locatorKey.endsWith("_classname"))
	 	{
	 		element = driver.findElement(By.className(orProp.getProperty(locatorKey)));
	 	}
	 	else if (locatorKey.endsWith("_Xpath"))
	 	{
	 		element = driver.findElement(By.xpath(orProp.getProperty(locatorKey)));
	 	}
	 	else if (locatorKey.endsWith("_css"))
	 	{
	 		element = driver.findElement(By.cssSelector(orProp.getProperty(locatorKey)));
	 	}
	 	else if (locatorKey.endsWith("_linktest"))
	 	{
	 		element = driver.findElement(By.cssSelector(orProp.getProperty(locatorKey)));
	 	}
	 	else if (locatorKey.endsWith("_partiallinktest"))
	 	{
	 		element = driver.findElement(By.cssSelector(orProp.getProperty(locatorKey)));
	 	}
	    */
	    return element ;
	// TODO Auto-generated method stub
	
 }
 	public static boolean isElementPresent(String locatorkey)
 	{
 		WebDriverWait wait = new WebDriverWait(driver,30);
 		System.out.println("Checking for WebElement Presence : "+locatorkey);
 		
 		wait.until(ExpectedConditions.presenceOfElementLocated(getLocator(locatorkey)));
 		/*if(locatorkey.endsWith("_id"))
 		{
 			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id(orProp.getProperty(locatorkey))));
 		}
 		else if(locatorkey.endsWith("_name"))
 		{
 			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name(orProp.getProperty(locatorkey))));
 		}
 		else if(locatorkey.endsWith("_classname"))
 		{
 			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className(orProp.getProperty(locatorkey))));
 		}
 		else if(locatorkey.endsWith("_Xpath"))
 		{
 			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(orProp.getProperty(locatorkey))));
 		}
 		else if(locatorkey.endsWith("_css"))
 		{
 			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(orProp.getProperty(locatorkey))));
 		}
 		else if(locatorkey.endsWith("_linktext"))
 		{
 			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.linkText(orProp.getProperty(locatorkey))));
 		}
 		else if(locatorkey.endsWith("_partiallinktext"))
 		{
 			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.partialLinkText(orProp.getProperty(locatorkey))));
 		}*/
 		
 		return true;
 	}
 	public static By getLocator(String locatorKey)
 	{
 		By by = null;
 		
 		if(locatorKey.endsWith("_id"))
 		{
 			by = By.id(orProp.getProperty(locatorKey));
 		}
 		else if(locatorKey.endsWith("_name"))
 		{
 			by = By.name(orProp.getProperty(locatorKey));
 		}
 		else if(locatorKey.endsWith("_classname"))
 		{
 			by = By.className(orProp.getProperty(locatorKey));
 		}
 		else if(locatorKey.endsWith("_Xpath"))
 		{
 			by = By.xpath(orProp.getProperty(locatorKey));
 		}
 		else if(locatorKey.endsWith("_css"))
 		{
 			by = By.cssSelector(orProp.getProperty(locatorKey));
 		}
 		else if(locatorKey.endsWith("_linktext"))
 		{
 			by = By.linkText(orProp.getProperty(locatorKey));
 		}
 		else if(locatorKey.endsWith("_partiallinktext"))
 		{
 			by = By.partialLinkText(orProp.getProperty(locatorKey));
 		}
 	
 		return by;
 	}
 }


