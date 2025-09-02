package seleniumPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ShadowRootElementTest {

	@Test
	public void shadowRoot() throws InterruptedException {
		WebDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		driver.get("https://practice.expandtesting.com/shadowdom");
		WebElement pagedwn = driver.findElement(By.xpath("//a[text()='Expand Testing']"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollToElement", pagedwn);
        SearchContext shadowhost=driver.findElement(By.id("shadow-host")).getShadowRoot();
        Thread.sleep(2000);
        driver.findElement(By.id("my-btn")).click();
        Thread.sleep(2000);
        System.out.println("clicked on the shadow root element");
        driver.quit();
	}
}
