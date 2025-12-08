package seleniumPractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class autosuggestionTest {

	@Test
	public void autoSugg() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.amazon.in/");
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
	    driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]")).sendKeys("plants");
	    List<WebElement> sugg = driver.findElements(By.xpath("//div[contains(@class,\"s-suggestion s-suggestion-ellipsis-direction\")]"));
	
	    for (WebElement webElement : sugg) {
			System.out.println(webElement.getText());
		}
	    driver.quit();
	}
}
