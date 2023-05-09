package com.interview.utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

public class HelperMethods {

	public static void takeScreenshot(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			TakesScreenshot tc = (TakesScreenshot) Driver.getDriver();
			File src = tc.getScreenshotAs(OutputType.FILE);
			FileHandler.copy(src, new File(result.getName() + ".png"));
		}
	}

	public static Set<String> getWindowHandles() {
		return Driver.getDriver().getWindowHandles();
	}

	public static String getWindowHandle() {
		return Driver.getDriver().getWindowHandle();
	}

	public static void switchToNewWindow(Set<String> handles, String currentWindowHandle) {
		// Switch to the new window
		for (String handle : handles) {
			if (!handle.equals(currentWindowHandle)) {
				Driver.getDriver().switchTo().window(handle);
			}
		}
	}

	public static void switchDefaultWindow(String currentWindowHandle) {
		Driver.getDriver().switchTo().window(currentWindowHandle);
	}

	public static boolean isElementPresent(WebElement locator) {
		try {
			WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOf(locator));
			return true;
		} catch (Exception e) {

			return false;
		}
	}

	public static ArrayList<String> getTextListFromElementList(List<WebElement> list) {
		ArrayList<String> itemList = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			itemList.add(list.get(i).getText());
		}
		return itemList;
	}

}
