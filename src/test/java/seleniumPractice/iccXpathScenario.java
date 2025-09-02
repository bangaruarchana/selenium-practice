package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class iccXpathScenario {
	@Test
	public void viratRating() {
	WebDriver driver =new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.icc-cricket.com/rankings/batting/mens/odi");
	WebElement rating = driver.findElement(By.xpath("//span[text()='Virat']/ancestor::div[@class='si-table-body']/descendant::span[text()='736']"));
	System.out.println(rating.getText());
	Actions act=new Actions(driver);
    WebElement cookies = driver.findElement(By.xpath("//button[text()='Accept All Cookies']"));
    act.click(cookies).perform();
	driver.quit();
	
	
	
	}

}
