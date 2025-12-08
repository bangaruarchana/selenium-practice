package seleniumPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class radioButtonsTest {
@Test
public void radiobuttons() {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://practice.expandtesting.com/radio-buttons");
	driver.findElement(By.id("blue")).click();
	System.out.println("Clicked on the blue radiobutton button");
	System.out.println();
	
	driver.findElement(By.id("red")).click();
	System.out.println("Clicked on the red radiobutton button");
    System.out.println();
    
	driver.findElement(By.id("yellow")).click();
	System.out.println("Clicked on the yellow radiobutton button");	
	
    System.out.println();
    //need to scroll the webpage
	
	driver.findElement(By.id("black")).click();
	System.out.println("Clicked on the black radiobutton button");
		
//    System.out.println();
//	
//	driver.findElement(By.id("green")).click();
//	System.out.println("Clicked on the green radiobutton button");
	driver.close();
	
}
}
