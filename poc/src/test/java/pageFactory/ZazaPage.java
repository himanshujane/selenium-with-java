package pageFactory;


import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ZazaPage {

	@FindBy(xpath="//header//a[@href='/create-bag']") 
	public WebElement buttonCreateBag;
	
	@FindBy(xpath="//app-bag[last()]//ion-menu-button")
	public WebElement buttonLeftMenu;
    
	@FindBy(xpath="//ion-label[text()='Delete this bag']")
	public WebElement buttonDeleteBag;
    
	@FindBy(xpath="//ion-button[contains(text(),'delete')]")
	public WebElement buttonDeleteConfirm;
	
	public ZazaPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
