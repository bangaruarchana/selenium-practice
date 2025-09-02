package seleniumPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class red {

    @Test
    public void redBus() throws InterruptedException {
    	WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.redbus.in/");
		driver.findElement(By.xpath("//div[contains(text(),'From')]")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Lakdikapul')]")).click();
		driver.findElement(By.xpath("//div[text()='Bangalore']")).click();
		driver.findElement(By.xpath("//div[@class='dateInputWrapper___580edb']")).click();
		driver.findElement(By.xpath("//div[@class='date__b76f1a available__692491  calendarDate']/span[text()='11']")).click();
	    driver.findElement(By.xpath("//i[@class='icon___d7d303 icon icon-search']")).click();
	    
	    String busname=driver.findElement(By.xpath("//div[text()='Mythri Tours And Travels']")).getText();
	    String time=driver.findElement(By.xpath("//p[text()='07:15']")).getText();
	    System.out.println(busname+" "+time);
	    driver.quit();
	
    }
}
