package com.vodafone.ksrtc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SearchResultsPage extends BasePage {

    private final String selectSeatsButton = "(//div[@class='select-service']//input[@type='button'])[@index]";
    private final String boardingPoint = "(//p[text() = 'Please select a Boarding Point: ']//following-sibling::ul/li)[@index]";
    private final String droppingPoint = "(//p[text() = 'Please select a Dropping Point:']//following-sibling::ul/li)[@index]";
    private final By mobileNumberBy = By.id("mobileNo");
    private final By emailBy = By.id("email");
    private final String selectSeatButton = "(//div[@id = 'seatlayout-Forward1']//ul//li[@class='availSeatClassS'])[@index]";
    private final By passengerNameBy = By.name("passengerName");
    private final By genderDropDown = By.name("genderCodeId");
    private final By ageTextField = By.name("passengerAge");
    private final By concessionDropDown = By.name("concessionIds");
    private final By makePaymentButton = By.xpath("//input[@name='PgBtn']");

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public void selectSeatBy(int index) {
        By selectSeatBy = By.xpath(selectSeatsButton.replace("@index", String.valueOf(index)));
        clickButton(selectSeatBy);
    }

    public void selectBoardingPoint(int index) {
        By boardingPointBy = By.xpath(boardingPoint.replace("@index", String.valueOf(index)));
        clickButton(boardingPointBy);
    }

    public void selectDroppingPoint(int index) {
        By droppingPointBy = By.xpath(droppingPoint.replace("@index", String.valueOf(index)));
        clickButton(droppingPointBy);
    }

    public void enterCustomerDetails(String mobileNumber, String emailId) {
        findElement(mobileNumberBy).sendKeys(mobileNumber);
        findElement(emailBy).sendKeys(emailId);
    }

    public void selectAvailableSeat(int index) {
        By selectSeatBy = By.xpath(selectSeatButton.replace("@index", String.valueOf(index)));
        findElement(selectSeatBy).click();
    }

    public void enterPassengerName(String name) {
        findElement(passengerNameBy).sendKeys(name);
    }

    public void selectPassengerGender(String gender) {
        Select select = new Select(findElement(genderDropDown));
        select.selectByVisibleText(gender);
    }

    public void enterPassengerAge(String age) {
        findElement(ageTextField).sendKeys(age);
    }

    public void selectConcession(String concession) {
        Select select = new Select(findElement(concessionDropDown));
        select.selectByVisibleText(concession);
    }

    public void clickOnMakePayment() {
        findElement(makePaymentButton).click();
    }

}
