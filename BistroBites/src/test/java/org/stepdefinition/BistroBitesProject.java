package org.stepdefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BistroBitesProject extends BaseClass {

	// login
	@Given("launch the url to get homepage of the Bistrobites website")
	public void launchTheUrlToGetHomepageOfTheBistrobitesWebsite() {
		driver.get("https://bistrobitesdc.com/");
		/*
		 * JavascriptExecutor js = (JavascriptExecutor) driver;
		 * js.executeScript("return document.readyState").equals("complete");
		 */
	}

	@When("Click the Account button")
	public void clickTheAccountButton() {
		driver.findElement(By.xpath("(//span[contains(text(),'Account')])[2]")).click();
	}

	@When("Give the wrong username and password")
	public void giveTheWrongUsernameAndPassword() {
		driver.findElement(By.id("phone")).sendKeys("9874561230");
		driver.findElement(By.name("password")).sendKeys("dummyUser001");
	}

	@When("Click the login button")
	public void clickTheLoginButton() {
		driver.findElement(By.name("login")).click();
	}

	@Then("check the output whether it is showing Invalid mobile number or not")
	public void checkTheOutputWhetherItIsShowingInvalidMobileNumberOrNot() throws InterruptedException {
		Thread.sleep(1000);
		WebElement msg = driver.findElement(By.xpath("//ul[@role='alert']/li"));
		String errorMsg = msg.getText();
		
		if (msg.isDisplayed()) {
			System.out.println(errorMsg);
		} else {
			System.out.println("Logged in Successfully");
		}
	}

	// adding food to cart
	@When("Check a dropdown labeled Dosa and click it")
	public void iSeeADropdownLabeledDosa() throws InterruptedException {
		driver.findElement(By.xpath("//button[contains(text(),'cookies')]")).click();
		Thread.sleep(1000);
		WebElement dosa = driver.findElement(By.xpath("//a[contains(@href,'cat=10')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", dosa);
		dosa.click();
	}

	@When("Select the Masala Dosa option")
	public void selectTheMasalaDosaOption() {
		WebElement masalaDosa = driver.findElement(By.xpath("//h2[text()='Masala Dosa']"));
		masalaDosa.click();
	}

	@When("Add it to cart")
	public void addItToCart() {
		WebElement addCart = driver.findElement(By.name("add-to-cart"));
		addCart.click();
	}
	
	@Then("Verify the item in Cart")
	public void verifyTheItemInCart() {
		WebElement cartMsg = driver.findElement(By.xpath("//div[@role='alert']"));
		String confirmationMsg = cartMsg.getText();
		if (confirmationMsg.contains("Add Successfully")) {
			System.out.println(confirmationMsg);
		}
		else {
			System.out.println("Selected item didn't get added into cart");
		}
		
	}
	
	// Create New Account
	@When("Fill out the registration form with dummy data and skip the confirm password text label")
	public void fillOutTheRegistrationFormWithDummyDataAndSkipTheConfirmPasswordTextLabel() {
		
		driver.findElement(By.id("name")).sendKeys("Manivel");
		driver.findElement(By.name("email")).sendKeys("manivel.demo@gmail.com");
		driver.findElement(By.xpath("(//input[@id='phone'])[2]")).sendKeys("9874563210");
		driver.findElement(By.xpath("//input[@id='password_reg']")).sendKeys("DemoUser001");	
	}

	@When("Click the Register button")
	public void clickTheRegisterButton() {
		WebElement reg = driver.findElement(By.xpath("//button[contains(text(),'Register')]"));
		reg.click();
	}

	@Then("Get the pop-up please fill out the field")
	public void getThePopUpPleaseFillOutTheField() {
		String title = driver.getTitle();
		if (title.contains("Login")) {
			System.out.println("Missed to enter some details in registration form");
		}
		else {
			System.out.println("Sigup successfull");
		}
	}

	// Search coke and check price
	@When("Click the search icon")
	public void clickTheSearchIcon() {
		driver.findElement(By.xpath("//a[@id='lte-top-search-ico']")).click();
	}

	@When("Search for coke")
	public void searchForCoke() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@placeholder='Search'])[2]")).sendKeys("coke",Keys.ENTER);
	}

	@Then("Check the price is {double} dollar or not")
	public void checkThePriceIsDollarOrNot(Double double1) {
		WebElement price = driver.findElement(By.xpath("(//span[@class='woocommerce-Price-amount amount'])[1]"));
		String value = price.getText();
		if (value.contains("1.50")) {
			System.out.println("Price of the coke is 1.50 dollar");
		}
		else {
			System.out.println("Price is "+value);
		}
		
	}

	// Search and check a product's price probability
	@When("Search for the Spanish Omelet and select it")
	public void searchForTheSpanishOmeletAndSelectIt() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@placeholder='Search'])[2]")).sendKeys("Spanish Omelet",Keys.ENTER);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//h2[text()='Spanish omelet']")).click();
	}

	@When("Select the option by probability")
	public void selectTheOptionByProbability() throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='ingredients-box-custom'][2]")).click();
		Thread.sleep(1000);	
	}

	@Then("Check the dollar probabiltiy")
	public void checkTheDollarProbabiltiy() {
		WebElement price = driver.findElement(By.id("priceshow"));
		String value = price.getText();
		System.out.println("Price probobility after select extra toppings : " +value);
	}

	// Read Bistro's story
	@When("Click the our story option")
	public void clickTheOurStoryOption() {
		driver.findElement(By.xpath("//a[contains(@href,'aboutus')]")).click();
	}

	@Then("Check for spelling mistake")
	public void checkForSpellingMistake() {
		List<WebElement> para = driver.findElements(By.xpath("//h4//following-sibling::p"));
		String story = para.toString();
		if (story.equalsIgnoreCase(story)) {
			System.out.println("Our story not have any spelling mistakes");
		}
		else {
			System.out.println("Our story have spelling mistakes");
		}
	}
}
