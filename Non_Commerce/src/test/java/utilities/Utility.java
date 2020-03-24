package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.lang.RandomStringUtils;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {
	public static void myWait(WebDriver driver,WebElement element)
	{	new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(element));
        
	}
	public static void jsClick(WebDriver driver,WebElement element)
	{
		JavascriptExecutor jp=(JavascriptExecutor)driver;		
		jp.executeScript("arguments[0].click();",element);
	}
			
	public static ArrayList<Employee> getData() throws IOException
	{
		File file=null;		
		file=new File(".//ExcelData.xlsx");		
		FileInputStream fis=new FileInputStream(file.getAbsolutePath());
		@SuppressWarnings("resource")
		XSSFWorkbook  wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheet("Sheet1");
		int lastRow=sheet.getLastRowNum();
		//int lastCol=sheet.getRow(0).getLastCellNum();
		ArrayList<Employee> al=new ArrayList<Employee>();
	    for(int i=1;i<=lastRow;i++)
		{
			XSSFRow currentRow=sheet.getRow(i);
			String emaill=currentRow.getCell(0).getStringCellValue().toString();
			String password=currentRow.getCell(1).getStringCellValue().toString();
			String fname=currentRow.getCell(2).getStringCellValue().toString();
			String lname=currentRow.getCell(3).getStringCellValue().toString();
			String gender=currentRow.getCell(4).getStringCellValue().toString();
			String db=currentRow.getCell(5).getStringCellValue().toString();
			String companyname=currentRow.getCell(6).getStringCellValue().toString();
			String taxexempt=currentRow.getCell(7).getStringCellValue().toString();
			String newsletter=currentRow.getCell(8).getStringCellValue().toString();
			String customerrole=currentRow.getCell(9).getStringCellValue().toString();
			String manager=currentRow.getCell(10).getStringCellValue().toString();			
			String active=currentRow.getCell(11).getStringCellValue().toString();			
			String admincomment=currentRow.getCell(12).getStringCellValue().toString();
			String str=db.replaceAll("s","/");
			String dob=String.valueOf(str);
			String email=RandomStringUtils.randomAlphabetic(11)+"@gmail.com";
			al.add(new Employee(email, password, fname, lname, gender, dob, companyname, taxexempt, newsletter, customerrole, manager, active, admincomment));
						
	      }
	    return al;
	}
	}
	

