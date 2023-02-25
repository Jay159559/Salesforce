package vanilla_script;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S09_16_Edit_Dashboard {

	public static void main(String[] args) throws InterruptedException {

// Browser Setup
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("-disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		
//Login Salesforce
		
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		
		driver.findElement(By.id("username")).sendKeys("jay159559@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Welcome@123");
		driver.findElement(By.id("Login")).click();
		System.out.println("Salesforce application has been logged in with username and password");
		
//Click on ViewAll		 
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		System.out.println("ViewAll / Display All has been clicked in the Toggle Menu ");
//Search for Dashboard			
		 WebElement searchElement = driver.findElement(By.xpath("//input[@class='slds-input']"));
		 searchElement.click();
		 searchElement.sendKeys("Dashboard");
		 Thread.sleep(3000);
		 System.out.println("Dashboard has been enter in the Search ");
//Click on Dashboard
		WebElement findDashboard = driver.findElement(By.xpath("//mark[text()='Dashboard']"));
		driver.executeScript("arguments[0].click();", findDashboard);
		Thread.sleep(2000);
		System.out.println("Clicked on the Dashboard");
		
// Select DashBoard
		WebElement selectDashboard = driver.findElement(By.xpath("//div[@class='slds-hyphenate']//a"));
		driver.executeScript("arguments[0].click();", selectDashboard);
		System.out.println("Selected the first Row from the search");
		Thread.sleep(3000);
		
// Edit Dashboard
		WebElement frameEditDashboard =  driver.findElement(By.xpath("//iframe[@title='dashboard']"));
		driver.executeScript("arguments[0].click();",frameEditDashboard );
		frameEditDashboard.click();
		driver.switchTo().frame(frameEditDashboard);
		
		WebElement editDashboard = driver.findElement(By.xpath("//button[text()='Edit']"));
		driver.executeScript("arguments[0].click();", editDashboard);
		System.out.println("Edit the first Row from the search");
		
// Change Name of the Dashboard
		WebElement editNameIcon = driver.findElement(By.xpath("//button[contains(@class,'slds-button slds-button_icon')]"));
		driver.executeScript("arguments[0].click();", editNameIcon);
		System.out.println("Edit Icon of the Dashboard has been clicked");
		
		WebElement changeNameDashboard = driver.findElement(By.id("edit-dashboard-title"));
		driver.executeScript("arguments[0].click();", changeNameDashboard);
		changeNameDashboard.sendKeys("Salesforce");
		System.out.println("Edited the Dashboard Name");
		
// Save the Edited Dashboard
		
		WebElement SaveDashboard = driver.findElement(By.xpath("//button[text()='Save']"));
		driver.executeScript("arguments[0].click();", SaveDashboard);
		System.out.println("Dashboard has been Saved");
		
// Click on Done
		WebElement doneClick = driver.findElement(By.xpath("//button[@class='slds-button doneEditing']"));
		driver.executeScript("arguments[0].click();", doneClick);
		System.out.println("Done has been clicked");
		
	}

}
