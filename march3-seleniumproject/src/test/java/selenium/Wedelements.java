
package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Wedelements extends BaseTest
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		launch("chrome");
		NavigateUrl("https://www.redbus.in/");
		
		String monthSelect = "May";
		driver.findElement(By.xpath("//*[@id=\"onward_cal\"]")).click();
		

		while(true)
		{
			String month = driver.findElement(By.xpath("//td[@class=\"monthTitle\"]")).getText();
			if (!month.contains(monthSelect))
			{
				driver.findElement(By.xpath("//td[@class=\"next\"]")).click();
			}
			else
			{
				break;
			}
		}
		
		int row = driver.findElements(By.xpath("//table[@class=\"rb-monthTable first last\"]/tbody/tr")).size();
		for(int r = 1;r<=row;r++)
		{
			
			List<WebElement> rowData = driver.findElements(By.xpath("//table[@class=\"rb-monthTable first last\"]/tbody//tr"+"["+r+"]"+"//"+"td"));
			System.out.println("Number of rows "+rowData.size());

			int i= 1;
			for(WebElement r1: rowData)
			{
				WebElement rowInfo = driver.findElement(By.xpath("//table[@class=\"rb-monthTable first last\"]/tbody/tr"+"["+r+"]"+"/"+"td"+"["+i+"]"));
				System.out.println("Data  "+rowInfo);
				if(rowInfo.getText().equals("29"))
				{
					rowInfo.click();
					break;
				}

				i++;
			}
		}
		
						
	}

	

}
