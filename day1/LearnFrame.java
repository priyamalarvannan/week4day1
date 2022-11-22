package week4.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnFrame {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//Click Try It Button
		/*Click OK/Cancel in the alert
		Confirm the action is performed correctly by verifying the text !!
		 Hint:
		-----
		Switch to the frame
		Then click Try It with xpath
		Switch to the alert
		Then perform accept / dismiss
		Get the text using id 
		Verify the text based on the action*/
		/*driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[2]")).click();
	Alert ca = driver.switchTo().alert();
	String text3 = ca.getText();
	System.out.println(text3);
	ca.dismiss();*/
		
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		Alert alt = driver.switchTo().alert();
		String text = alt.getText();
		System.out.println(text);
		alt.accept();
		String text2 = driver.findElement(By.id("demo")).getText();
		System.out.println(text2);
		if(text2.contains("pressed"))
		{
			System.out.println("the element is clicked");
		}
		
		//snap shot learning
		File source = driver.getScreenshotAs(OutputType.FILE);
		File dest=new File("./snap/frame.png");
		FileUtils.copyFile(source, dest);
		
	
		
		
		
		
	}

}
