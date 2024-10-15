package Testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {


	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demoqa.com/automation-practice-form");
		Thread.sleep(3000);
		String a = "Male";
		String hobby = "Sports";
		String subjects="maths,physics";
		String state = "Haryana";
		String city="Panipat";
		
		File src = new File("C:\\Users\\MAMIDIGR\\Desktop\\Editprofile.Xlsx");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook xsf = new XSSFWorkbook(fis);
		XSSFSheet sheet = xsf.getSheetAt(0);
		String firstname = sheet.getRow(1).getCell(1).getStringCellValue();
		String lastname = sheet.getRow(1).getCell(2).getStringCellValue();
		//String Email = sheet.getRow(1).getCell(3).getStringCellValue();
		//String phonenumber = sheet.getRow(1).getCell(4).getStringCellValue();
		//System.out.println(phonenumber);
		//String subjects = sheet.getRow(1).getCell(5).getStringCellValue();
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(firstname);
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(lastname);
		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("praveen1234@gmail.com");
		driver.findElement(By.xpath("//label[text()='" + a + "']")).click();
		// input[@id='userNumber']
		driver.findElement(By.xpath("//input[@id='userNumber']")).sendKeys("7979797977");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"dateOfBirthInput\"]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div[4]")).click();
		driver.findElement(By.id("subjectsInput")).sendKeys(subjects);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[text()='" + hobby + "']")).click();
		//Thread.sleep(3000);
		WebElement fileInput = driver.findElement(By.xpath("//*[@id=\"uploadPicture\"]"));
        String filePath = "C:\\Users\\MAMIDIGR\\Desktop\\WhatsApp Image 2022-07-08 at 3.43.07 PM.jpeg";
        fileInput.sendKeys(filePath);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"currentAddress\"]")).sendKeys("krpuram,bengaluru,karnataka");
        driver.findElement(By.xpath("//div[@class=' css-1wa3eu0-placeholder']")).click();
		driver.findElement(By.xpath("//div[text()='" + state + "']")).click();
        driver.findElement(By.id("city")).click();
        driver.findElement(By.xpath("//div[text()='" + city  + "']")).click();
        //Thread.sleep(3000);
		driver.findElement(By.id("submit")).click();
		WebElement Thanksforsubmittingtheform = driver.findElement(By.xpath("//div[@id='example-modal-sizes-title-lg']"));
		if (Thanksforsubmittingtheform.isDisplayed()) {
			System.out.println("Thanks for submitting the form");
		}
	}

	

}
