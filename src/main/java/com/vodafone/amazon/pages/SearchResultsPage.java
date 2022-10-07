package com.vodafone.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage extends BasePage {

    private final String resultItem = "(//div[@data-component-type='s-search-result'])[@index]";

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public void selectItem(int index) {
        By resultItemBy = By.xpath(resultItem.replace("@index", String.valueOf(index)));
        findElement(resultItemBy).click();
    }
}
