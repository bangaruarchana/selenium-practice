package webInputs;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class WebInputs {

	@Test
	public void functionalityNumberTest() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://practice.expandtesting.com/inputs");
		WebElement pagedwn=driver.findElement(By.xpath("//h4[text()='Practice Test Automation WebSite for Web UI and Rest API']"));
		Actions act=new Actions(driver);
		act.scrollToElement(pagedwn).perform();
		driver.findElement(By.id("input-number")).sendKeys("12345678910102030405060");
		Thread.sleep(2000);
		driver.findElement(By.id("btn-display-inputs")).click();
		driver.findElement(By.id("btn-clear-inputs")).click();
		Thread.sleep(2000);

		driver.findElement(By.id("input-number")).sendKeys("1");
		Thread.sleep(2000);
		driver.findElement(By.id("btn-display-inputs")).click();
		driver.findElement(By.id("btn-clear-inputs")).click();
		Thread.sleep(2000);

		driver.findElement(By.id("input-number")).sendKeys("");
		driver.findElement(By.id("btn-display-inputs")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("btn-clear-inputs")).click();

		driver.quit();
	}
	@Test
	public void textTest() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://practice.expandtesting.com/inputs");
		WebElement pagedwn=driver.findElement(By.xpath("//h4[text()='Practice Test Automation WebSite for Web UI and Rest API']"));
		Actions act=new Actions(driver);
		act.scrollToElement(pagedwn).perform();
		driver.findElement(By.id("input-text")).sendKeys("ASDGASDFN478521");
		driver.findElement(By.id("btn-display-inputs")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("btn-clear-inputs")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("input-text")).sendKeys("13854654561!@#$%^");
		driver.findElement(By.id("btn-display-inputs")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("btn-clear-inputs")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("input-text")).sendKeys("!@#$%sxcvb7412585");
		driver.findElement(By.id("btn-display-inputs")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("btn-clear-inputs")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("input-text")).sendKeys("");
		driver.findElement(By.id("btn-display-inputs")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("btn-clear-inputs")).click();
		Thread.sleep(2000);
		
		driver.quit();
	}
	
	@Test
	public void passwordTest() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://practice.expandtesting.com/inputs");
		WebElement pagedwn=driver.findElement(By.xpath("//h4[text()='Practice Test Automation WebSite for Web UI and Rest API']"));
		Actions act=new Actions(driver);
		act.scrollToElement(pagedwn).perform();
		driver.findElement(By.id("input-password")).sendKeys("8454465asdfgh");
		driver.findElement(By.id("btn-display-inputs")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("btn-clear-inputs")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("input-password")).sendKeys("!@#$%");
		driver.findElement(By.id("btn-display-inputs")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("btn-clear-inputs")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("input-password")).sendKeys("8");
		driver.findElement(By.id("btn-display-inputs")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("btn-clear-inputs")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("input-password")).sendKeys("");
		driver.findElement(By.id("btn-display-inputs")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("btn-clear-inputs")).click();
		Thread.sleep(2000);
		
		driver.quit();
	}
	
	@Test
	public void dateTest() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://practice.expandtesting.com/inputs");
		WebElement pagedwn=driver.findElement(By.xpath("//h4[text()='Practice Test Automation WebSite for Web UI and Rest API']"));
		Actions act=new Actions(driver);
		act.scrollToElement(pagedwn).perform();
		WebElement date = driver.findElement(By.id("input-date"));
		date.click();
		date.sendKeys("08-06-2025");
		driver.findElement(By.id("btn-display-inputs")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("btn-clear-inputs")).click();
		Thread.sleep(2000);
		driver.quit();
	
	}
	@Test
	public void forgotPassword() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://practice.expandtesting.com/forgot-password");
		WebElement pagedwn = driver.findElement(By.xpath("//h4[contains(text(),'Practice Test Automation')]"));
		Actions act=new Actions(driver);
		act.scrollToElement(pagedwn);
		driver.findElement(By.id("email")).sendKeys("bangaruarcha23@gmail.com");
		driver.findElement(By.xpath("//button[text()='Retrieve password']")).click();
		String actual="An e-mail has been sent to you which explains how to reset your password.";
		assertEquals(actual, "An e-mail has been sent to you which explains how to reset your password.");
		driver.quit();
	}

}

