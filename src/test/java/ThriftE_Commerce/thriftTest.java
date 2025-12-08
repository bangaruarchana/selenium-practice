package ThriftE_Commerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class thriftTest {

	@Test
	public void dropdown() {
		WebDriver driver=new ChromeDriver();
		driver.get("https://thrift.plus/women/dresses");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[text()='Decline all']")).click();
		driver.findElement(By.xpath("//button[@aria-haspopup=\"menu\"]")).click();
		driver.findElement(By.xpath("//span[text()=\"Price (high to low)\"]")).click();
		driver.quit();
	}
}
