package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase 
{
public  WebDriver driver;


public  WebDriver getDriver() throws IOException
{
	Properties prop=new Properties();
    FileInputStream fis=new FileInputStream( "C:\\Users\\MAYUR\\git\\Demo\\Non_Commerce\\src\\test\\java\\utilities\\Config_Property.properties");
    prop.load(fis);
    String browser= prop.getProperty("browser");
    if(browser.equalsIgnoreCase("chrome")) 
    {
    String path=prop.getProperty("cpath");
	System.setProperty("webdriver.chrome.driver", path);
	driver=new ChromeDriver();
	}
    else  if(browser.equalsIgnoreCase("firefox"))
    {
    	String path=prop.getProperty("fpath");
    	System.setProperty("webdriver.gecko.driver", path);
    	driver=new FirefoxDriver();
    	
    }
    return driver;
}


}
