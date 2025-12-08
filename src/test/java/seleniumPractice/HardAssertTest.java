package seleniumPractice;

import java.time.Duration;

import org.junit.experimental.theories.suppliers.TestedOn;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.github.dockerjava.api.model.Driver;

public class HardAssertTest {

	@Test
	public void hardassert() {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get("https://testautomationpractice.blogspot.com/");
	driver.findElement(By.id("name")).sendKeys("Archana Nagindla");
	
	driver.findElement(By.xpath("//input[@type=\"radio\" and @value=\"female\"]")).click();
	driver.findElement(By.xpath("//input[@type=\"checkbox\" and @value=\"friday\"]")).click();
   WebElement country = driver.findElement(By.id("country"));
//	WebElement ukdropdwn = driver.findElement(By.xpath("//option[@value='uk']"));
	Select sel=new Select(country);
	sel.selectByValue("uk");
    SoftAssert sa=new SoftAssert();
    sa.assertEquals("uk", "u");
    sa.assertAll();
	driver.quit();
	}
}
