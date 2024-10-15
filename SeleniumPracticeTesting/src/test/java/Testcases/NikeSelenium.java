package Testcases;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.Utilities;

import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class NikeSelenium {
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// SCREEN SHOT
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		Date date = new Date(0);
		String timestamp = dateFormat.format(date);

		try {
			// Go to https://www.nike.com/in/
			driver.get("https://www.nike.com/in/");

			// Click on Men
			WebElement menLink = driver.findElement(By.linkText("Men"));
			menLink.click();

			// Click on Shoes
			WebElement shoesLink = driver.findElement(By.linkText("Shoes"));

			shoesLink.click();
			File screen1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screen1, new File("./Screenshotsep30/" + timestamp + "_Google1" + ".png"));

			// Click on Sort By
			Thread.sleep(2000);
			WebElement sortBy = driver.findElement(By.xpath("//*[@id=\"dropdown-btn\"]/span[1]/span[1]"));
			sortBy.click();

			// Click on High to Low
			WebElement highToLow = driver.findElement(By.xpath("//button[contains(text(), 'High-Low')]"));
			highToLow.click();
			File screen2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screen2, new File("./Screenshotsep30/" + timestamp + "_Google2" + ".png"));
			// Wait for the page to load sorted results
			Thread.sleep(3000);

			// the products count in displayed page
			List<WebElement> products = driver.findElements(By.cssSelector("div.product-card__body"));
			System.out.println("Total products displayed: " + products.size());

			// the prices in displayed page
			List<WebElement> prices = driver.findElements(By.cssSelector("div.product-price"));
			for (WebElement price : prices) {
				System.out.println(price.getText());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Thread.sleep(6000);
			driver.quit();
		}
	}

}
