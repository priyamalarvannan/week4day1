package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {
	public static void main(String[] args) throws InterruptedException {
		
				
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();
		Set<String> merge1 = driver.getWindowHandles();
		System.out.println(merge1.size());
		List<String> lstwindow=new ArrayList<String>(merge1);
		driver.switchTo().window(lstwindow.get(1));
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])/a")).click();
		driver.switchTo().window(lstwindow.get(0));
		driver.findElement(By.xpath("(//img[@ alt='Lookup'])[2]")).click();
		Set<String> merge2 = driver.getWindowHandles();
		List<String> lstwindow1=new ArrayList<String>(merge2);
		driver.switchTo().window(lstwindow1.get(1));
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]")).click();
		driver.switchTo().window(lstwindow1.get(0));
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		Alert alt = driver.switchTo().alert();
		alt.accept();
		Thread.sleep(2000);
		String verify = driver.getTitle();
		if(verify.contains("View Contact"))
		{
			System.out.println("file merged"+verify);
		}
		else
		{
			System.out.println("not merged");
		}
}
	}
