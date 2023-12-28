package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {

	WebDriver driver;

	public Login(WebDriver driver) {
		this.driver = driver;
	}

	// Locators for UserName, Password & Login Button
	By uid = By.name("username");
	By pwd = By.name("password");
	By Loginbtn = By.xpath("//button[@type='submit']");

	// Method to enter UserName
	public void enterUsername(String user) {
		driver.findElement(uid).sendKeys(user);
	}

	// Method to enter Password
	public void enterPassword(String pass) {
		driver.findElement(pwd).sendKeys(pass);
	}

	// Method to click on Login button
	public void clickLogin() {
		driver.findElement(Loginbtn).click();
	}
}