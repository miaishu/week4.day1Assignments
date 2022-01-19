package week4.day1Assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNow {
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://dev113523.service-now.com/	");
		driver.manage().window().maximize();
		WebElement frame = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(frame);
		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin",Keys.TAB);
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("Ishu1990");
		driver.findElement(By.id("sysverb_login")).click();
		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys("incident");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@id='b55b4ab0c0a80009007a9c0f03fb4da9']")).click();
		WebElement frame2 = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(frame2);
		driver.findElement(By.xpath("//button[text()='New']")).click();
				driver.findElement(By.xpath("//button[@id='lookup.incident.caller_id']")).click();
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String>windows1=new ArrayList<String>(windowHandles1);
		driver.switchTo().window(windows1.get(1));
		driver.findElement(By.xpath("//a[text()='Creator User']")).click();
		driver.switchTo().window(windows1.get(0));
		WebElement frame4 = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(frame4);	
		driver.findElement(By.xpath("//input[@id='incident.short_description']")).sendKeys("Good");
		WebElement element = driver.findElement(By.xpath("//input[@id='incident.number']"));
		String attribute = element.getAttribute("value");
		System.out.println(attribute);
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		//driver.close();
		//WebElement frame5 = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		//driver.switchTo().frame(frame5);
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(attribute,Keys.ENTER);
		String incidentcreate = driver.findElement(By.xpath("//tbody[@class='list2_body']/tr/td[3]")).getText();
		
		if(attribute.equals(incidentcreate)) 
		System.out.println("Sucessful "+ incidentcreate);
		else System.out.println("Not Successful");
		File screenshot= driver.getScreenshotAs(OutputType.FILE);
		File destination= new File("./images/Homescreen.png");
		FileUtils.copyFile(screenshot, destination);
		driver.close();
		
		
	
	}
	

}
