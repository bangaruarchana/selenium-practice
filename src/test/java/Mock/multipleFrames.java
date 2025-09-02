package Mock;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class multipleFrames {
		public static void main(String[] args) {
			
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			driver.get("https://demoapps.qspiders.com/ui/frames/multiple?sublist=2");
		//	WebElement frame = driver.findElement(By.xpath("//h2[text()=\"Sign Up\"]"));
			//driver.switchTo().frame("frame-root");//by name
			//driver.switchTo().frame(frame);//web element
			//driver.switchTo().frame(4);
			//driver.switchTo().frame("w-full h-96");
			driver.findElement(By.id("email")).sendKeys("bangaruarchana23@gmail.com");
			driver.findElement(By.id("password")).sendKeys("archana23");
			driver.findElement(By.id("confirm-password")).sendKeys("archana23");
			driver.findElement(By.id("submitButton")).click();
			driver.close();
		}
}
