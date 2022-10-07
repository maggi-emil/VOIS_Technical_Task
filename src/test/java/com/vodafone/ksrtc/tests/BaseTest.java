package com.vodafone.ksrtc.tests;

import com.vodafone.utilities.PropertiesReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    private WebDriver driver;
    private final String dataPath = "src/test/resources/ksrtc.properties";

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        Dimension dimension = new Dimension(1024, 768);
        driver.manage().window().setSize(dimension);
        driver.get(PropertiesReader.readProperty("KSRTC_URL", dataPath));
    }


    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public String getDataPath() {
        return dataPath;
    }
}
