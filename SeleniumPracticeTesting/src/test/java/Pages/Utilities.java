package Pages;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utilities {
	public static void getScreenshot(WebDriver driver){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        String formattedTimestamp = now.format(formatter);
        java.nio.file.Path destinationPath = Paths.get("./Screenshot/image_"+ formattedTimestamp+ "_Google1"+".png");
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(screenshotFile.toPath(), destinationPath);
            System.out.println("Screenshot saved to: " + destinationPath);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
