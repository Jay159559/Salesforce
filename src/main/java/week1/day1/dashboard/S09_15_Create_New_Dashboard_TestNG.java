package week1.day1.dashboard;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S09_15_Create_New_Dashboard_TestNG {
public static RemoteWebDriver driver;
@Parameters({"username", "password"})
@BeforeTest	
//Browser Setup
public static void LaunchBrowswer(String username, String password) {
//Browser SetUp
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("-disable-notifications");
		 driver = new ChromeDriver(options);
//URL Navigate
		 driver.get("https://login.salesforce.com");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));

//Login Salesforce			
		 driver.findElement(By.id("username")).sendKeys(username);
		 driver.findElement(By.id("password")).sendKeys(password);
		 driver.findElement(By.id("Login")).click();
		 System.out.println("Salesforce application has been logged in with username and password");
}

@Test	
public static void NewDashboard() throws InterruptedException {
	
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
			
	//Click on New Dashboard
			WebElement newDashboard= driver.findElement(By.xpath("//div[text()='New Dashboard']"));
			driver.executeScript("arguments[0].click();",newDashboard );
			System.out.println("Clicked on the New Dashboard");

	//Enter Name and Create
			WebElement frameDashboard =  driver.findElement(By.xpath("//iframe[@title='dashboard']"));
			driver.executeScript("arguments[0].click();",frameDashboard );
			frameDashboard.click();
			driver.switchTo().frame(frameDashboard);
			//driver.switchTo().frame("sfxdash-1676892856466-395157");
			//driver.switchTo().frame(3);
			WebElement dashboardNameInput = driver.findElement(By.xpath("//input[@id='dashboardNameInput']"));
			driver.executeScript("arguments[0].click();",dashboardNameInput);
			
			dashboardNameInput.click();
			//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			//wait.until(ExpectedConditions.visibilityOf(dashboardNameInput));
			
			dashboardNameInput.sendKeys("Vijay");
			
			//driver.findElement(By.id("dashboardNameInput")).sendKeys("Vijay");
			driver.findElement(By.id("submitBtn")).click();
			System.out.println("Entered Name and Clicked on Create Button");
	//Save Dashboard	
			driver.findElement(By.xpath("//button[text()='Save']")).click();
			System.out.println("Save button has been clicked");

		
		

	}



@AfterMethod
public void closeBrowser() {
	driver.close();
	System.out.println("Browser has been closed using driver.close()");
	
}

}
