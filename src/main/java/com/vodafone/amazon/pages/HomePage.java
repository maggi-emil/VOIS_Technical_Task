package com.vodafone.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private final By searchBarTextField = By.id("twotabsearchtextbox");
    private final By searchButton = By.id("nav-search-submit-button");
    private final By todayDealLink = By.linkText("Today's Deals");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void searchBy(String itemName) {
        findElement(searchBarTextField).sendKeys(itemName);
        findElement(searchButton).click();
    }

    public void openTodayDeals() {
        clickButton(todayDealLink);
    }

}
