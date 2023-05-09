package com.interview.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.interview.utilities.Driver;
import com.interview.utilities.HelperMethods;

public class Cart {
	WebDriverWait wait;

	public Cart() {
		PageFactory.initElements(Driver.getDriver(), this);
		wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(30));
	}

	@FindBy(css = "#confirmation-status + div .text-display-span")
	WebElement removedItemMessage;

	@FindBy(css = "[data-test-id=\"app-cart\"] [data-test-id=\"cart-bucket\"] .text-display-span label")
	List<WebElement> cartItemList;

	public void removeByItemName(String name) {
		WebElement element = Driver.getDriver()
				.findElement(By.xpath("//button[contains(@aria-label, \"Remove - " + name + "\")]"));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

	public boolean doesRemovedItemConfirmationMessageExist() {
		wait.until(ExpectedConditions.visibilityOf(this.removedItemMessage));
		return removedItemMessage.isDisplayed();
	}

	public String getConfirmationMessage() {
		wait.until(ExpectedConditions.visibilityOf(this.removedItemMessage));
		return this.removedItemMessage.getText();
	}

	public ArrayList<String> getAllItemInTheCart() {
		return HelperMethods.getTextListFromElementList(this.cartItemList);
	}
}
