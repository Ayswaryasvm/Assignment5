package assignment5.dynamic;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateLead extends BaseClass {

	@DataProvider(name = "fetchData")
	public String[][] sendData() {
		String[][] data = new String[2][4];

		data[0][0] = "TestLeaf";
		data[0][1] = "Ayswarya";
		data[0][2] = "E";
		data[0][3] = "9876543210";

		data[1][0] = "TestLeaf";
		data[1][1] = "Ayshu";
		data[1][2] = "E";
		data[1][3] = "9222222222";

		return data;
	}

	@Test(dataProvider = "fetchData")
	public void runCreateLead(String cName, String fName, String lName, String pNo) {
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cName);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fName);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lName);
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(pNo);
		driver.findElement(By.name("submitButton")).click();
		String text = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		if (text.contains(cName)) {
			System.out.println("Lead created successfully");
		} else {
			System.out.println("Lead is not created");
		}
		driver.close();

	}

}
