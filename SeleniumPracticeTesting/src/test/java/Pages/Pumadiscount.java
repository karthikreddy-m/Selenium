package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
public class Pumadiscount {

	    public static void main(String[] args) {
	    	System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        try {
	            // Navigate to the Puma shoes page
	            driver.get("https://in.puma.com/in/en/mens/mens-shoes");

	            // Maximize the browser window
	            driver.manage().window().maximize();

	            // Find and click on the discounted product
	            WebElement discountedProduct = driver.findElement(By.xpath("//div[contains(text(), 'PUMA Court Shatter Low Unisex Sneakers')]"));
	            discountedProduct.click();

	            // Get the original and discount prices
	            WebElement originalPriceElement = driver.findElement(By.cssSelector("[data-test-id='item-price-pdp']"));
	            WebElement discountPriceElement = driver.findElement(By.cssSelector("[data-test-id='item-sale-price-pdp']"));

	            String originalPriceText = originalPriceElement.getText();
	            String discountPriceText = discountPriceElement.getText();

	            // Parse the prices to float
	            float originalPrice = Float.parseFloat(originalPriceText.replaceAll("[^\\d.]", ""));
	            float discountPrice = Float.parseFloat(discountPriceText.replaceAll("[^\\d.]", ""));

	            // Calculate the discount amount and percentage
	            float discountAmount = originalPrice - discountPrice;
	            float discountPercentage = (discountAmount / originalPrice) * 100;

	            // Print the results
	            System.out.println("Original Price: ₹" + originalPrice);
	            System.out.println("Discount Price: ₹" + discountPrice);
	            System.out.println("Discount Amount: ₹" + discountAmount);
	            System.out.println("Discount Percentage: " + discountPercentage + "%");

	            // Verify that the discount percentage is greater than 0
	            if (discountPercentage > 0) {
	                System.out.println("Discount percentage is greater than 0");
	            } else {
	                System.out.println("Discount percentage is not greater than 0");
	            }
	        } finally {
	            // Close the browser
	            driver.quit();
	        }
	    }
	}
