package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnWindows {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/window.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//get the current window
		String currentwin = driver.getWindowHandle();
		System.out.println(currentwin);
		//get the current window title
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//span[text()='Open']")).click();
		//System.out.println(currentwin);
		System.out.println(driver.getWindowHandle());
		System.out.println(driver.getTitle());
		//second window
		Set<String> secondwindow = driver.getWindowHandles();
		System.out.println("how many windows open" +secondwindow.size());
		//convert set into list
		List<String> lstwindow=new ArrayList<String>(secondwindow);
		//move the control into the second window
		driver.switchTo().window(lstwindow.get(1));
		System.out.println(driver.getWindowHandle());
		System.out.println(driver.getTitle());
		//control back to the window
		driver.switchTo().window(lstwindow.get(0));
		System.out.println(driver.getTitle());
		//handling multiple window
		driver.findElement(By.xpath("//span[text()='Open Multiple']")).click();
		Set<String> multiple = driver.getWindowHandles();
		System.out.println(multiple.size());
		List<String>lstmultiple=new ArrayList<String>(multiple);
		driver.switchTo().window(lstmultiple.get(2));
		System.out.println(driver.getWindowHandle());
		System.out.println(driver.getTitle());
		//control back to the window
		driver.switchTo().window(lstmultiple.get(0));
		System.out.println(driver.getTitle());		
		//close window
		driver.findElement(By.xpath("//span[text()='Close Windows']")).click();
		Set<String> closewin = driver.getWindowHandles();
		System.out.println(closewin.size());
		List<String> lstclose=new ArrayList<String>(closewin);
		driver.switchTo().window(lstclose.get(3));
		System.out.println(driver.getWindowHandle());
		System.out.println(driver.getTitle());
		////control back to the window
		driver.switchTo().window(lstclose.get(0));
		System.out.println(driver.getWindowHandle());
		System.out.println(driver.getTitle());
		//open with delay
		driver.findElement(By.xpath("//span[text()='Open with delay']")).click();
		
		
		
		//current window
		//driver.close();
		
		
		
	}

}
