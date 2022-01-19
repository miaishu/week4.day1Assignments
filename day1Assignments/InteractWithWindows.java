package week4.day1Assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InteractWithWindows {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Window.html");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[text()='Open Home Page']")).click();
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String>windows= new ArrayList<String>(windowHandles1);
		WebDriver webpage1 = driver.switchTo().window(windows.get(1));
		System.out.println(webpage1.getTitle());
		driver.switchTo().window(windows.get(0));
		driver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();
		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String> windows1= new ArrayList<String>(windowHandles2);
		WebDriver webpage2 = driver.switchTo().window(windows1.get(2));
		System.out.println(webpage2.getTitle());
		WebDriver webpage3 = driver.switchTo().window(windows1.get(1));
		System.out.println(webpage3.getTitle());
		driver.switchTo().window(windows1.get(0));
		driver.findElement(By.xpath("//button[text()='Do not close me ']")).click();
		Set<String> windowHandles3 = driver.getWindowHandles();
		List<String> windows2= new ArrayList<String>(windowHandles3);
		WebDriver webpage4 = driver.switchTo().window(windows2.get(2));
		System.out.println(webpage4.getTitle());
		driver.close();
		
		WebDriver webpage5= driver.switchTo().window(windows2.get(1));
		System.out.println(webpage5.getTitle());
		driver.close();
		driver.switchTo().window(windows2.get(0));
		driver.findElement(By.xpath("//button[text()='Wait for 5 seconds']")).click();
		Thread.sleep(5000);
		Set<String> windowHandles4 = driver.getWindowHandles();
		List<String> windows3=new ArrayList<String>(windowHandles4);
		WebDriver webpage6 = driver.switchTo().window(windows3.get(2));
		System.out.println(webpage6.getTitle());
		driver.close();
		WebDriver webpage7 = driver.switchTo().window(windows3.get(1));
		System.out.println(webpage7.getTitle());
		driver.close();
		driver.switchTo().window(windows3.get(0));
		
		
		
		
		
		
		
		
	}
	

}
