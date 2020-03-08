package specs;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.testng.annotations.Test;
import genericLib.commonLib;
import pageFactory.ZazaPage;
import com.relevantcodes.extentreports.LogStatus;

public class zazatest1 extends commonLib {

	@Test(dataProvider = "dp", dataProviderClass = dataProvider.dp.class)
	public void prod_deleteBag(Map<String, String> hm) throws InterruptedException {

		ZazaPage zaza = new ZazaPage(driver);
		startTest = ereports.startTest(hm.get("TC_ID"), hm.get("scriptName"));
		Dimension d = new Dimension(300, 1080);
		// Resize current window to the set dimension
		driver.manage().window().setSize(d);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get(hm.get("URL"));
		Thread.sleep(2000);
		click(zaza.buttonLeftMenu);
		Thread.sleep(2000);
		click(zaza.buttonDeleteBag);
		Thread.sleep(2000);
		click(zaza.buttonDeleteConfirm);
		startTest.log(LogStatus.PASS, hm.get("URL"), "Deleted");
	}

}
