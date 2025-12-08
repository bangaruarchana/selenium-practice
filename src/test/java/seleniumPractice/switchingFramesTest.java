package seleniumPractice;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class switchingFramesTest {

	@Test
	public void Deafaultframes() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com/ui/frames?sublist=0");
		// WebElement framewebElement = driver.findElement(By.xpath("//iframe"));
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe")));
		driver.findElement(By.id("username")).sendKeys("bangaruarchana");
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("ravinderlakshmi");
		driver.findElement(By.xpath("//button[text()='Login']")).click();

		driver.quit();
	}

	@Test
	public void nestedFrame() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com/ui/frames/nested?sublist=1");
		/*
		 * Switching from 1 frame to another frame
		 */
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class=\"w-full h-96\"]")));
		System.out.println("switching to the frame");
//		WebElement frame2 = driver.findElement(By.xpath("//section[@class=\"main_form_container\"]//iframe"));
//		driver.switchTo().frame(frame2);
		WebElement frame2 = driver.findElement(By.xpath("//div[@class=\"frame-root\"]//h2[text()='Login']"));
		driver.switchTo().frame(frame2);
		System.out.println("switching to the 2nd frame");

		String mail = "Admin@gmail.com";
		String password = "Admin@1234";
		String confirmpassword = "Admin@1234";

		// entering the data into the text fields
		driver.findElement(By.xpath("//input[@type=\"email\"]")).sendKeys(mail);
		driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id=\"confirm-password\"]")).sendKeys(confirmpassword);
		driver.findElement(By.xpath("//button[text()='Sign Up']")).click();
		driver.switchTo().defaultContent();
		driver.quit();
	}

	@Test
	public void multipleFrames() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui/frames/multiple?sublist=2");
		/*
		 * handling first frame
		 */
		WebElement frame1 = driver.findElement(By.xpath("( //iframe[@class=\"w-full h-96\"])[1]"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.id("email")).sendKeys("Admin@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Admin@1234");
		driver.findElement(By.id("confirm-password")).sendKeys("Admin@1234");
		driver.findElement(By.xpath("//button[text()='Sign Up']")).click();
		System.out.println("Performed the actions on the first farme");
		driver.switchTo().parentFrame();
		/*
		 * handling second frame
		 */
		WebElement frame2 = driver.findElement(By.xpath("( //iframe[@class=\"w-full h-96\"])[2]"));
		driver.switchTo().frame(frame2);
		driver.findElement(By.id("username")).sendKeys("SuperAdmin@gmail.com");
		driver.findElement(By.id("password")).sendKeys("SuperAdmin@1234");
		driver.findElement(By.id("submitButton")).click();
		System.out.println("Performed the actions on the second farme");
		driver.switchTo().defaultContent();
		driver.quit();

	}

	@Test
	public void nestedMultipleFrames() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui/frames/nestedWithMultiple?sublist=3");
		/*
		 * it is in the main frame
		 */
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class=\"w-full h-96\"]")));
		System.out.println("switched to the main frame");
		driver.switchTo().parentFrame();
		/*
		 * switching to the next frame
		 */
		driver.switchTo().frame(driver.findElement(By.xpath("")));
		driver.quit();
	}
}
