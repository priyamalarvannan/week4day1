package week4.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnFrames1 {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/frame.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//handle the frame
		driver.switchTo().frame(0);
		WebElement click1 = driver.findElement(By.xpath("//button[@id='Click']"));
		click1.click();
		String text = click1.getText();
		System.out.println(text);
		//get out of frame
		driver.switchTo().defaultContent();
		//handle nested frame
		driver.switchTo().frame(2);
		driver.switchTo().frame("frame2");
		WebElement nested = driver.findElement(By.xpath("//button[text()='Click Me']"));
		nested.click();
		String text2 = nested.getText();
		System.out.println(text2);
		//count frames
		driver.switchTo().defaultContent();
		List<WebElement> frameouter = driver.findElements(By.tagName("iframe"));
		int size = frameouter.size();
		System.out.println("the count of the frame" +size);
		//count inner frames
		int count=0;
		for(int i=0;i<size;i++)
		{
			driver.switchTo().frame(frameouter.get(i));
			List<WebElement> innerframe = driver.findElements(By.tagName("iframe"));
			count=count+innerframe.size();
			driver.switchTo().defaultContent();
			
		}
		System.out.println(count+size);
		
		
		
		
		
	}

}
