package Pages;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sep18 {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver1 = new ChromeDriver();
		driver1.manage().window().maximize();
		driver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver1.get("https://www.google.com/");
		WebElement search = driver1
				.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/textarea"));
		search.sendKeys("Reebok shoes for men");
		search.sendKeys(Keys.ENTER);
		driver1.findElement(By.xpath("//div[text()='Shopping']")).click();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver1;
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(1000);
		driver1.findElement(By.xpath("//span[text()='Reebok']")).click();
		JavascriptExecutor js2 = (JavascriptExecutor) driver1;
		js2.executeScript("window.scrollBy(0,2000)");

		Thread.sleep(1000);
		WebElement seller = driver1.findElement(By.xpath(
				"//div[contains(text(), 'Seller')]//parent::div//following-sibling::div//child::span[contains(text(), 'Reebok')]"));
		seller.click();
		Thread.sleep(3000);
		WebElement sort = driver1.findElement(By.xpath("//div[@class='vkYnff']"));
		sort.click();
		WebElement price = driver1.findElement(By.xpath("//div[contains(text(), 'high to low')]"));
		price.click();
		// Screen shot
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		Date date = new Date();
		String timestamp = dateFormat.format(date);

		File screen1 = ((TakesScreenshot) driver1).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen1, new File(timestamp + "./Screenshotsep18/Sorting price_.png"));
		js.executeScript("window.scrollBy(0,200)");
		WebElement ExpensiveShoe = driver1.findElement(
				By.xpath("//*[@id=\"rso\"]/div[1]/div[2]/div/div[1]/div[1]/div[2]/div[2]/span/div[1]/div/a[2]/span"));
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", ExpensiveShoe);
		List<String> windowHandles = new ArrayList<>(driver1.getWindowHandles());
		driver1.switchTo().window(windowHandles.get(1));

		js.executeScript("window.scrollBy(0,500)");
		// ADD TO BAG
		WebElement addto = driver1.findElement(By.xpath("//button[@style='font-weight:normal;width:100%']"));
		Thread.sleep(1000);
		addto.click();
		File screen2 = ((TakesScreenshot) driver1).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen2, new File("./Screenshotsep18/image2_" + timestamp + ".png"));

		// GOTO BAG
		WebElement gotobag = driver1.findElement(By.xpath("//button[contains(text(), 'Go to Bag')]"));
		gotobag.click();

		// SIZE OF THE SHOE
		WebElement size = driver1
				.findElement(By.xpath("//div[@class='CustomDropdown_selectedText__SI6LK closeClick  ']"));
		size.click();
		// li[@name='7']
		WebElement reqsize = driver1.findElement(By.xpath("//li[@name='7']"));
		reqsize.click();
		Thread.sleep(2000);
		File screen3 = ((TakesScreenshot) driver1).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen3, new File("./Screenshotsep18/image3_" + timestamp + ".png"));
		WebElement quantity = driver1
				.findElement(By.xpath("(//div[@class='CustomDropdown_selectedText__SI6LK closeClick  '])[2]"));
		quantity.click();
		Thread.sleep(2000);
		driver1.switchTo().window(windowHandles.get(0));

		// SELECT 2ND HIGHEST SHOE
		WebElement ExpensiveShoe2 = driver1.findElement(
				By.xpath("//*[@id=\"rso\"]/div[1]/div[2]/div/div[2]/div[1]/div[2]/div[2]/span/div[1]/div/a[2]"));
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", ExpensiveShoe2);
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,300)");
		WebElement addto1 = driver1.findElement(By.xpath("(//button[@type='button'])[3]"));
		addto1.click();
		WebElement gotobag1 = driver1.findElement(By.xpath("//button[contains(text(), 'Go to Bag')]"));
		gotobag1.click();
		FileUtils.copyFile(screen3, new File(timestamp + "./Screenshotsep18/image3_.png"));

	        }



	}













//WebElement ExpensiveShoe1 = driver1.findElement(
//By.xpath("//*[@id=\"rso\"]/div[1]/div[2]/div/div[1]/div[1]/div[2]/div[2]/span/div[1]/div/a[2]/span"));
//Thread.sleep(2000);
//js.executeScript("arguments[0].click();", ExpensiveShoe);
//Thread.sleep(2000);
//
//// BAG
////WebElement bag = driver1.findElement(By.xpath("//i[contains(@class,\"HeaderRightOptions_cart_icon\")]"));
////bag.click();
//Thread.sleep(2000);


