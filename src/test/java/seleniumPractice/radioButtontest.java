package seleniumPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class radioButtontest {

	@Test
	public void practiceradioButton() {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebElement radiobtn1 = driver.findElement(By.xpath("//label[@for=\"radio1\"]"));
		radiobtn1.click();
		radiobtn1.click();
		if(radiobtn1.isSelected()) {
		System.out.println("'clicked the radio button and it is enabled'");
		}
		else {
			System.out.println("'clicked the radio button and it is not enabled'");
		}
		driver.quit();
	}
}
