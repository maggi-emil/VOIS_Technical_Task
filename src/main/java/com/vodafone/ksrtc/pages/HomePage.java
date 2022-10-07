package com.vodafone.ksrtc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private final String routeLink = "//section[@class='popular-section']//a[text() = '@routeName']";
    private final By nextButton = By.xpath("//section[@class='popular-section']//a[@data-slide='next']");
    private final String dayLink = "//td[@data-handler='selectDay']//a[text() = '@day']";
    private final By searchButton = By.xpath("//button[contains(@class, 'btn-booking')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void selectFromPopularRoutes(String routeName) {
        By routeLinkBy = By.xpath(routeLink.replace("@routeName", routeName));
        while(!findElement(routeLinkBy).isDisplayed()) {
            findElement(nextButton).click();
        }
        findElement(routeLinkBy).click();
    }

    public void selectDate(String day) {
        By dayLinkBy = By.xpath(dayLink.replace("@day", day));
        findElement(dayLinkBy).click();
    }

    public void clickOnSearch() {
        clickButton(searchButton);
    }
}
