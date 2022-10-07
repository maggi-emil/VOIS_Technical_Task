package com.vodafone.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private final String itemNameLabel = "//form[@id='activeCartViewForm']//span[text()='@name']";

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isItemExists(String name) {
        By itemXpath = By.xpath(itemNameLabel.replace("@name", name));
        return findElements(itemXpath).size() > 0 ? true : false;
    }
}
