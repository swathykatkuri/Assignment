package PageObject;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	
		public HomePage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}

		@FindBy(xpath = "//*[@data-qaid='lnk-browseByMake']")
		private WebElement lnk_browseByMake;

		@FindBy(xpath = "//*[@data-qaid='lnk_browseByStyle']")
		private WebElement lnk_browseByStyle;

		@FindBy(xpath = "//*[@data-qaid='adv_srch']")
		private WebElement adv_srch;

		@FindBy(id="search")
		private WebElement btn_search;
		
		@FindBy(name = "makeCode")
		private WebElement drp_makeCode;
		
		@FindBy(name = "ModelCode")
		private WebElement drp_modelCode;
		
		
		public void click_AdvanceSearch_link() {
			adv_srch.click();
		}	
		
		public void Verify_link()
		{
			Assert.assertTrue("Verifying the Browse By Make",lnk_browseByMake.isDisplayed());
			Assert.assertTrue("Verifying the Browse By Style",lnk_browseByStyle.isDisplayed());
			Assert.assertTrue("Verifying the Advance Search",adv_srch.isDisplayed());
			Assert.assertTrue("Verifying the Search",btn_search.isDisplayed());
			Assert.assertTrue("Verifying the Dropdown Presents",drp_makeCode.isDisplayed());
			Assert.assertTrue("Verifying the Dropdown Presents",drp_makeCode.isDisplayed());
		}
		
}
