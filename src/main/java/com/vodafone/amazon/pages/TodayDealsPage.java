package com.vodafone.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class TodayDealsPage extends BasePage {

    private final String departmentCheckBox = "//span[@data-testid='grid-filter-DEPARTMENTS']//li[contains(., '@name')]";
    private final String discountCheckBox = "//span[@data-testid='grid-filter-DISCOUNT']//span[ text() = '@discount']";
    private By nextButton = By.xpath("//a[text() = 'Next']");

    public TodayDealsPage(WebDriver driver) {
        super(driver);
    }


    public void filterByDepartment(String name) {
        By departmentBy = By.xpath(departmentCheckBox.replace("@name", name));
        driver.findElement(departmentBy).click();
    }

    public void filterByDiscount(String discount) {
        By discountBy = By.xpath(discountCheckBox.replace("@discount", discount));
        driver.findElement(discountBy).click();
    }

    public void goToNextPage() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(findElement(nextButton)).build().perform();
        Thread.sleep(10000);
        findElement(nextButton).click();
    }
}
