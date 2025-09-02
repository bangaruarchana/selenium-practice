package Mock;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HandlingMultipleWindows {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		 String parentWindow = driver.getWindowHandle();
		 JavascriptExecutor execute = (JavascriptExecutor)driver;
			WebElement ele=driver.findElement(By.id("newWindowsBtn"));
			execute.executeScript("arguments[0].scrollIntoView", ele);
		Set<String> allWindows = driver.getWindowHandles();
		
		for (String string : allWindows) {
			
		System.out.println(string);
		}
	}
		

}
