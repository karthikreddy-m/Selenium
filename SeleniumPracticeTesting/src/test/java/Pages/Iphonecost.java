package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Iphonecost {
	public static void main(String[] args) throws IOException, InterruptedException {
	System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://www.apple.com/in/");
	Thread.sleep(1000);

     // Click on buy for iPhone 16 Pro
     WebElement buyButton = driver.findElement(By.linkText("Buy"));
     buyButton.click();

     // Print the price of iPhone 16 Pro
 	Thread.sleep(1000);
     WebElement priceElement = driver.findElement(By.xpath("(//span[@class='nowrap'])[1]"));
     String australiaPrice = priceElement.getText();
     System.out.println("Price of iPhone 16 Pro in Australia: " + australiaPrice);

     // Select India
   
     WebElement indiaLink = driver.findElement(By.linkText("India"));
     indiaLink.click();
  

     // Click on buy for iPhone 16 Pro
     buyButton.click();

     // Print the price of iPhone 16 Pro
     priceElement = driver.findElement(By.cssSelector(".current_price"));
     String indiaPrice = priceElement.getText();
     System.out.println("Price of iPhone 16 Pro in India: " + indiaPrice);
 } 
}

//WebElement countryRegionDropdown = driver.findElement(By.id("ac-ls-dropdown-select"));
//countryRegionDropdown.click();
//Thread.sleep(1000);
//WebElement otherCountryRegion = driver.findElement(By.xpath("(//span[@class='ac-ls-dropdown-copy'])[3]"));
//Thread.sleep(1000);
//otherCountryRegion.click();
//WebElement continueButton = driver.findElement(By.cssSelector(".as-countryselector-continue"));
//continueButton.click();

