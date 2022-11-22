package week4.day1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnAlert 
{
	private static String text2;

	public static void main(String[] args) throws InterruptedException
	{
		
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	
	driver.get("https://leafground.com/alert.xhtml");
	driver.findElement(By.xpath("//*[@id=\"j_idt88:j_idt91\"]")).click();
	Alert sa = driver.switchTo().alert();
	String text = sa.getText();
	System.out.println("simple alert"+text);
	sa.accept();
	//confirm alert
	driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[2]")).click();
	Alert ca = driver.switchTo().alert();
	String text3 = ca.getText();
	System.out.println(text3);
	ca.dismiss();
	//prompt alert
	
	driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[6]")).click();
	Alert pa = driver.switchTo().alert();
	pa.sendKeys("Testleaf");
	Thread.sleep(3000);
	 String text2 = pa.getText();
	 System.out.println("Prompt msg"+text2);
	 pa.accept();
	//print the result of text entered 
		String promsg = driver.findElement(By.xpath("//span[@id='confirm_result']")).getText();
		System.out.println(promsg);
	 	 //sweet alert
	 driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[3]")).click();
	 driver.findElement(By.xpath("//span[text()='Dismiss']")).click();
	//sweet model dialog
	 driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[5]")).click();
	 driver.findElement(By.xpath("(//span[@class='ui-icon ui-icon-closethick'])[2]")).click();
	 
	//sweet alert
	driver.findElement(By.xpath("//span[text()='Delete']")).click();
		//click yes
		driver.findElement(By.xpath("//span[text()='Yes']")).click();
		Thread.sleep(5000);
		//click max and min
		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[8]")).click();
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-minus']")).click();
		driver.findElement(By.xpath("(//a[@role='button'])[4]")).click();
		 driver.findElement(By.xpath("(//a[@role='button'])[3]")).click();
		
		
	}	
	
}

