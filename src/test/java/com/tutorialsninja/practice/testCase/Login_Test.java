package com.tutorialsninja.practice.testCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialninja.testbase.TestBase;

public class Login_Test extends TestBase{
	public WebDriver driver;
	public Actions actions;
	public Select select;
	
	public Login_Test() {
		super();            //parent class constructor
	}
	
	@BeforeMethod
	public void setUp() {
		driver = openUrlinABrowser("chrome");
	}
	
	@Test(priority=1)
	public void Login_TN() throws InterruptedException {
		
		Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());	
	}	
	@Test(priority=2)
	public void clickOnLaptopsAndNotebook() {
		actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.linkText("Laptops & Notebooks"))).perform();
		actions.moveToElement(driver.findElement(By.linkText("Show AllLaptops & Notebooks"))).click().perform();
	}
	@Test(priority=3)
	public void clickOnHpLaptop() {
		actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.linkText("Laptops & Notebooks"))).perform();
		actions.moveToElement(driver.findElement(By.linkText("Show AllLaptops & Notebooks"))).click().perform();
        WebElement HPLapltop = driver.findElement(By.linkText("HP LP3065"));	
        if(HPLapltop.isDisplayed()) {
        	HPLapltop.click();
	}
        else {
        	System.out.println("HPLaptop is not displayed");
        }
	}
	@Test(priority=4)
	public void completeBuying()throws InterruptedException {
		actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.linkText("Laptops & Notebooks"))).perform();
		actions.moveToElement(driver.findElement(By.linkText("Show AllLaptops & Notebooks"))).click().perform();
        WebElement HPLapltop = driver.findElement(By.linkText("HP LP3065"));	
        if(HPLapltop.isDisplayed()) {
        	HPLapltop.click();
	}
        else {
        	System.out.println("HPLaptop is not displayed");
        }
        driver.findElement(By.id("input-option225")).sendKeys("2011-04-22");
        driver.findElement(By.id("button-cart")).click();
        
        driver.findElement(By.cssSelector("i.fa.fa-shopping-cart+span")).click();
        driver.findElement(By.xpath("//input[starts-with(@name,'quantity[')]")).clear();
        driver.findElement(By.xpath("//input[starts-with(@name,'quantity[')]")).sendKeys("1");
        driver.findElement(By.linkText("Checkout")).click();
        Thread.sleep(2000);
        
        driver.findElement(By.xpath("//input[@name='payment_address' and @value='new']")).click();
        
        driver.findElement(By.id("input-payment-firstname")).sendKeys("Shweta");
        driver.findElement(By.id("input-payment-lastname")).sendKeys("Panda");
        driver.findElement(By.id("input-payment-company")).sendKeys("Testing");
        driver.findElement(By.id("input-payment-address-1")).sendKeys("Linden driver");
        driver.findElement(By.id("input-payment-address-2")).sendKeys("56");
        driver.findElement(By.id("input-payment-city")).sendKeys("Toronto");
        driver.findElement(By.id("input-payment-postcode")).sendKeys("N4J5E4");
        select = new Select(driver.findElement(By.id("input-payment-country")));
        select.selectByVisibleText("Canada");
        Thread.sleep(3000);
        select = new Select(driver.findElement(By.id("input-payment-zone")));
        select.selectByVisibleText("Ontario");
        
        driver.findElement(By.id("button-payment-address")).click();
        Thread.sleep(2000);
        
        driver.findElement(By.id("button-shipping-address")).click();
        Thread.sleep(2000); 
        
        driver.findElement(By.name("comment")).sendKeys("Please pack laptop safely");
        driver.findElement(By.id("button-shipping-method")).click();
        Thread.sleep(2000); 
       
        driver.findElement(By.xpath("//input[@name='agree']")).click();
        Thread.sleep(2000);
        
        driver.findElement(By.id("button-payment-method")).click();       
        Thread.sleep(2000);
        
        driver.findElement(By.id("button-confirm")).click();
        Thread.sleep(2000);
        
        Assert.assertTrue(driver.findElement(By.xpath("//p[text()='Your order has been successfully processed!']")).isDisplayed());
        driver.findElement(By.linkText("Continue")).click();
       
        
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}
	

}
