package seleniumPractice;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrokenLinkTest {

	@Test
	public void brokenLinks() throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://thrift.plus/men");
		List<WebElement> alllinks = driver.findElements(By.xpath("//a"));
		int size = alllinks.size();
		System.out.println(size);

		for (WebElement l : alllinks) {

			String values = l.getAttribute("href");
			System.out.println(l.getText());
			if (values == null || values.isEmpty()) {
				System.out.println("We cannot check");
				continue;
			}
			URL u = new URL(values);
			HttpsURLConnection con = (HttpsURLConnection) u.openConnection();
			con.connect();
			if (con.getResponseCode() >= 400) {
				System.out.println(values + "=====>" + con.getResponseCode() + "=====>" + "It is a Broken link");
			} else {
				System.out.println(values + "====>" + "It is not a broken link");
			}
		}
		driver.close();

	}
}
