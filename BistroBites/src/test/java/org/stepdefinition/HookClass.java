package org.stepdefinition;

import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HookClass extends BaseClass{
	@Before
	public void preCondtion() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@After
	public void postCondition() {
		//driver.quit();

	}

}
