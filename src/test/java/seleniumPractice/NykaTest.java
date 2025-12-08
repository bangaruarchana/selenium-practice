package seleniumPractice;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class NykaTest {

	@Test
	public void nyka() throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// step 1 navigating to the url
		driver.get("https://www.nykaa.com/");

		// step 2 moving to the element
		Actions act = new Actions(driver);
		WebElement applianceLink = driver.findElement(By.xpath("//a[text()='appliances']"));
		WebElement toothBrushLink = driver.findElement(By.xpath("//a[text()=' Electric Toothbrushes']"));

		act.moveToElement(applianceLink).perform();
		Thread.sleep(2000);
		act.moveToElement(toothBrushLink).click().perform();

		// step 3 parent window identification
		String parentWin = driver.getWindowHandle();
//		System.out.println(parentWin);

		// step 4 multiple window identication
		Set<String> multiplewin = driver.getWindowHandles();
		System.out.println(multiplewin);
		for (String sel : multiplewin) {
			if (!sel.equals(parentWin)) {
				// step 5 switching from parent to child
				driver.switchTo().window(sel);
			}
		}
		// step 6 performing the actions on the child window
		WebElement discount = driver.findElement(By.xpath("//span[text()='Discount']"));
		WebElement color = driver.findElement(By.xpath("//span[text()='Color']"));
		act.moveToElement(color).perform();
		act.moveToElement(discount).click().perform();
		WebElement selction = driver.findElement(By.xpath("//span[text()='50% and above']"));
		act.moveToElement(selction).click().perform();

		if (discount.isDisplayed()) {
			System.out.println("discount is Displayed");
		} else {
			System.out.println("discount is not Dispalyed");

		}
		if (discount.isEnabled()) {
			System.out.println("discount is Enabled");
		} else {
			System.out.println("discount is not Enabled");

		}

		// step 7 getting the names and price of the product after adding the filters
		List<WebElement> names = driver.findElements(By.xpath("//div[@class=\"css-xrzmfa\"]"));
		List<WebElement> price = driver.findElements(By.xpath("//span[@class=\"css-111z9ua\"]"));

		for (int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i).getText() + "=====>" + price.get(i).getText());
		}

		driver.quit();
	}

}
