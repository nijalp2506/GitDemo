package User;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import POM.Login;

public class UserManagement {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"D:\\Personal\\Learn QA\\Tools\\Browsers\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		// Creating object of Login page
		Login loginpg = new Login(driver);

		// Enter Id & Password
		loginpg.enterUsername("Admin");
		loginpg.enterPassword("admin123");

		// Click on Login
		loginpg.clickLogin();

		Assert.assertEquals("Dashboard", driver.findElement(By.className("oxd-topbar-header-breadcrumb")).getText());
		System.out.println("User Successfully Logged In.");
		
		//PIM->Add Employee
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		driver.findElement(By.xpath("//button[text()=' Add ']")).click();

		driver.findElement(By.name("firstName")).sendKeys("Nijal");
		driver.findElement(By.name("middleName")).sendKeys("S");
		driver.findElement(By.name("lastName")).sendKeys("Patel");

		driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).clear();
		driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys("671");

		driver.findElement(By.xpath("//button[text()=' Save ']")).click();
		System.out.println("Employee Added Successfully.");

		//Admin->Add User
		driver.findElement(By.xpath("//span[text()='Admin']")).click();
		driver.findElement(By.xpath("//button[text()=' Add ']")).click();

		driver.findElement(By.xpath("(//div[@class='oxd-select-text oxd-select-text--active'])[1]")).click();
		List<WebElement> allOptions1 = driver.findElements(By.xpath("//div[@role='listbox']"));
		for (int i = 0; i < allOptions1.size(); i++) {
			if (allOptions1.get(i).getText().contains("Admin")) {
				allOptions1.get(i).click();
			}
			break;

		}

		driver.findElement(By.xpath("//input[@placeholder='Type for hints...']")).sendKeys("Nijal");
		Thread.sleep(5000L);
		List<WebElement> allOptions2 = driver.findElements(By.xpath("//div[@role='listbox']"));
		for (int i = 0; i < allOptions2.size(); i++) {
			Thread.sleep(3000L);
			if (allOptions2.get(i).getText().contains("Nijal S Patel")) {
				Thread.sleep(3000L);
				allOptions2.get(i).click();
			}
			break;
		}

		driver.findElement(By.xpath("(//div[@class='oxd-select-text oxd-select-text--active'])[2]")).click();
		List<WebElement> allOptions3 = driver.findElements(By.xpath("//div[@role='listbox']"));
		for (int i = 0; i < allOptions3.size(); i++) {
			if (allOptions3.get(i).getText().contains("Enabled")) {
				allOptions3.get(i).click();
			}
			break;
		}

		Thread.sleep(2000L);
		driver.findElement(By.xpath(
				"//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[4]/div[1]/div[2]/input[1]"))
				.sendKeys("nijal123");
		driver.findElement(By.xpath("(//input[@type='password'])[1]")).sendKeys("Test@1234");
		driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys("Test@1234");

		driver.findElement(By.xpath("//button[text()=' Save ']")).click();
		System.out.println("User Added Successfully.");
		
		//PIM->Delete Employee
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Type for hints...']")).sendKeys("Nijal");
		driver.findElement(By.xpath("//button[text()=' Search ']")).click();
		driver.findElement(By.xpath("//i[@class='oxd-icon bi-trash']")).click();
		driver.findElement(By.xpath("//button[text()=' Yes, Delete ']")).click();
		System.out.println("Employee Deleted Successfully.");
		
		//Admin->Delete User
		driver.findElement(By.xpath("//span[text()='Admin']")).click();
		
		driver.findElement(By.xpath("//input[@placeholder='Type for hints...']")).sendKeys("Nijal");
		Thread.sleep(5000L);
		List<WebElement> allOptions4 = driver.findElements(By.xpath("//div[@role='listbox']"));
		for (int i = 0; i < allOptions4.size(); i++) {
			Thread.sleep(3000L);
			if (allOptions4.get(i).getText().contains("Nijal S Patel")) {
				Thread.sleep(3000L);
				allOptions4.get(i).click();
			}
			break;
		}
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//i[@class='oxd-icon bi-trash']")).click();
		driver.findElement(By.xpath("//button[text()=' Yes, Delete ']")).click();
		System.out.println("User Deleted Successfully.");
		
		driver.close();
		driver.quit();
	}
}