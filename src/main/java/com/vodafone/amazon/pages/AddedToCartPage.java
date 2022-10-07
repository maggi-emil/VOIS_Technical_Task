package com.vodafone.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddedToCartPage extends BasePage {

    private final By goToCartButton = By.id("sw-gtc");

    public AddedToCartPage(WebDriver driver) {
        super(driver);
    }

    public void goToCart() {
        findElement(goToCartButton).click();
    }
}
