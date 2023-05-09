package com.interview.pages;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.interview.utilities.Driver;

public class ResultPage {
	WebDriverWait wait;

	public ResultPage() {
		PageFactory.initElements(Driver.getDriver(), this);
		wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(30));
	}

	@FindBy(css = ".b-list__items_nofooter li .s-item__image")
	public List<WebElement> searchResultItems;

	@FindBy(css = ".b-list__items_nofooter h3.s-item__title")
	public List<WebElement> itemTitles;

	public void selectItemOnResultPage(int index) {
		wait.until(ExpectedConditions.elementToBeClickable(this.searchResultItems.get(index)));
		this.searchResultItems.get(index).click();
	}

	public String getItemTitlesByIndex(int index) {
		wait.until(ExpectedConditions.visibilityOfAllElements(this.itemTitles));
		return this.itemTitles.get(index).getText();
	}
}
