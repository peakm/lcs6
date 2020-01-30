package gitcasestudy6;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class productcs6 {
	WebDriver driver;
	@When("user opens browser")
	public void user_opens_browser() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Training_c2a.04.30\\Desktop\\Sel-Drivers\\chromedriver.exe");
		  driver=new ChromeDriver();
		  driver.manage().window().maximize();
	}

	@When("user launches application")
	public void user_launches_application() {
		driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
	}

	@When("user clicks on signin button")
	public void user_clicks_on_signin_button() {
		driver.findElement(By.linkText("SignIn")).click();
	}

	@When("user enters username in username field")
	public void user_enters_username_in_username_field() {
		driver.findElement(By.name("userName")).sendKeys("lalitha");
	}

	@When("user enters password in password field")
	public void user_enters_password_in_password_field() {
		driver.findElement(By.name("password")).sendKeys("Password123");
	}

	@When("user clicks login button")
	public void user_clicks_login_button() {
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	}

	@When("user search for products in search engine")
	public void user_search_for_products_in_search_engine() {
		driver.findElement(By.name("products")).sendKeys("Headphone");
	}

	@When("user clicks on find products")
	public void user_clicks_on_find_products() {
		driver.findElement(By.xpath("//input[@value='FIND DETAILS']")).click();
	}

	@Then("user validates the product")
	public void user_validates_the_product() {
		//add to cart
		driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div/div/div/div[2]/center/a")).click();
		//cart
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/a[2]")).click();
		String s=driver.findElement(By.xpath("//*[@id=\"cart\"]/tbody/tr/td[1]/div/div/h4")).getText();
		Assert.assertEquals(s, "Headphone");
	}
}


