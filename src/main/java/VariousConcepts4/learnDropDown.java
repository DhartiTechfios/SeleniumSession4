package VariousConcepts4;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

//import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class learnDropDown {

	WebDriver driver;

	@Before
	public void init() {

		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://techfios.com/billing/?ng=dashboard/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void loginTest() {
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("demo@techfios.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("abc123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		By Dash_Board_Header_Field = By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/h2");
		//below line 39,40,41 all three ways to assert page. displayed,gettext and get title.
		//Assert.assertTrue("Wrongpage!!", driver.findElement(Dash_Board_Header_Field).isDisplayed());
		// Assert.assertEquals("Wrong Page!!","Dashboard",driver.findElement(Dash_Board_Header_Field).getText());
		 Assert.assertEquals("Wrong Page!!","Dashboard- iBilling",driver.getTitle());
		 System.out.println(driver.getTitle());
		 
		driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[3]/a/span[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[3]/ul/li[1]/a")).click();
		
		By Company_Field = By.xpath("//select[@id='cid']");
		Select sel = new Select(driver.findElement(Company_Field));
		sel.selectByVisibleText("Amazon");
		sel.getOptions();
		List<WebElement> allOptions = sel.getOptions();
		int i = 1;	
		for(WebElement e:allOptions) {
			System.out.println(i+""+e.getText());
			i++;
		}
		
		
		/*By Country_Field = By.xpath("//select[@id='country']");
		Select sel1 = new Select(driver.findElement(Country_Field));
		sel1.selectByVisibleText("India");*/
	
	
	}
}
