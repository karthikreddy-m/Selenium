package Pages;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demoqa {
	public static void main(String[] args) throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Navigate to the form submission page
		driver.get("https://demoqa.com/automation-practice-form");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,8000)");

		String[][] testData = {
				{ "karthik", "Reddy", "karthik435@gmail.com", "Male", "7896543454", "Maths,Physics", "Sports",
						"C:\\Users\\MAMIDIGR\\Desktop\\WhatsApp Image 2022-07-08 at 3.43.07 PM.jpeg",
						"whitefield,bengaluru,karnataka", "NCR", "Delhi" },
				{ "glance", "john", "giri567@gmail.com", "Female", "0987654321", "Chemistry,Biology", "Music",
						"C:\\Users\\MAMIDIGR\\Desktop\\WhatsApp Image 2022-07-08 at 3.43.07 PM.jpeg",
						"krpuram,bengaluru,karnataka", "Uttar Pradesh", "Lucknow" } };

		for (String[] data : testData) {
			fillForm(driver, data);
			validateSubmission(driver);
			driver.navigate().refresh();
		}

		driver.quit();
	}

	public static void fillForm(WebDriver driver, String[] data) throws InterruptedException, IOException {
		driver.findElement(By.id("firstName")).sendKeys(data[0]);
		driver.findElement(By.id("lastName")).sendKeys(data[1]);
		driver.findElement(By.id("userEmail")).sendKeys(data[2]);
		driver.findElement(By.xpath("//label[text()='" + data[3] + "']")).click();
		driver.findElement(By.id("userNumber")).sendKeys(data[4]);

		// Select subjects
		String[] subjects = data[5].split(",");
		for (String subject : subjects) {
			WebElement subjectInput = driver.findElement(By.id("subjectsInput"));
			subjectInput.sendKeys(subject);
			subjectInput.sendKeys(Keys.RETURN);
		}

		// Select hobbies
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,200)");
		Thread.sleep(3000);

		String[] hobbies = data[6].split(",");
		for (String hobby : hobbies) {
			driver.findElement(By.xpath("//label[text()='" + hobby + "']")).click();
		}

		// Upload file
		driver.findElement(By.id("uploadPicture")).sendKeys(data[7]);

		// Fill address
		driver.findElement(By.id("currentAddress")).sendKeys(data[8]);

		// Select state and city
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("window.scrollBy(0,500)");
		Thread.sleep(1000);
		driver.findElement(By.id("state")).click();
		driver.findElement(By.xpath("//div[text()='" + data[9] + "']")).click();
		driver.findElement(By.id("city")).click();
		driver.findElement(By.xpath("//div[text()='" + data[10] + "']")).click();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");

		driver.findElement(By.id("submit")).click();
		Thread.sleep(3000);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");

		Date date = new Date();
		String timestamp = dateFormat.format(date);

		File screen3 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen3, new File("./Screenshot/image_" + timestamp + ".png"));
		Thread.sleep(3000);

	}

	public static void validateSubmission(WebDriver driver) {
		String successMessage = driver.findElement(By.id("example-modal-sizes-title-lg")).getText();
		assert successMessage.contains("Thanks for submitting the form");
	}
}

