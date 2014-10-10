package test.java;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CI_Starter_Test {
	// create a WebDriver
	WebDriver driver;

	// use the Firefox browser and go to the wikipedia site
	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		driver.get("http://www.google.com");
	}

	@Test
	public void googleSearchTest() throws Exception {

		// wait for 5 seconds
		Thread.sleep(5000);		
		WebElement about = driver.findElement(By
				.xpath("/html/body/div[1]/div[2]/div[1]/div[1]/div[3]/div/div/div/form/fieldset[2]/div/div/div/div/div[3]/div/input[1]"));

		// click to the link
		about.sendKeys("Testing");
		// wait for 5 seconds
		Thread.sleep(5000);
	
		// find the submit button
		WebElement search = driver.findElement(By.id("gbqfb"));
		
		// click to the button
		search.click();
		// wait for 5 seconds
		Thread.sleep(5000);
		
		WebElement link = driver.findElement(By.linkText("Black-box testing - Wikipedia, the free encyclopedia"));
		// write out the title of the page in console
		System.out.println(driver.getTitle());
		
		Assert.assertFalse(link==null);		

		
	}
	
	// quit from WebDriver
	@After
	public void tearDown() {
		driver.quit();
	}

}
