package Testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sep12 {

	public static void main(String[] args) throws InterruptedException, Exception {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://talent.capgemini.com/in");
		Thread.sleep(3000);
		WebElement edit = driver.findElement(By.xpath("//*[@id=\"editprofile\"]/span/a"));
		edit.click();
		Thread.sleep(3000);
		File src = new File("C:\\Users\\MAMIDIGR\\Desktop\\Editprofile.Xlsx");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook xsf = new XSSFWorkbook(fis);
		XSSFSheet sheet = xsf.getSheetAt(0);
		String emp1 = sheet.getRow(1).getCell(1).getStringCellValue();
		System.out.println(emp1);
		Thread.sleep(3000);
		WebElement search1 = driver.findElement(By.xpath("//a[@title='Edit profile (New Window)']"));
		search1.sendKeys("pra");
		Thread.sleep(4000);
		search1.sendKeys(Keys.ENTER);
		Thread.sleep(3000);

		// WebElement search1 = driver.findElement(By.xpath("//a[@title='Edit profile
		// (New Window)']"));
		// search1.sendKeys(emp1);
		// WebElement search2 = driver.findElement(By.xpath("//input[@type='text']"));
		// search2.click();
		// Thread.sleep(3000);
		// WebElement contact =
		// driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/form/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td[6]/a"));
		// contact.click();

	}

}
