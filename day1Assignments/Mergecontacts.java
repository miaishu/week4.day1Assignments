package week4.day1Assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Mergecontacts {
        public static void main(String[] args) throws InterruptedException {
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver= new ChromeDriver();
			driver.get("http://leaftaps.com/opentaps/control/login");
			driver.manage().window().maximize();
			driver.findElement(By.id("username")).sendKeys("demosalesmanager");
			driver.findElement(By.id("password")).sendKeys("crmsfa");
			driver.findElement(By.className("decorativeSubmit")).click();
			driver.findElement(By.linkText("CRM/SFA")).click();
			//go to contacts
			driver.findElement(By.xpath("//a[text()='Contacts']")).click();
			//go to mergecontacts
			driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
			driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
			driver.manage().window().maximize();
			//to move new window
			Set<String> windowHandles = driver.getWindowHandles();
			List<String> windows= new ArrayList<String>(windowHandles);
			//System.out.println(windows);
			driver.switchTo().window(windows.get(1));
			WebElement contactName = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]"));
			System.out.println(contactName.getText());
		    contactName.click();
		    driver.switchTo().window(windows.get(0));
			
			driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
			//driver.switchTo().window(windows.get(1));
			
			Set<String> windowHandles2 = driver.getWindowHandles();
			List<String> toContact= new ArrayList<String>(windowHandles2);
			driver.switchTo().window(toContact.get(1));
			Thread.sleep(2000);
			WebElement toContact1 = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]"));
			System.out.println(toContact1.getText());
			toContact1.click();
			driver.switchTo().window(windows.get(0));
			driver.findElement(By.xpath("//a[text()='Merge']")).click();
						
			driver.switchTo().alert().accept();
			System.out.println(driver.getTitle());
					
			
			
			
			
        	
        	
        	
		}
}
