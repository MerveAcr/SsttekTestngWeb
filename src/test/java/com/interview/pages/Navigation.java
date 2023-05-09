package com.interview.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.interview.utilities.Driver;

public class Navigation {
	WebDriverWait wait;

	public Navigation() {
		PageFactory.initElements(Driver.getDriver(), this);
		wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(30));
	}

	@FindBy(css = "#gh-shop button")
	WebElement searchByCategory;

	@FindBy(css = "#gh-eb #gh-wl-click")
	WebElement watchlistButon;

	@FindBy(css = "#gh-wl-click-body .rvi__title")
	WebElement allWatchlistItem;

	private WebElement getGlobalNavLocatorByCategory(String category) {
		return Driver.getDriver().findElement(By
				.xpath("//ul[@class=\"hl-cat-nav__container\"]//*[@class=\"hl-cat-nav__js-tab\"]//*[normalize-space()='"
						+ category + "']"));
	}

	private WebElement getSideMenuLocatorByCategory(String category) {
		return Driver.getDriver()
				.findElement(By.xpath("//div[@class=\"dialog__cell\"]//span[normalize-space()='" + category + "']"));
	}

	private WebElement getProductLocatorByName(String product) {
		return Driver.getDriver().findElement(By.xpath("//a[normalize-space()='" + product + "']"));
	}

	public void clickNavigationCategory(String category) {
		wait.until(ExpectedConditions.elementToBeClickable(getGlobalNavLocatorByCategory(category)));
		getGlobalNavLocatorByCategory(category).click();
	}

	public void expandSideMenuByCategory(String category) {
		wait.until(ExpectedConditions.elementToBeClickable(getSideMenuLocatorByCategory(category)));
		getSideMenuLocatorByCategory(category).click();
	}

	public void selectProductFromSideMenu(String product) {
		wait.until(ExpectedConditions.elementToBeClickable(getProductLocatorByName(product)));
		getProductLocatorByName(product).click();
	}

}
