package com.vodafone.amazon.tests;

import com.vodafone.amazon.pages.*;
import com.vodafone.utilities.PropertiesReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTests extends BaseTest {

    private HomePage homePage;
    private SearchResultsPage searchResultsPage;
    private ItemDetailsPage itemDetailsPage;
    private AddedToCartPage addedToCartPage;
    private CartPage cartPage;
    private TodayDealsPage todayDealsPage;
    private TodayDealsResultsPage todayDealsResultsPage;

    @Test
    public void verifyThat_TheUser_CanAddItemToTheCart_Successfully() {
        homePage = new HomePage(getDriver());
        homePage.searchBy(PropertiesReader.readProperty("SEARCH_KEY", getDataPath()));
        searchResultsPage = new SearchResultsPage(getDriver());
        searchResultsPage.selectItem(2);
        itemDetailsPage = new ItemDetailsPage(getDriver());
        String productName = itemDetailsPage.getProductName();
        itemDetailsPage.addToCart();
        addedToCartPage = new AddedToCartPage(getDriver());
        addedToCartPage.goToCart();
        cartPage = new CartPage(getDriver());
        boolean actualItemExists = cartPage.isItemExists(productName);
        Assert.assertTrue(actualItemExists);
    }

    @Test
    public void verifyThat_TheUser_CanFilterByTodayDeals_AndAddItemsToCart() throws InterruptedException {
        homePage = new HomePage(getDriver());
        homePage.openTodayDeals();
        todayDealsPage = new TodayDealsPage(getDriver());
        todayDealsPage.filterByDepartment(PropertiesReader.readProperty("FILTER_BY_GROCERY", getDataPath()));
        todayDealsPage.filterByDepartment(PropertiesReader.readProperty("FILTER_BY_HEADPHONES", getDataPath()));
        todayDealsPage.filterByDiscount(PropertiesReader.readProperty("FILTER_BY_TEN_PERCENT_DISCOUNT", getDataPath()));
        todayDealsPage.goToNextPage();
        todayDealsPage.goToNextPage();
        todayDealsPage.goToNextPage();
        todayDealsResultsPage = new TodayDealsResultsPage(getDriver());
        todayDealsResultsPage.selectItem(1);
        itemDetailsPage = new ItemDetailsPage(getDriver());
        itemDetailsPage.addToCart();
    }
}
