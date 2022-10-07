package com.vodafone.ksrtc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class PaymentPage extends BasePage {

    private final By cardNumberTextField = By.id("cnumber");
    private final By cardHolderNameTextField = By.id("cname2");
    private final By cvvTextField = By.id("cvv2");
    private final By monthDropDown = By.id("expmon");
    private final By yearDropDown = By.id("expyr");

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public void enterCardNumber(String cardNumber) {
        findElement(cardNumberTextField).sendKeys(cardNumber);
    }

    public void enterCardHolderName(String name) {
        findElement(cardHolderNameTextField).sendKeys(name);
    }

    public void enterCVV(String cvv) {
        findElement(cvvTextField).sendKeys(cvv);
    }

    public void selectMonth(String month) {
        Select select = new Select(findElement(monthDropDown));
        select.selectByVisibleText(month);
    }
    public void selectYear(String year) {
        Select select = new Select(findElement(yearDropDown));
        select.selectByVisibleText(year);
    }
}
