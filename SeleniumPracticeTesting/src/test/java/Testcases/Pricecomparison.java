package Testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Pricecomparison {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	

		        try {
		            // Step 1: Go to Google
		            driver.get("https://www.google.com");

		            // Step 2: Search for "fasttrack"
		            WebElement searchBox = driver.findElement(By.name("q"));
		            searchBox.sendKeys("fasttrack");
		            searchBox.submit();

		            // Step 3: Click on the "Shopping" tab
		            WebElement shoppingTab = driver.findElement(By.linkText("Shopping"));
		            shoppingTab.click();

		  Thread.sleep(1000);
		            WebElement firstProduct = driver.findElement(By.xpath(""));
		            WebElement secondProduct = driver.findElement(By.cssSelector(".sh-dgr__grid-result:nth-child(2) .sh-dgr__content"));

		            String firstProductName = firstProduct.findElement(By.cssSelector(".sh-np__product-title")).getText();
		            String firstProductPrice = firstProduct.findElement(By.cssSelector(".sh-np__price")).getText();

		            String secondProductName = secondProduct.findElement(By.cssSelector(".sh-np__product-title")).getText();
		            String secondProductPrice = secondProduct.findElement(By.cssSelector(".sh-np__price")).getText();

		            // Print the product names and prices
		            System.out.println("First Product: " + firstProductName + " - Price: " + firstProductPrice);
		            System.out.println("Second Product: " + secondProductName + " - Price: " + secondProductPrice);

		        } finally {
		            // Close the browser
		           // driver.quit();
		        }
		    }
		}
