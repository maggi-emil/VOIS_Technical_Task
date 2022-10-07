package com.vodafone.ksrtc.tests;

import com.vodafone.ksrtc.pages.HomePage;
import com.vodafone.ksrtc.pages.PaymentPage;
import com.vodafone.ksrtc.pages.SearchResultsPage;
import com.vodafone.utilities.PropertiesReader;
import org.testng.annotations.Test;

public class BookingTests extends BaseTest {

    private HomePage homePage;
    private SearchResultsPage searchResultsPage;
    private PaymentPage paymentPage;

    @Test
    public void verifyThat_TheUser_CanBookABusTrip() {
        homePage = new HomePage(getDriver());
        homePage.selectFromPopularRoutes(PropertiesReader.readProperty("ROUTE_NAME", getDataPath()));
        homePage.selectDate(PropertiesReader.readProperty("DATE", getDataPath()));
        homePage.clickOnSearch();
        searchResultsPage = new SearchResultsPage(getDriver());
        searchResultsPage.selectSeatBy(1);
        searchResultsPage.selectBoardingPoint(1);
        searchResultsPage.selectDroppingPoint(1);
        searchResultsPage.enterCustomerDetails(PropertiesReader.readProperty("MOBILE_NUMBER", getDataPath()), PropertiesReader.readProperty("EMAIL", getDataPath()));
        searchResultsPage.selectAvailableSeat(1);
        searchResultsPage.enterPassengerName(PropertiesReader.readProperty("PASSENGER_NAME", getDataPath()));
        searchResultsPage.enterPassengerAge(PropertiesReader.readProperty("PASSENGER_AGE", getDataPath()));
        searchResultsPage.selectPassengerGender(PropertiesReader.readProperty("PASSENGER_GENDER", getDataPath()));
        searchResultsPage.selectConcession(PropertiesReader.readProperty("CONSESSION", getDataPath()));
        searchResultsPage.clickOnMakePayment();
        paymentPage = new PaymentPage(getDriver());
        paymentPage.enterCardNumber(PropertiesReader.readProperty("CARD_NUMBER", getDataPath()));
        paymentPage.enterCardHolderName(PropertiesReader.readProperty("CARD_HOLDER_NAME", getDataPath()));
        paymentPage.enterCVV(PropertiesReader.readProperty("CVV", getDataPath()));
        paymentPage.selectMonth(PropertiesReader.readProperty("CARD_EXPIRY_MONTH", getDataPath()));
        paymentPage.selectYear(PropertiesReader.readProperty("CARD_EXPIRY_YEAR", getDataPath()));
    }
}
