package Pages;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Addtocart {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://automationexercise.com");
		WebElement homePage = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[1]/a"));
		if (homePage.isDisplayed()) {
			System.out.println("Home page is visible successfully.");
		}
		Thread.sleep(5000);
		String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
		File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File("./ScreenshotOct1/image_" + "homepage_" + timestamp + ".png"));
		driver.findElement(By.xpath("//a[contains(text(),'Signup / Login')]")).click();
		Thread.sleep(3000);

		// LOGIN
		driver.findElement(By.name("email")).sendKeys("abcd123456@gmail.com");
		driver.findElement(By.name("password")).sendKeys("abcd@1234");
		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
		Thread.sleep(1000);
		String timestamp1 = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
		File screen1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen1, new File("./ScreenshotOct1/image_" + "Login_" + timestamp1 + ".png"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		// PRODUCT SELECT
		driver.findElement(By.xpath("//a[@data-product-id='1']")).click();
		Thread.sleep(2000);
		// button[@data-dismiss='modal']
		driver.findElement(By.xpath("//button[@data-dismiss='modal']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@data-product-id='7']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@data-dismiss='modal']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@data-product-id='8']")).click();
		Thread.sleep(1000);

		// CONTINUE SHOPPING
		driver.findElement(By.xpath("//button[@data-dismiss='modal']")).click();

		// VIEW CART
		Thread.sleep(1000);
		driver.findElement(By.xpath("//i[@class='fa fa-shopping-cart']")).click();
		Thread.sleep(2000);
		String timestamp2 = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
		File screen2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen2, new File("./ScreenshotOct1/image_" + "Cart total_" + timestamp2 + ".png"));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(2000);
		String prod1 = driver.findElement(By.xpath("(//td[@class='cart_price'])[1]")).getText();
		String getPrice = prod1.replace("Rs", "").replace(".", "").trim();
		System.out.println("Price of the first product:"+getPrice);

		String prod2 = driver.findElement(By.xpath("(//td[@class='cart_price'])[2]")).getText();
		String getPrice1 = prod2.replace("Rs", "").replace(".", "").trim();
		System.out.println("Price of the second product:"+getPrice1);

		String prod3 = driver.findElement(By.xpath("(//td[@class='cart_price'])[3]")).getText();
		String getPrice2 = prod3.replace("Rs", "").replace(".", "").trim();
		System.out.println("Price of the third product:"+getPrice2);
		double ProductorgPrice = Double.parseDouble(getPrice);
		double ProductorgPrice1 = Double.parseDouble(getPrice1);
		double ProductorgPrice2 = Double.parseDouble(getPrice2);
		double sum = (ProductorgPrice + ProductorgPrice1 + ProductorgPrice2);
		String productsum = String.valueOf(sum);
		System.out.println("sumof the products=" + sum);

		// PROCEED TO CHECKOUT
		driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("window.scrollBy(0,800)");
		Thread.sleep(2000);
		String timestamp3 = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
		File screen3 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen3, new File("./ScreenshotOct1/image_" + "Total price_" + timestamp3 + ".png"));
		String sumofproducts = driver.findElement(By.xpath("(//p[@class='cart_total_price'])[4]")).getText();
		String getpriceprod = sumofproducts.replace("Rs", "").replace(".", "").trim();
		
		double productprice = Double.parseDouble(getpriceprod);
		String productsum1 = String.valueOf(productprice);
		System.out.println("sum of the three products=" + productsum1);
	
		Thread.sleep(3000);
		if (productsum1.contains(productsum)) {
			System.out.println("Sum of products value and sum of cart value is same");
		}

		// VIEW CART
		driver.findElement(By.xpath("//i[@class='fa fa-shopping-cart']")).click();
		// a[@class='cart_quantity_delete'][1]
		Thread.sleep(4000);
		// REMOVE PRODUCT
		driver.findElement(By.xpath("//a[@class='cart_quantity_delete'][1]")).click();
		// Checkout

		driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();
		Thread.sleep(3000);
		JavascriptExecutor js3 = (JavascriptExecutor) driver;
		js3.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		String timestamp4 = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
		File screen4 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen4, new File("./ScreenshotOct1/image_" + "finalprice_" + timestamp4 + ".png"));
		String sumoftwoproducts = driver.findElement(By.xpath("(//p[@class='cart_total_price'])[3]")).getText();
		System.out.println("sum of two the products=" + sumoftwoproducts);

     Thread.sleep(6000);
	 driver.close();

	}

}
