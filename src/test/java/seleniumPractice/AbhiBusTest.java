package seleniumPractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class AbhiBusTest {
	@Test
	public void abhiBus() throws InterruptedException {

		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.abhibus.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		//step-1(enterning into from text field)
		WebElement from = driver.findElement(By.xpath("//input[@placeholder=\"Leaving From\"]"));
		from.sendKeys("Hyder");
		Thread.sleep(2000);
		WebElement hy = driver.findElement(By.xpath("//div[text()='Hyderabad']"));
		Actions act=new Actions(driver);
		act.moveToElement(hy).click().perform();

		//step-2(enterning into to textfield)
		WebElement to = driver.findElement(By.xpath("//input[@placeholder=\"Going To\"]"));
		Thread.sleep(2000);
		to.sendKeys("Goa");
		Thread.sleep(2000);
		WebElement toloc = driver.findElement(By.xpath("//div[text()='Goa']"));
		act.moveToElement(toloc).click().perform();

		driver.findElement(By.xpath("//input[@placeholder=\"Onward Journey Date\"]")).click();
		driver.findElement(By.xpath("//a[text()='18']")).click();
		driver.findElement(By.xpath("//span[text()='Search']")).click();
		Thread.sleep(2000);
		WebElement price = driver.findElement(By.xpath("//h5[text()='PSR Travels (Maharaja Group)']/ancestor::div[@id=\"service-container-3093152851\"]/descendant::span[@class=\"fare text-neutral-800\"]"));
		System.out.println(price.getText());

		
//		 List<WebElement> details = driver.findElements(By.xpath("//h5[text()='PSR Travels (Maharaja Group)']/ancestor::div[@id=\"service-cards-container\"]/descendant::div[@class=\"text-sm col auto\"]"));
//		
//		for (WebElement data : details) {
//			String names=data.getText();
//			System.out.println(names);
//		}
//		System.out.println();
//		 List<WebElement> busnames = driver.findElements(By.xpath("//h5[text()='PSR Travels Goa (SOARES)']/ancestor::div[@id=\"service-cards-container\"]/descendant::h5[@class=\"title\"]"));
//		//System.out.println(busnames.getFirst());
//		
//		for(WebElement ele:busnames) {
//			String names=ele.getText();
//			System.out.println(names);
//		}
		List<WebElement> details = driver.findElements(By.xpath("//div[@class=\"container service-info-left-section \"]"));
		
		for (WebElement webElement : details) {
			String busname = webElement.findElement(By.xpath(".//h5")).getText();
			String departure = webElement.findElement(By.xpath(".//span[@class=\"departure-time text-neutral-500\"]")).getText();
			String dep=webElement.findElement(By.xpath(".//span[@class=\"arrival-time text-neutral-500\"]")).getText();
			//String rating=webElement.findElement(By.xpath("//div[@class=\"mediumRating col\"]")).getText();
			System.out.println(busname+"===>"+departure+"===>"+dep);
			
		}
		
		driver.quit();



	}
}
