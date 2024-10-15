package Testcase;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Moneyrediff {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://money.rediff.com/index.html");
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total links: " + links.size());
		for (WebElement link : links) {
			String url = link.getAttribute("href");
			if (url != null && !url.isEmpty()) {
				try {
					URL linkUrl = new URL(url);
					HttpsURLConnection httpsConn = (HttpsURLConnection) linkUrl.openConnection();
					httpsConn.connect();
					int responseCode = httpsConn.getResponseCode();
					if (responseCode > 400) {
						System.out.println(url + " is a broken link: ");
					} else {
						System.out.println(url + " is a valid link : ");
					}
				} catch (Exception e) {
					System.out.println("Exception occurred while checking URL: " + url);
					e.printStackTrace();
				}
			} else {
				System.out.println("Href is null or empty");
			}
		}

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(driver.getTitle());
		driver.quit();
	}
}