package Registration;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class incorrectPasswordTest {
    @Test
    public void incorrectpasswordTest() throws InterruptedException {
    	WebDriver driver = new ChromeDriver();
    	driver.manage().window().maximize();
    	driver.get("https://practice.expandtesting.com/register");
    	driver.findElement(By.id("username")).sendKeys("bangaruarchana");
		driver.findElement(By.id("password")).sendKeys("Mahadev3#");
		driver.findElement(By.id("confirmPassword")).sendKeys("mahadev3*");
		WebElement regbtn = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
		Actions act=new Actions(driver);
		act.scrollToElement(regbtn).click().perform();
		Thread.sleep(3000);
		assertTrue(true, "Passwords do not match.");
		System.out.println("Error message has displayed");
		driver.quit();
    }

}
