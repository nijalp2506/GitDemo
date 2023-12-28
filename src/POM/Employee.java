package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Employee {

	WebDriver driver;

	public Employee(WebDriver driver) {
		this.driver = driver;
	}

	//Locators for Add Employee
	By PIM = By.xpath("//span[text()='PIM']");
	By AddEmp = By.xpath("//button[text()=' Add ']");
	By FName = By.name("firstName");
	By MName = By.name("middleName");
	By LName = By.name("lastName");
	By ECode = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
	By SaveEmp = By.xpath("//button[text()=' Save ']");
	
	//Locators for Delete Employee
	By SearchEmp = By.xpath("//input[@placeholder='Type for hints...']");
	By Searchbtn = By.xpath("//button[text()=' Search ']");
	By DelEmp = By.xpath("//i[@class='oxd-icon bi-trash']");
	By DelConfirm = By.xpath("//button[text()=' Yes, Delete ']");
	
	//Method To Add Employee
	

}
