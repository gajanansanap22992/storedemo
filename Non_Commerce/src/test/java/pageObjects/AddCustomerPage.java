package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.Utility;

public class AddCustomerPage {
	public WebDriver driver;
	public AddCustomerPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[@href='#']//span[contains(text(),'Customers')]")
	WebElement CustomersMenu;
	@FindBy(xpath="//a[@href='/Admin/Customer/List']//span[ @class='menu-item-title' and contains(text(),'Customers')]")
	WebElement CustomerMenuItem;
	@FindBy(xpath="//a[@class='btn bg-blue']")
	WebElement buttonAddNew;
	@FindBy(xpath="//span[contains(text(),'Customer info')]")
	WebElement customerInfo;
	
	@FindBy(xpath="//input[@id='Email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//button[@name='save']")
	WebElement buttonSave;
	@FindBy(xpath="//input[@id='IsTaxExempt']")
	WebElement isTaxExempt;
	@FindBy(xpath="//input[@id='Password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@id='FirstName']")
	WebElement txtFirstName;
	
	@FindBy(xpath="//input[@id='LastName']")
	WebElement txtLastName;
	
	@FindBy(xpath="//input[@id='Gender_Male']")
	WebElement selectMale ;
	@FindBy(xpath="//input[@id='Active']")
	WebElement selActive;
	@FindBy(xpath="//input[@id='Gender_Female']")
	WebElement selectFemale  ;
	
	@FindBy(xpath="//input[@id='DateOfBirth']")
	WebElement txtDateOfBirth;
	
	@FindBy(xpath="//input[@id='Company']")
	WebElement txtCompany;
	
	@FindBy(xpath="//input[@name='SelectedNewsletterSubscriptionStoreIds' and @value='1']")
	WebElement selectNewsLetter;
	
	@FindBy(xpath="//div[@class='k-multiselect-wrap k-floatwrap']//input")
	WebElement  selectcustomerRole;
	
	@FindBy(xpath="//select[@id='VendorId']")
	WebElement SelectManagerVendor;
	
	@FindBy(xpath="//textarea[@id='AdminComment']")
	WebElement txtAdminComment;
	public void selectCustomerRole(String role) throws InterruptedException
	{  
		WebElement element=driver.findElement(By.xpath("//*[@id='SelectedCustomerRoleIds_listbox']/li[3]"));
	
		if(role.equals("Administrators"))
		{
	      element=driver.findElement(By.xpath("//*[@id='SelectedCustomerRoleIds_listbox']/li[1]"));
	    }
		else if(role.equals("Guests"))
		{
	     element=driver.findElement(By.xpath("//*[@id='SelectedCustomerRoleIds_listbox']/li[3]"));
		}
		else if(role.equals("Registered"))
		{
	      element=driver.findElement(By.xpath("//*[@id='SelectedCustomerRoleIds_listbox']/li[4]"));
		}
		else if(role.equals("Forum Moderators"))
		{
	     element=driver.findElement(By.xpath("//*[@id='SelectedCustomerRoleIds_listbox']/li[2]"));
		}
		else if(role.equals("Vendors"))
		{
	      element =driver.findElement(By.xpath("//*[@id='SelectedCustomerRoleIds_listbox']/li[5]"));
		}
		//Utility.myWait(driver, element);
        Utility.jsClick(driver,element);		
	}
	
	
	public void enterEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	public void enterpassword(String pass)
	{
		txtPassword.sendKeys(pass);
	}
	public void enterFirstname(String fname)
	{
		txtFirstName.sendKeys(fname);
	}
	public void enterLastname(String lname)
	{
		txtLastName.sendKeys(lname);
	}
	public void selectGender(String gender)
	{
		if(gender.equalsIgnoreCase("Female"))
		{
			selectFemale.click();
		}
		else
		{
			selectMale.click();
		}
	}
	public void enterDateofBirth(String dob)
	{
		txtDateOfBirth.sendKeys(dob);
	}
	public void enterCompanyName(String companyname)
	{
		txtCompany.sendKeys(companyname);
	}
	public void select_taxExempt_Newsletter(String s1 ,String s2)
	{
		if(s1.contains("yes"))
		{
		isTaxExempt.click();
		selectNewsLetter.click();
		}
		else
		{
			selectNewsLetter.click();
		}
	}
	public void selectManagerOfVendor(String mng)
	{

   Select sel=new Select(SelectManagerVendor);
   sel.selectByVisibleText(mng);
	}
	public void SelectActive(String sel)
	{
		if(sel.contains("no"))
		{
		selActive.click();}
	}
	public void clickOnAddnewButton()
	{
		buttonAddNew.click();
	}
	public void clickOnSaveButton()
	{
		buttonSave.click();
	}
	public void enterAdminComment(String comment)
	{
		txtAdminComment.sendKeys(comment);
	}
	public void clickOnCustomer()
	{
		CustomersMenu.click();
	}
	public void clickOnCustomerMenuItem()
	{
		CustomerMenuItem.click();
	}
}
