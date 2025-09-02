package Login;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class LoginTest {
	@Test
	public void loginTest() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://practice.expandtesting.com/login");
		assertTrue(true, driver.getTitle());
		driver.findElement(By.id("username")).sendKeys("practice");
		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
		WebElement submitBtn = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
		Actions actions = new Actions(driver);
		actions.scrollToElement(driver.findElement(By.xpath("//h3[text()='How Does Form-Based Authentication Work?']"))).perform();
		submitBtn.click();
		Thread.sleep(2000);
		//  assertTrue(true, "Secure Area");
		// Thread.sleep(2000);
		//assertTrue(true, "You logged into a secure area!");
		//Thaead.sleep(1000);
		WebElement actualresult = driver.findElement(By.xpath("//li[text()='Secure Area']"));
		String actual = actualresult.getText();
		assertEquals(actual, "Secure Area");

		WebElement actres = driver.findElement(By.xpath("//b[text()='You logged into a secure area!']"));

		String logres=actres.getText();
		System.out.println(logres);
		assertEquals(logres, "You logged into a secure area!");

		assertTrue(true, " Logout");
		System.out.println("Logout is Displayed");
		driver.quit();

	}
	@Test
	public void invalidpasswordtest() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://practice.expandtesting.com/login");
		assertTrue(true, driver.getTitle());
		System.out.println(driver.getTitle());
		driver.findElement(By.id("username")).sendKeys("practice");
		driver.findElement(By.id("password")).sendKeys("Mahadev3#");
		WebElement submitBtn = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
		Actions actions = new Actions(driver);
		actions.scrollToElement(driver.findElement(By.xpath("//h3[text()='How Does Form-Based Authentication Work?']"))).perform();
		submitBtn.click();
		assertTrue(true, "Your password is invalid!");
		System.out.println(driver.getTitle());
		Thread.sleep(2000);
		driver.quit();
	}
	
	@Test
	public void invalidUsernametest() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://practice.expandtesting.com/login");
		assertTrue(true, driver.getTitle());
		System.out.println(driver.getTitle());
		driver.findElement(By.id("username")).sendKeys("archana");
		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
		WebElement submitBtn = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
		Actions actions = new Actions(driver);
		actions.scrollToElement(driver.findElement(By.xpath("//h3[text()='How Does Form-Based Authentication Work?']"))).perform();
		submitBtn.click();
		assertTrue(true, "Your username is invalid!");
		System.out.println(driver.getTitle());
		Thread.sleep(2000);
		driver.quit();
	}

	@Test
	public void otpLogin() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://practice.expandtesting.com/otp-login");
		driver.findElement(By.id("email")).sendKeys("practice@expandtesting.com");
		Thread.sleep(2000);
		driver.findElement(By.id("btn-send-otp")).click();
		driver.findElement(By.id("otp")).sendKeys("214365");
		Thread.sleep(2000);
		WebElement pagedwn = driver.findElement(By.xpath("//h4[text()='Practice Test Automation WebSite for Web UI and Rest API']"));
		Actions act=new Actions(driver);
		act.scrollToElement(pagedwn).perform();
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		String actual="Welcome to the Secure Area. When you are done click logout below.";
        assertTrue(true, actual);
        driver.quit();
	}
}
