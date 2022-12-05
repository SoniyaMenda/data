package StepDefiniton;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Loginsteps {
	WebDriver driver=null;

	@Given("open the browser")
	public void open_the_browser()
	{
		System.setProperty("webdriver.chrome.driver", "C://Users//smenda1//Downloads//chromedriver_win32 (1)//chromedriver.exe");
		 driver=new ChromeDriver();
		driver.get("https://www.telerik.com");
		driver.manage().window().maximize();

	}

	@When("user enter the url  {string}")
	public void user_enter_the_url(String string)
	{
		System.out.println("user enter the url");
	  
	}

	@When("Check the logo on header page")
	public void check_the_logo_on_header_page()
	{
		WebElement logo=driver.findElement(By.xpath("(//*[name()='svg'])[1]"));
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].style.border='2px solid red'",logo);
	}
	
	@When("Check All Products on header")
	public void check_all_products_on_header() throws InterruptedException 
	{
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.className("TK-Products-Menu-Item-Button"))).build().perform();
		Thread.sleep(5000);

	}
    @Then("open All Products")
	public void open_all_products() 
	{
	System.out.print("open All Products");    
	}
	
	@When("click on SERVICES button")
	public void click_on_services_button()
	{	 
		driver.findElement(By.xpath("//a[normalize-space()='Services']")).click();
	}

	@Then("click on BLOGS button")
	public void click_on_blogs_button() 
	{
		driver.findElement(By.xpath("//a[@class='TK-Menu-Item-Link'][normalize-space()='Blogs']")).click();
	}

	@When("click on DOCS & SUPPORT button")
	public void click_on_docs_support_button() 
	{
	 driver.findElement(By.xpath("//a[normalize-space()='Docs & Support']")).click();
	}

	@Then("click on PRICING")
	public void click_on_pricing() 
	{
	driver.findElement(By.xpath("//a[@class='TK-Menu-Item-Link'][normalize-space()='Pricing']")).click(); 
	}

	@When("click on Search icon")
	public void click_on_search_icon() 
	{
	   driver.findElement(By.xpath("//a[@id='js-tlrk-nav-search-link']//*[name()='svg']")).click();
	}

	@Then("click on Your Account")
	public void click_on_your_account() 
	{
 driver.findElement(By.xpath("//a[@title='Your Account']")).click();
 driver.navigate().back();

	}
	@When("click on GET A FREE TRIAL button")
	public void click_on_get_a_free_trial_button() throws InterruptedException
	{
	    driver.findElement(By.xpath("//a[normalize-space()='Get A Free Trial']")).click();
	    Thread.sleep(5000);
	}
@After
public void closeBrowser()
{
	driver.quit();
}
}
