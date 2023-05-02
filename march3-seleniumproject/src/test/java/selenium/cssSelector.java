package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class cssSelector extends BaseTest
	{

	public static void main(String[] args) throws InterruptedException 
	{
		// TODO Auto-generated method stub
		launch("chrome");
		NavigateUrl("https://www.goibibo.com/");
		
		
		
			driver.findElement(By.cssSelector("div.cm__modal > div > div > div.sc-furwcr.jQTZFO > span")).click();
		

			
			driver.findElement(By.cssSelector("p[class=\"sc-faUpoM clesLa fswWidgetTitle\"]>span[class=\"sc-dvQaRk fchrvX fswDownArrow\"]")).click();

			
			//driver.findElement(By.cssSelector("p.sc-jlwm9r-1")).click();
			
			String month1;
			String month2;
			String selectMonth = "August";
			String selectDate="15";
			
					
			
		
		while(true)
		{
			//List<WebElement> months = driver.findElements(By.cssSelector("div[class=\"DayPicker-Months\"]>div>div[class=\"DayPicker-Caption\"]>div"));
			
			month1 = driver.findElements(By.cssSelector("div[class=\"DayPicker-Months\"]>div>div[class=\"DayPicker-Caption\"]>div")).get(0).getText();
			
			month2 = driver.findElements(By.cssSelector("div[class=\"DayPicker-Months\"]>div>div[class=\"DayPicker-Caption\"]>div")).get(1).getText();
			
		    if(!(month1.contains(selectMonth) || month2.contains(selectMonth)))
			
				driver.findElement(By.cssSelector("span[aria-label=\"Next Month\"]")).click();
			else
		    	break;
		}
		
		List<WebElement> days;
		if(month1.contains(selectMonth))
		    		days = driver.findElements(By.cssSelector("div.DayPicker-Months>div:last-child>div:first-child>div.DayPicker-Week>div.DayPicker-Day"));
		    	else
		    		days = driver.findElements(By.cssSelector("div.DayPicker-Months>div:last-child>div:last-child>div.DayPicker-Week>div.DayPicker-Day"));
		    		
		    	    
		    for(WebElement mD1 : days)
		    {
		    	if(mD1.getText().contains(selectDate))
		    		{
		    		   	mD1.click();
		    		   	driver.findElement(By.cssSelector("span.fswTrvl__done")).click();
		    			 
		    			 //Cancel Click
		    			 driver.findElements(By.cssSelector("div[data-id=\"flt-srch-wdgt\"]>div>div>div>div>div>div>a")).get(1).click();
		    			
		    			 return;
		    		}
		    }
		    		
		    	
		 }
		    	
	}
			
	
