package Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Automationexer {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		try {
			driver.get("http://automationexercise.com");
			WebElement homePage = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[1]/a"));
			if (homePage.isDisplayed()) {
				System.out.println("Home page is visible successfully.");
			}
			driver.findElement(By.xpath("//a[contains(text(),'Signup / Login')]")).click();
			Thread.sleep(3000);
			WebElement loginToYourAccount = driver
					.findElement(By.xpath("//h2[contains(text(),'Login to your account')]"));
			if (loginToYourAccount.isDisplayed()) {
				System.out.println("'Login to your account' is visible.");
			}
			driver.findElement(By.name("email")).sendKeys("abcd123456@gmail.com");
			driver.findElement(By.name("password")).sendKeys("abcd@1234");
			driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
			WebElement loggedInAsUsername = driver.findElement(By.xpath("//a[contains(text(),'Logged in as')]"));
			if (loggedInAsUsername.isDisplayed()) {
				System.out.println("'Logged in as username' is visible.");
			}
			

		} finally {
			driver.quit();
		}
	}
}
