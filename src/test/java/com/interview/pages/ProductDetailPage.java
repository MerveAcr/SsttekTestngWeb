package com.interview.pages;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.interview.utilities.Driver;
import com.interview.utilities.HelperMethods;

public class ProductDetailPage {
	WebDriverWait wait;

	public ProductDetailPage() {
		PageFactory.initElements(Driver.getDriver(), this);
		wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
	}

	@FindBy(css = "[data-testid=\"x-atc-action\"]")
	WebElement addToCart;
	// sometimes we get different html page which has different add product locator
	@FindBy(xpath = "//div[@class=\"item-actions\"]//a[normalize-space()=\"Add to cart\"]")
	WebElement addToCart2;

	@FindBy(css = "[data-testid=\"x-watch-action\"]")
	WebElement addToWatchList;

	@FindBy(css = ".watching")
	WebElement watchingStatus;

	public void clickAddToCart() {
		if (HelperMethods.isElementPresent(this.addToCart)) {
			this.addToCart.click();
		} else {
			this.addToCart2.click();
		}
	}

	public void clickAddToWatchList() {
		wait.until(ExpectedConditions.elementToBeClickable(this.addToWatchList));
		this.addToWatchList.click();
	}

	public boolean isProductSaved() {
		return HelperMethods.isElementPresent(this.watchingStatus);
	}
}
