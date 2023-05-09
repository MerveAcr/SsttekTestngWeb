package com.interview.tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.interview.pages.Cart;
import com.interview.pages.Navigation;
import com.interview.pages.ProductDetailPage;
import com.interview.pages.ResultPage;
import com.interview.pages.SignIn;
import com.interview.pages.Watchlist;
import com.interview.test.data.NavBarData;
import com.interview.utilities.Config;
import com.interview.utilities.Driver;
import com.interview.utilities.HelperMethods;

public class AddRemoveSaveItems {

	@Test(priority = 0)
	public void addAndRemoveProduct() throws InterruptedException {
		ProductDetailPage productPage = new ProductDetailPage();
		ResultPage resultList = new ResultPage();
		Navigation navBar = new Navigation();
		Cart cart = new Cart();

		navBar.clickNavigationCategory(NavBarData.HOME_AND_GARDEN);
		navBar.expandSideMenuByCategory(NavBarData.HOME_DECOR);
		navBar.selectProductFromSideMenu(NavBarData.CLOCK);

		// saved first three item for further verification
		String item1 = resultList.getItemTitlesByIndex(0);
		String item2 = resultList.getItemTitlesByIndex(1);
		String item3 = resultList.getItemTitlesByIndex(2);
		// select first visible item
		resultList.selectItemOnResultPage(0);
		// switch to new window to add the item to the cart
		Set<String> handles = HelperMethods.getWindowHandles();
		String currentWindowHandle = HelperMethods.getWindowHandle();
		HelperMethods.switchToNewWindow(handles, currentWindowHandle);
		// add item to the cart
		productPage.clickAddToCart();
		Thread.sleep(5000);
		// switch to default window
		HelperMethods.switchDefaultWindow(currentWindowHandle);

		// select second visible item
		resultList.selectItemOnResultPage(1);
		handles = HelperMethods.getWindowHandles();
		HelperMethods.switchToNewWindow(handles, currentWindowHandle);
		productPage.clickAddToCart();
		Thread.sleep(5000);
		HelperMethods.switchDefaultWindow(currentWindowHandle);

		// select third visible item
		resultList.selectItemOnResultPage(2);
		handles = HelperMethods.getWindowHandles();
		HelperMethods.switchToNewWindow(handles, currentWindowHandle);
		productPage.clickAddToCart();
		Thread.sleep(5000);

		// remove item from the cart
		cart.removeByItemName(item1);

		// verify confirmation message
		Assert.assertTrue(cart.doesRemovedItemConfirmationMessageExist());
		Assert.assertEquals(cart.getConfirmationMessage(), item1 + " " + "was removed from your cart.");

		// verify items in the cart
		ArrayList<String> abc = cart.getAllItemInTheCart();
		Assert.assertFalse(abc.contains(item1));
		Assert.assertTrue(abc.contains(item2));
		Assert.assertTrue(abc.contains(item3));
	}

	@Test(priority = 1)
	public void saveProduct() throws InterruptedException {
		ProductDetailPage productPage = new ProductDetailPage();
		ResultPage resultList = new ResultPage();
		Navigation navBar = new Navigation();
		Watchlist watchlist = new Watchlist();
		SignIn signIn = new SignIn();

		// go to sign in page
		Driver.getDriver().get(Config.getProperty("signInPage"));
		// enter username and password
		signIn.enterUsername((Config.getProperty("username")));
		signIn.clickContinueButton();
		signIn.enterPassword((Config.getProperty("password")));
		signIn.clickSignInButton();
		// sometimes user get asked easy access
		signIn.clickDontAskMeAgainLink();
		//select catgegory
		navBar.clickNavigationCategory(NavBarData.HOME_AND_GARDEN);
		navBar.expandSideMenuByCategory(NavBarData.HOME_DECOR);
		navBar.selectProductFromSideMenu(NavBarData.CLOCK);

		// saved next three item for further verification
		String item1 = resultList.getItemTitlesByIndex(3);
		String item2 = resultList.getItemTitlesByIndex(4);
		String item3 = resultList.getItemTitlesByIndex(5);

		resultList.selectItemOnResultPage(3);
		// switch to new window to add the item to the cart
		Set<String> handles = HelperMethods.getWindowHandles();
		String currentWindowHandle = HelperMethods.getWindowHandle();
		HelperMethods.switchToNewWindow(handles, currentWindowHandle);
		// add to watchlist and verify product saved
		productPage.clickAddToWatchList();
		Assert.assertTrue(productPage.isProductSaved());

		// switch to default window
		HelperMethods.switchDefaultWindow(currentWindowHandle);

		// select second visible item
		resultList.selectItemOnResultPage(4);
		handles = HelperMethods.getWindowHandles();
		HelperMethods.switchToNewWindow(handles, currentWindowHandle);

		productPage.clickAddToWatchList();
		Assert.assertTrue(productPage.isProductSaved());
		// switch to default window
		HelperMethods.switchDefaultWindow(currentWindowHandle);
		// select second visible item
		resultList.selectItemOnResultPage(5);
		handles = HelperMethods.getWindowHandles();
		HelperMethods.switchToNewWindow(handles, currentWindowHandle);
		productPage.clickAddToWatchList();
		Assert.assertTrue(productPage.isProductSaved());
		
		//navigate to watchlist to verify saved item
		watchlist.clickWatchlist();
		watchlist.clickAllWatchlist();
		
		//get all saved product from watchlist and verify saved items added to the watchlist 
		ArrayList<String> watchlistProducts = watchlist.getAllItemInTheWatchlist();
		Assert.assertTrue(watchlistProducts.contains(item1));
		Assert.assertTrue(watchlistProducts.contains(item2));
		Assert.assertTrue(watchlistProducts.contains(item3));
		// delete all item after test
		watchlist.clickBulkCheck();
		watchlist.clickDelete();

	}

	@BeforeMethod
	public void beforeMethod() {
		Driver.getDriver().get(Config.getProperty("homePage"));
	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
		HelperMethods.takeScreenshot(result);
		Driver.closeDriver();
	}

}
