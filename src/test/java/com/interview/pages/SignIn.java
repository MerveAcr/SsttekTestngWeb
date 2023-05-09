package com.interview.pages;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.interview.utilities.Driver;
import com.interview.utilities.HelperMethods;

public class SignIn {
	WebDriverWait wait;

	public SignIn() {
		PageFactory.initElements(Driver.getDriver(), this);
		wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(30));
	}

	@FindBy(id = "userid")
	WebElement username;

	@FindBy(id = "pass")
	WebElement password;

	@FindBy(id = "signin-continue-btn")
	WebElement continueButton;

	@FindBy(id = "sgnBt")
	WebElement signInButton;
	
	@FindBy(id = "dont-ask-again-link")
	WebElement dontAskMeAgainLink;

	public void enterUsername(String username) {
		wait.until(ExpectedConditions.visibilityOf(this.username));
		this.username.sendKeys(username);
	}

	public void enterPassword(String password) {
		wait.until(ExpectedConditions.elementToBeClickable(this.password));
		this.password.sendKeys(password);
	}

	public void clickContinueButton() {
		wait.until(ExpectedConditions.elementToBeClickable(this.continueButton));
		this.continueButton.click();
	}

	public void clickSignInButton() {
		wait.until(ExpectedConditions.elementToBeClickable(this.signInButton));
		this.signInButton.click();
	}
	
	public void clickDontAskMeAgainLink() {
		if(HelperMethods.isElementPresent(this.dontAskMeAgainLink)) {
			this.dontAskMeAgainLink.click();
		}
	}
}
