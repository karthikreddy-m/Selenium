package Pages;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Makemytrip {
	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.edge.driver", "./Drivers/msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		try {

			driver.get("http://www.makemytrip.com/");
			driver.manage().window().maximize();

			try {
				WebElement loginPopupCloseButton = driver.findElement(By.xpath("//span[@data-cy='closeModal']"));
				loginPopupCloseButton.click();
			} catch (Exception e) {

			}

			// Enter the source city
			WebElement fromCity = driver.findElement(By.id("fromCity"));
			fromCity.click();
			WebElement fromCityInput = driver.findElement(By.xpath("//input[@placeholder='From']"));
			fromCityInput.sendKeys("Bangalore");
			driver.findElement(By.xpath("//p[contains(text(),'Bengaluru, India')]")).click();

			// Enter the destination city
			WebElement toCity = driver.findElement(By.id("toCity"));
			toCity.click();
			WebElement toCityInput = driver.findElement(By.xpath("//input[@placeholder='To']"));
			toCityInput.sendKeys("Delhi");
			driver.findElement(By.xpath("//p[contains(text(),'New Delhi, India')]")).click();
            WebElement today = driver.findElement(By.xpath("//p[@class=' todayPrice']"));
            today.click();

			// Click on the search button
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[text()='Search']")).click();

			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			// Find all the flight prices
			List<WebElement> prices = driver.findElements(By.xpath("//div[@class='priceSection']//p"));

			// Find the cheapest flight
			   List<WebElement> prices1 = driver.findElements(By.xpath("//span[@class='actual-price']"));
	            WebElement cheapestFlight = prices1.stream().min((p1, p2) -> {
	                int price1 = Integer.parseInt(p1.getText().replaceAll("[^0-9]", ""));
	                int price2 = Integer.parseInt(p2.getText().replaceAll("[^0-9]", ""));
	                return Integer.compare(price1, price2);
	            }).orElseThrow(() -> new RuntimeException("No flights found"));
	            cheapestFlight.click();

	            // Compare price differences for different categories
	            String[] categories = {"Regular", "Student", "Senior Citizen", "Armed Forces", "Doctor and Nurses"};
	            for (String category : categories) {
	                WebElement categoryElement = driver.findElement(By.xpath("//label[text()='" + category + "']"));
	                categoryElement.click();
	                WebElement priceElement = driver.findElement(By.xpath("//span[@class='actual-price']"));
	                System.out.println(category + " price: " + priceElement.getText());

		}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close the browser
			// driver.quit();
		}
	
}
}

