package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckTest {
	@FindBy(xpath="//input[@id='Email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='Password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@value='Log in']")
	WebElement loginButton;


	CheckTest(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
		
		

	}

}
