package Mock;
import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class multipleWindows {

	public static void main(String[] args) {
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		Actions act=new Actions(driver);
		WebElement ele=driver.findElement(By.id("newWindowsBtn"));
		act.moveToElement(ele).click().perform();
		//		String parent = driver.getWindowHandle();
		//		System.out.println(parent);
		//		Set<String> allwindows=	driver.getWindowHandles();
		//		System.out.println(allwindows);
		//		String childWindowHandle = null;
		//		for (String windowshandle : allwindows) {
		//			if (!windowshandle.equals(parent)) {
		//				childWindowHandle = windowshandle;
		//				break;
		//			}
		//		}
		//		driver.switchTo().window(childWindowHandle);
		//		System.out.println(driver.getTitle());
		//		//System.out.println("executed till now");
		//
		//		driver.findElement(By.id("firstName")).sendKeys("archana");
		//		
		//			System.out.println("executed till now");
		//		
		//		driver.quit();
		//		//	driver.close();
		String parentwindow=driver.getWindowHandle();
		//System.out.println(parentwindow+driver.getTitle());

		Set<String> childwindows = driver.getWindowHandles();
		//    System.out.println(childwindows+driver.getTitle());

		for (String windows : childwindows) {
			if(windows.equals(windows)) {
				driver.switchTo().window(windows);
			}	}
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();
		driver.findElement(By.id("firstName")).sendKeys("archana");
		driver.quit();

	}
}
