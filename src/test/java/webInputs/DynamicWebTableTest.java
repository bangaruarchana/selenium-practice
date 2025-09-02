package webInputs;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DynamicWebTableTest {

	@Test
	public void chromeCPU() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(14));
		
		driver.get("https://practice.expandtesting.com/dynamic-table");
		WebElement chrome = driver.findElement(By.xpath("//div[text()='Task Manager']/parent::div[@class=\"col-md-6\"]/descendant::td[3]"));
		System.out.println(chrome.getText());
		WebElement element = driver.findElement(By.xpath("//p[@id=\"chrome-cpu\"]"));
		String text = element.getText();
		if(chrome.equals(text)) {
			System.out.println("Both are equal"+chrome.getText()+" "+element.getText());
		}
		else {
			System.out.println("Not equal"+" "+chrome.getText()+" "+element.getText());
		}
//		System.out.println(text);
//		String text1 = "";
//
//		char start = ':';
//		char end = '%';
//		boolean flag = false;
//
//		char[] ch = text.toCharArray();
//
//		for (int i = 0; i < ch.length; i++) {
//			if (ch[i] == start) {
//				flag = true;
//				continue;
//			}
//			if (flag) {
//				text1 = text1+ch[i];
//				if (ch[i] == end) {
//					break;
//				}
//			}
//		}
//
//		System.out.println(text1.trim());
		driver.quit();
	}
}
