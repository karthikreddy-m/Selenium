package Pages;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class Sep23 {

	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver1 = new ChromeDriver();
		driver1.manage().window().maximize();
		driver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Create Account
		driver1.get("https://magento.softwaretestingboard.com");
		driver1.findElement(By.xpath("//a[@href='https://magento.softwaretestingboard.com/customer/account/create/']"))
				.click();
		driver1.findElement(By.id("firstname")).sendKeys("Karthik");
		driver1.findElement(By.id("lastname")).sendKeys("Reddy");
		// email_address
		driver1.findElement(By.id("email_address")).sendKeys("mkarthikreddy92@gmail.com");
		driver1.findElement(By.id("password")).sendKeys("Mpr@1318");
		driver1.findElement(By.id("password-confirmation")).sendKeys("Mpr@1318");
		driver1.findElement(By.xpath("//button[@title='Create an Account']")).click();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		Thread.sleep(2000);

		Date date = new Date();
		String timestamp = dateFormat.format(date);

		File screen3 = ((TakesScreenshot) driver1).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen3, new File("./Screenshot/image_" + timestamp + ".png"));
		Thread.sleep(3000);

		// Sign in
		driver1.findElement(By.xpath(
				"//a[@href='https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS9jdXN0b21lci9hY2NvdW50L2NyZWF0ZS8%2C/']"))
				.click();
		driver1.findElement(By.id("email")).sendKeys("mkarthikreddy92@gmail.com");
		driver1.findElement(By.id("pass")).sendKeys("Mpr@1318");
		driver1.findElement(By.id("send2")).click();
		Thread.sleep(2000);
		File screen = ((TakesScreenshot) driver1).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File("./Screenshot/image1_" + timestamp + ".png"));
		WebElement Welcomemessage = driver1.findElement(By.xpath("//span[@class='logged-in']"));
		if (Welcomemessage.isDisplayed()) {
			System.out.println("Welcome karthik");
		}
		Thread.sleep(1000);
		driver1.findElement(By.xpath("//button[@data-action='customer-menu-toggle']")).click();
		Thread.sleep(1000);
		driver1.findElement(By.xpath("//a[@href='https://magento.softwaretestingboard.com/customer/account/logout/']"))
				.click();

		// driver1.navigate().refresh();
		// Invalid credentials
		driver1.findElement(By.xpath(
				"//a[@href='https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/']"))
				.click();
		driver1.findElement(By.id("email")).sendKeys("mkarthikreddy92@gmail.com");
		driver1.findElement(By.id("pass")).sendKeys("Mpr@131");
		Thread.sleep(1000);
		driver1.findElement(By.id("send2")).click();
		Thread.sleep(2000);
		File screen2 = ((TakesScreenshot) driver1).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen2, new File("./Screenshot/image2_" + timestamp + ".png"));
		Thread.sleep(1000);
		SoftAssert sa = new SoftAssert();
		
		//Invalid email
		driver1.findElement(By.xpath(
				"//a[@href='https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/']"))
				.click();
		driver1.findElement(By.id("email")).sendKeys("mkarthikredd192@gmail.com");
		driver1.findElement(By.id("pass")).sendKeys("Mpr@1318");
		Thread.sleep(1000);
		driver1.findElement(By.id("send2")).click();
		Thread.sleep(2000);
		File screen31 = ((TakesScreenshot) driver1).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen31, new File("./Screenshot/image3_" + timestamp + ".png"));
		Thread.sleep(1000);
		boolean invalidcred=driver1.findElement(By.xpath("//div[@data-bind=\"scope: 'messages'\"]")).isDisplayed();
		sa.assertTrue(invalidcred, "Third assertion failed: Error message is not displayed for invalid credentials");
		

	}

}
