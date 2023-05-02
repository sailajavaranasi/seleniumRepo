package selenium;
import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;



public class redbus extends BaseTest
{

	public static void main(String[] args) throws Exception 
	{
		// TODO Auto-generated method stub
		
		launch("chrome");
		NavigateUrl("https://www.redbus.in/");
		
		
		String source = "Visakhapatnam"	;
		String dest = "Vijayawada"	;
		String chkSrc = "Vi"	;
		String chkDest = "Vi"	;
		//Date 
		String month;
		String currMonth ="May";
		String selectDate = "29";
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//*[@id=\"search\"]/div/div/div/input")).sendKeys(chkSrc);
		Thread.sleep(2000);
		
		//reading the FROM list 
		List<WebElement> srcList = driver.findElements(By.xpath("//*[@id=\"search\"]/div/div/div/ul/li"));
		
		for(int i=0;i<srcList.size();i++)
		{
			String fromSrc= srcList.get(i).getText();
			System.out.println(fromSrc);
			if(fromSrc.contains(source))
			{
				srcList.get(i).click();
				break;
			}
		}
		
		System.out.println("------------------------");

		driver.findElement(By.xpath("//*[@id=\"search\"]/div/div[2]/div/input")).sendKeys(chkDest);
		Thread.sleep(2000);
		//reading the DEST list
		List<WebElement> desList = driver.findElements(By.xpath("//*[@id=\"dest\"]/following-sibling::*[1]/li"));
		
		for(int i=0;i<desList.size();i++)
		{
			String toDes= desList.get(i).getText();
			System.out.println(i + "."+" " +toDes);
			if(source.contains(desList.get(i).getText()))
			{
				System.out.println("deleted  "+desList.get(i).getText());
				desList.remove(i);
			}else if(toDes.contains(dest))
			{
				desList.get(i).click();
				break;
			}
		}
		
		
		//Date 
		
		while(true)
		{
			month = driver.findElement(By.xpath("//td[@class=\"monthTitle\"]")).getText();
			if (!month.contains(currMonth))
			{
				driver.findElement(By.xpath("//td[@class=\"next\"]")).click();
			}
			else
			{
				break;
			}
		}
		List<WebElement> rowData = driver.findElements(By.xpath("//table[@class=\"rb-monthTable first last\"]/tbody/tr/td"));
		for(WebElement r :rowData)
		{	
			if(r.getText().equals(selectDate))
				{
				r.click();
				break;
				}
		}
	}
}
	


