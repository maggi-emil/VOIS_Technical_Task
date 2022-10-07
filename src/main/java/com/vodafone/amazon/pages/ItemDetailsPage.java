package com.vodafone.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemDetailsPage extends BasePage {

    private final By addToCartButton = By.id("add-to-cart-button");
    private final By productName = By.id("productTitle");

    public ItemDetailsPage(WebDriver driver) {
        super(driver);
    }

    public void addToCart() {
        findElement(addToCartButton).click();
    }

    public String getProductName() {
        return findElement(productName).getText();
    }
}
