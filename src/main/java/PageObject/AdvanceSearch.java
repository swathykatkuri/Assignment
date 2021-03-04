package PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.listener.Reporter;

import junit.framework.Assert;
import utility.Utility;

public class AdvanceSearch 
{
	public AdvanceSearch(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="zip")
	private WebElement txt_zip;

	@FindBy(xpath = "//div[text()='Certified']")
	private WebElement chkbx_certified;

	@FindBy(xpath = "//div[text()='Convertible']")
	private WebElement chkbx_Convertible;

	@FindBy(name="startYear")
	private WebElement drp_From;
	
	@FindBy(name = "endYear")
	private WebElement drp_To;
	
	@FindBy(name="makeFilter0")
	private WebElement drp_makeFliter;
	
	@FindBy(xpath="//*[@data-qaid='btn-search']")
	private WebElement btn_search;
	
	@FindBy(xpath="//span[text()='Your Search']//following-sibling::span']")
	private  WebElement lbl_searchResult;
	
	@FindBy(xpath="//*[@data-cmp='subheading']")
	private List<WebElement> lst_heading;
	
	public void searchcar(String zipcode,String makeName)
	{
		Reporter.addStepLog("Entered the Zipcode");
		txt_zip.sendKeys(zipcode);
		Reporter.addStepLog("Clicked on the certified checkbox");
		chkbx_certified.click();
		Reporter.addStepLog("Clicked on the Convertible checkbox");
		chkbx_Convertible.click();
		Reporter.addStepLog("Selecting start from date");
		Utility.selectbyText(drp_From, "2017");
		Reporter.addStepLog("Selecting end To date");
		Utility.selectbyText(drp_To, "2020");
		Reporter.addStepLog("Selecting Maker Fliter");
		Utility.selectbyText(drp_makeFliter, makeName);
		Reporter.addStepLog("Clicked on the search button");
		btn_search.click();
	}
	
	public String countofResult()
	{
		System.out.println(lbl_searchResult.getText());
		return lbl_searchResult.getText();
	}
	
	
	public void verfiyingHeading()
	{
		for(WebElement element : lst_heading)
		{
			if(element.getText().toLowerCase().contains("BMW"))
			{
				System.out.println(element.getText());
			}else
			{
				System.out.println("Other car is Dispalyed");
			}
		}
	}
	
}
