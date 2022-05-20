package VariousConcepts4;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


import static org.junit.Assert.assertTrue;
public class learnMouseOver {
	
	WebDriver driver;

	@Before
	public void init() {

		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://www.dell.com/en-us");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	}

	@SuppressWarnings("deprecation")
	@Test
	public void mouseOverTest() throws InterruptedException {
		By DealsMouseOver = By.xpath("//span[contains(text(),'Deals')]");
		By DeskTopMouseOver = By.xpath("//a[contains(text(),'Desktop Deals')]");
		By ForHomeMouseOver = By.xpath("//a[contains(text(),'Desktop Deals')]/following-sibling::ul/child::li[3]/child::a");
		By ForHomePage = By.xpath("//h1[contains(text(),'Desktop Computer Deals')]");
		
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(DealsMouseOver)).build().perform();
		action.moveToElement(driver.findElement(DeskTopMouseOver)).build().perform();
		driver.findElement(ForHomeMouseOver).click();
		
		Thread.sleep(2000);
	   Assert.assertTrue("Wrong Page!!",driver.findElement(ForHomePage).isDisplayed());
	}

}
