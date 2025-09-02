package seleniumPractice;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class temuTest {

	@Test
	public void temuHomePage() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.temu.com/");
		WebElement img = driver.findElement(By.xpath("//img[@class=\"wxWpAMbp _2GJCSwiQ\"]"));
		assertTrue(true, "validation successful");
		driver.quit();
		
	}
}
