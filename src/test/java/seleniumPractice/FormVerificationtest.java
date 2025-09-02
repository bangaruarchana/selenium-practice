package seleniumPractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class FormVerificationtest {
@Test
public void formverification() {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get("https://practice.expandtesting.com/form-validation");
	WebElement pagedwn = driver.findElement(By.xpath("//a[text()='Expand Testing']"));
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollToElement;", pagedwn);
	driver.findElement(By.id("validationCustom01")).sendKeys("arch");
	driver.findElement(By.xpath("//input[@name=\"contactnumber\"]")).sendKeys("950-2514787");
	driver.findElement(By.id("validationCustom05")).sendKeys("30-08-2025");
	WebElement dropdwn = driver.findElement(By.xpath("//select[@name=\"payment\"]"));
	Select sel=new Select(dropdwn);
	List<WebElement> options = sel.getOptions();
	for (WebElement webElement : options) {
		System.out.println(webElement.getText());
	}
	System.out.println("==========");
}
}
