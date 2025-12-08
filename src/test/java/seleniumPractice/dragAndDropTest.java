package seleniumPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class dragAndDropTest {

	@Test
	public void dragAndDrop() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://practice.expandtesting.com/drag-and-drop");
		WebElement colA = driver.findElement(By.id("column-a"));
		WebElement colB = driver.findElement(By.id("column-b"));
		Actions act=new Actions(driver);
		act.dragAndDrop(colA, colB).perform();
		System.out.println("Drag and Drop performed");
		driver.close();
	}
	
	@Test
	public void dragAndDropCircles() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://practice.expandtesting.com/drag-and-drop-circles");
		WebElement drop = driver.findElement(By.xpath("//div[@dropzone=\"true\"]"));
		WebElement redcolor = driver.findElement(By.xpath("//div[@class=\"red\"]"));
		WebElement greencolor = driver.findElement(By.xpath("//div[@class=\"green\"]"));
		WebElement bluecolor = driver.findElement(By.xpath("//div[@class=\"blue\"]"));
		Actions act= new Actions(driver);
		act.dragAndDrop(drop, redcolor).perform();
		act.dragAndDrop(drop, bluecolor).perform();
		act.dragAndDrop(drop, greencolor).perform();
		System.out.println("All Colours are droped into the box");
		driver.close();
		
	}
	
}
