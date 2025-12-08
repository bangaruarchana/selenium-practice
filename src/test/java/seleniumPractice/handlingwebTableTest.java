package seleniumPractice;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.WebDriverManagerException;

public class handlingwebTableTest {

	@Test
	public void xpath() {
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		List<WebElement> cities = driver.findElements(By.xpath("//th[text()='City']/ancestor::table[@id='product']/descendant::tr/child::td[3]"));
		for (WebElement webElement : cities) {
			System.out.println(webElement.getText()+" ");
		}
		System.out.println("=========================");
		List<WebElement> names = driver.findElements(By.xpath("//th[text()='City']/ancestor::table[@id='product']/descendant::tr/td[1]"));
		for (WebElement tablenames : names) {
			System.out.println(tablenames.getText());
		}
		System.out.println("==========================");
		List<WebElement> rowData = driver.findElements(By.xpath("//th[text()='Position']/ancestor::table/descendant::tr"));
	    for (WebElement row : rowData) {
			System.out.println(row.getText()+" ");
		}
	    System.out.println("==========================");
	    List<WebElement> position = driver.findElements(By.xpath("//th[text()='Position']/ancestor::table/descendant::tr/td[2]"));
		for (WebElement pos : position) {
			System.out.println(pos.getText());
		}
	    driver.quit();
	}
	
	@Test 
	public void cricbizzTest() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.cricbuzz.com/cricket-stats/icc-rankings/men/batting");
		List<WebElement> ranking = driver.findElements(By.xpath("//a[@title=\"Joe Root's Profile\"]/ancestor::div[contains(@class,\"cb-col cb-col-100 cb-pa\")]/descendant::div[contains(@class,\"cb-col cb-col-100 c\")]"));
		
		for (WebElement webElement : ranking) {
			System.out.println(webElement.getText());
		}
		
		driver.quit();
	}
	
	@Test
	public void ODITest() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.cricbuzz.com/cricket-stats/icc-rankings/men/batting");
		driver.findElement(By.xpath("//a[@id=\"batsmen-odis-tab\"]")).click();
		List<WebElement> row = driver.findElements(By.xpath("//a[text()='Rohit Sharma']/ancestor::div[contains(@class,\"cb-col cb-col-100 cb-pa\")]/descendant::div[contains(@class,\"cb-col cb-col-100 c\")]"));
		for (WebElement webElement : row) {
			System.out.println(webElement.getText());
		}
		driver.quit();
		
	}
}
