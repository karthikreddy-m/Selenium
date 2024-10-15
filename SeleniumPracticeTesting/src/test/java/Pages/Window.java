package Pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Window {
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://demoqa.com/browser-windows");
	String windowhandle=driver.getWindowHandle();
	System.out.println("Parent window handle:"+windowhandle);
	for(int i=1;i<=3;i++){
	driver.findElement(By.id("windowButton")).click();
	}
	Set<String> windowhandles=driver.getWindowHandles();
	for(String handle:windowhandles) {
		System.out.println("window handles are :"+handle);
	}
		
		
		
	

}
}
