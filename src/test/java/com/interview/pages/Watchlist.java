package com.interview.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.interview.utilities.Driver;
import com.interview.utilities.HelperMethods;

public class Watchlist {
	WebDriverWait wait;

	public Watchlist() {
		PageFactory.initElements(Driver.getDriver(), this);
		wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(30));
	}
	
	@FindBy(css = ".m-items .m-item .item-title")
	List<WebElement> allItems;
	
	@FindBy(css = ".bulkCheck")
	WebElement bulkCheck;
	
	@FindBy(xpath = "//div[@class=\"items-action\"]//button[text()=\"Delete\"]")
	WebElement delete;
	
	@FindBy(css = "a[title=\"Watchlist\"]")
	WebElement watchlistButton;
	
	@FindBy(css = "span[aria-label=\"View all items you are watching\"]")
	WebElement allWatchlistButton;
	
	public ArrayList<String> getAllItemInTheWatchlist() {
		wait.until(ExpectedConditions.visibilityOfAllElements(this.allItems));
		return HelperMethods.getTextListFromElementList(this.allItems);
	}
	
	public void clickBulkCheck() {
		wait.until(ExpectedConditions.elementToBeClickable(this.bulkCheck));
		this.bulkCheck.click();
	}
	
	public void clickDelete() {
		wait.until(ExpectedConditions.elementToBeClickable(this.delete));
		this.delete.click();
	}
	
	public void clickWatchlist() {
		wait.until(ExpectedConditions.elementToBeClickable(this.watchlistButton));
		this.watchlistButton.click();
	}
	
	public void clickAllWatchlist() {
		wait.until(ExpectedConditions.elementToBeClickable(this.allWatchlistButton));
		this.allWatchlistButton.click();
	}
	
}
