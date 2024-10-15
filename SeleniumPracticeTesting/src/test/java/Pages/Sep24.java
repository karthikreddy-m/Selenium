package Pages;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sep24 {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Excel part
		File src = new File("C:\\Users\\MAMIDIGR\\Desktop\\Automationexercise.Xlsx");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook xsf = new XSSFWorkbook(fis);
		XSSFSheet sheet = xsf.getSheetAt(0);
		String Name = sheet.getRow(1).getCell(0).getStringCellValue();
		String Email = sheet.getRow(1).getCell(1).getStringCellValue();
		String Password = sheet.getRow(1).getCell(2).getStringCellValue();
		// date
		int date = (int) sheet.getRow(1).getCell(3).getNumericCellValue();
		System.out.println(date);
		Thread.sleep(5000);
		// month
		int Month = (int) sheet.getRow(1).getCell(4).getNumericCellValue();
		String Month1 = String.valueOf((int) Month);
		// year
		int Year = (int) sheet.getRow(1).getCell(5).getNumericCellValue();
		String strYear = String.valueOf((int) Year);
		String firstname = sheet.getRow(1).getCell(6).getStringCellValue();
		String Lastname = sheet.getRow(1).getCell(7).getStringCellValue();
		String Company = sheet.getRow(1).getCell(8).getStringCellValue();
		String Address = sheet.getRow(1).getCell(9).getStringCellValue();
		String State = sheet.getRow(1).getCell(10).getStringCellValue();
		String City = sheet.getRow(1).getCell(11).getStringCellValue();
		// zipcode
		int Zipcode = (int) sheet.getRow(1).getCell(12).getNumericCellValue();
		String strZipcode = String.valueOf((int) Zipcode);
		// mble number
		int Mobilenumber = (int) sheet.getRow(1).getCell(13).getNumericCellValue();
		String strMobilenumber = String.valueOf((int) Mobilenumber);

		// Create Account
		driver.get("http://automationexercise.com");
		WebElement homePage = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[1]/a"));
		Thread.sleep(2000);
		
		// Screenshot
		String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
		File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File("./Screenshot/image_" + "homepage_" + timestamp + ".png"));

		// Validation
		if (homePage.isDisplayed()) {
			System.out.println("Home page is visible successfully.");
		}
		// Signup
		driver.findElement(By.xpath("//a[contains(text(),'Signup / Login')]")).click();
		Thread.sleep(3000);
		WebElement loginToYourAccount = driver.findElement(By.xpath("//h2[contains(text(),'Login to your account')]"));
		Thread.sleep(2000);
		// Screenshot
		File screen1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen1, new File("./Screenshot/image_" + "Login to your account_" + timestamp + ".png"));

		// Validation
		if (loginToYourAccount.isDisplayed()) {
			System.out.println("'Login to your account' is visible.");
			
			//Fill Required fields

			driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys(Name);
			driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys(Email);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
			driver.findElement(By.xpath("//input[@id='id_gender1']")).click();
			driver.findElement(By.xpath("//input[@data-qa='password']")).sendKeys(Password);
			// Date
			driver.findElement(By.xpath("//select[@data-qa='days']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//select[@data-qa='days']//option[@value='" + date + "']")).click();
			driver.findElement(By.xpath("//select[@data-qa='months']//option[@value='" + Month1 + "']")).click();
			driver.findElement(By.xpath("//select[@data-qa='years']//option[@value='" + strYear + "']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@data-qa='first_name']")).sendKeys(firstname);
			driver.findElement(By.xpath("//input[@data-qa='last_name']")).sendKeys(Lastname);
			driver.findElement(By.xpath("//input[@data-qa='company']")).sendKeys(Company);
			driver.findElement(By.xpath("//input[@data-qa='address']")).sendKeys(Address);
			driver.findElement(By.xpath("//input[@data-qa='state']")).sendKeys(State);
			driver.findElement(By.xpath("//input[@data-qa='city']")).sendKeys(City);
			driver.findElement(By.xpath("//input[@data-qa='zipcode']")).sendKeys(strZipcode);
			driver.findElement(By.xpath("//input[@data-qa='mobile_number']")).sendKeys(strMobilenumber);
			driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();

			// Product added to the cart
			driver.findElement(By.xpath("//a[@href='/products']")).click();
			// Screenshot
			File screen2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screen2, new File("./Screenshot/image_" + "Logged in as_" + timestamp + ".png"));

			// scroll
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,3000)");

			driver.findElement(By.xpath("//a[@data-product-id='2']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block']")).click();
			driver.findElement(By.xpath("//i[@class='fa fa-shopping-cart']")).click();
			// Screenshot
			File screen3 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screen3,
					new File("./Screenshot/image_" + "product added to cart_" + timestamp + ".png"));

			driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();
			// screenshot
			File screen4 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screen4, new File("./Screenshot/image_" + "Address comparison_" + timestamp + ".png"));

			// Assertion
			// Address
			String delvAddress2 = driver.findElement(By.xpath("(//li[@class='address_address1 address_address2'])[2]"))
					.getText();
			boolean isAddress2eaquals = delvAddress2.contains(Address);
//	    	// City and state
//	    	String country = driver.findElement(By.xpath("(//li[@class='address_country_name'])[1]")).getText();
//	    	boolean isdelStateAndCityeaquals = country.contains(country);   	
			Boolean delveryAddress;
			if (isAddress2eaquals) {
				delveryAddress = Boolean.TRUE;
			} else {
				delveryAddress = Boolean.FALSE;
			}

			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("window.scrollBy(0,3000)");
			driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();
			// Screenshot
			Utilities.getScreenshot(driver);
			// Card Details
			WebElement cardname = driver.findElement(By.xpath("//input[@data-qa='name-on-card']"));
			cardname.sendKeys("Giridhar Reddy");
			Thread.sleep(1000);
			WebElement cardnub = driver.findElement(By.xpath("//input[@data-qa='card-number']"));
			cardnub.sendKeys("6547 3456 8978");
			Thread.sleep(1000);
			WebElement cvv = driver.findElement(By.xpath("//input[@data-qa='cvc']"));
			cvv.sendKeys("455");
			Thread.sleep(1000);
			WebElement expirymnth = driver.findElement(By.xpath("//input[@data-qa='expiry-month']"));
			expirymnth.sendKeys("9");
			Thread.sleep(1000);
			WebElement expiryyer = driver.findElement(By.xpath("//input[@data-qa='expiry-year']"));
			expiryyer.sendKeys("2025");
			driver.findElement(By.xpath("//button[@class='form-control btn btn-primary submit-button']")).click();
			Thread.sleep(2000);
			// screenshot
			File screen5 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screen5, new File("./Screenshot/image_" + "order placed_" + timestamp + ".png"));

			driver.findElement(By.xpath("//a[@class='btn btn-default check_out']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//i[@class='fa fa-trash-o']")).click();
			// Screenshot
			File screen6 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screen6, new File("./Screenshot/image_" + "Account deletion_" + timestamp + ".png"));
			Thread.sleep(2000);

		}

	}
}
