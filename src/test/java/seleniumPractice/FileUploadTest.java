package seleniumPractice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class FileUploadTest {

	@Test
	public void fileupload_sendKeys() {
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor execute = (JavascriptExecutor)driver; 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://practice.expandtesting.com/upload");
		//execute.executeScript("document.querySelector('iframe').style.display='none';");
		driver.manage().window().maximize();
		Actions actions = new Actions(driver);
		WebElement scrollTo = driver.findElement(By.xpath("//h4[text()='Practice Test Automation WebSite for Web UI and Rest API']"));
		//actions.scrollToElement(scrollTo).perform();
		execute.executeScript("arguments[0].scrollIntoView", scrollTo);

		// Correct way: pass absolute path string
		File interviewpdf = new File("./resource/shiva tarakesh 3.2 Years.pdf");
		driver.findElement(By.id("fileInput")).sendKeys(interviewpdf.getAbsolutePath());
		System.out.println("File selected");

		WebElement uploadButton = driver.findElement(By.xpath("//button[text()='Upload']"));

		//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntView(true);", uploadButton);
		//        
		//        ((JavascriptExecutor) driver).executeScript("arguements[0].click();", uploadButton);
		//        


		System.out.println("File uploaded");
		driver.quit();   
	}
	@Test 
	public void fileUpload_usingjavaScriptExecutor() {
		WebDriver driver=new ChromeDriver();
		driver.get("https://practice.expandtesting.com/upload");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement moveTo = driver.findElement(By.xpath("//a[text()='Expand Testing']"));
		js.executeScript("arguments[0].scrollToElement;", moveTo);
		WebElement chooseFile = driver.findElement(By.xpath("//input[@type=\"file\"]"));
		js.executeScript("arguments[0].click();", chooseFile);
		chooseFile.sendKeys("C:\\Users\\SRAVANTHI\\Downloads\\UST_Global_L1_Interview_Preparation.pdf");
		WebElement uploadButton = driver.findElement(By.xpath("//button[@id=\"fileSubmit\"]"));
		js.executeScript("arguments[0].click();", uploadButton);
		System.out.println("File Uploaded using JavaScriptexecutor");
		driver.quit();
	}

	@Test
	public void fileUpload_usingActionsClass() {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		driver.get("https://practice.expandtesting.com/upload");
		Actions act=new Actions(driver);
		WebElement pagedwn = driver.findElement(By.xpath("//a[text()='Expand Testing']"));
		act.scrollToElement(pagedwn).perform();
		WebElement chooseFile = driver.findElement(By.xpath("//input[@type=\"file\"]"));
		act.moveToElement(chooseFile).click().perform();
		act.sendKeys("C:\\Users\\SRAVANTHI\\Downloads\\UST_Global_L1_Interview_Preparation.pdf").perform();
		WebElement uploadButton = driver.findElement(By.xpath("//button[@id=\"fileSubmit\"]"));
		act.moveToElement(uploadButton).perform();
		System.out.println("File Uploaded by using Actions class");
		driver.quit();	
	}
	@Test
	public void fileUpload_usingRobotClass() throws AWTException {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://practice.expandtesting.com/upload");
		Robot r=new Robot();
		//storing the file path and using the toolkit() to get the data from clipboard
		StringSelection path=new StringSelection("C:\\Users\\SRAVANTHI\\Downloads\\UST_Global_L1_Interview_Preparation.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(path, null);
		//pressing the control+v 
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		//releasing the control+v
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		//pressing and releasing theenter key
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

		System.out.println("File uploaded using robot class");
		driver.quit();
	}
	@Test
	public void fileUpload_usingAbsolutePath() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://practice.expandtesting.com/upload");
		Actions act=new Actions(driver);
		WebElement pagedwn = driver.findElement(By.xpath("//a[text()='Expand Testing']"));
		act.scrollToElement(pagedwn).perform();
		WebElement chooseFile = driver.findElement(By.xpath("//input[@type=\"file\"]"));

		File file=new File("C:\\Users\\SRAVANTHI\\Downloads\\UST_Global_L1_Interview_Preparation.pdf");
		String path=file.getAbsolutePath();
		act.moveToElement(chooseFile).sendKeys(path);
		System.out.println("File Uploaded using Absolute path");
		driver.quit();


	}
}
