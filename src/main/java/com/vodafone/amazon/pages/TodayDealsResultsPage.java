package com.vodafone.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TodayDealsResultsPage extends BasePage {

    private final String resultItem = "(//div[@data-testid='grid-deals-container']//a)[@index]";


    public TodayDealsResultsPage(WebDriver driver) {
        super(driver);
    }

    public void selectItem(int index) {
        By resultItemBy = By.xpath(resultItem.replace("@index", String.valueOf(index)));
        findElement(resultItemBy).click();
    }
}
