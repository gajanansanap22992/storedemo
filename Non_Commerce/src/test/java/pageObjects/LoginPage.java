package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;
	public  LoginPage(WebDriver driver)
	 {
		this.driver=driver;
		PageFactory.initElements(driver, this);		
	 }
	
	
	@FindBy(xpath="//input[@id='Email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='Password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@value='Log in']")
	WebElement loginButton;
	
	@FindBy(xpath="//a[@href='/logout']")
	WebElement logoutButton;
	
	public void enterEmailandpassword(String email,String password) throws InterruptedException
	{  Thread.sleep(2000);
		txtEmail.sendKeys(email);
		Thread.sleep(2000);
		txtPassword.sendKeys(password);
	}
	
	public void clickOnLoginButton() throws InterruptedException
	{Thread.sleep(2000);
		loginButton.click();
	}

	public void clickOnLogoutButton() throws InterruptedException
	{Thread.sleep(2000);
		logoutButton.click();
	}
}
