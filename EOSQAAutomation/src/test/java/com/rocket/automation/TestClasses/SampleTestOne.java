package com.rocket.automation.TestClasses;

import java.util.concurrent.TimeUnit;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import com.rocket.automation.Wrappers.UIWrappers;
import com.rocket.automation.PageObjects.SignInPageObjects;
import com.rocket.automation.Utils.LoggerUtil;

// created by sid and thirveni

@Listeners({com.rocket.automation.Listeners.TestAllureReportListener.class})
public class SampleTestOne extends UIWrappers {

    SignInPageObjects signInObjects;
    WebDriver driver;

    public SampleTestOne() {

        propertyLoader();
    }

    @BeforeMethod
    public void firstTest() {
        this.driver = launchBrowser();
        driver.get(propLoader.prop.getProperty("baseURI"));
        signInObjects = new SignInPageObjects(driver);
        LoggerUtil.logInfo("SampleTestOne BeforeTest: " + driver.toString());
        LoggerUtil.logInfo("SampleTestOne Thread ID: " + Thread.currentThread().getId());
    }

    @AfterMethod
    public void lastTest() {
        closeBrowser(driver);

    }


    @Test(priority = 0, description = "Enter the email")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify Email field is enabled")
    @Story("Story Name: To check login page title in Chrome Browser")
    public void TestOne() {
        try {
            signInObjects.clickSignIn();
            signInObjects.enterBusinessEmail("Test@gmail.com");
            LoggerUtil.logLoader_info(this.getClass().getSimpleName(), "SampleTestOne TestMethod1: Email Entered");

        } catch (Exception e) {
            LoggerUtil.logLoader_error(this.getClass().getSimpleName(), e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    @Test(priority = 1, description = "Enter the Password")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify Email field is enabled")
    @Story("Story Name: To check login page title in Chrome Browser")
    public void TestSecond() {
        try {
            signInObjects.clickSignIn();
            signInObjects.enterPassword("Password");
            LoggerUtil.logLoader_info(this.getClass().getSimpleName(), "SampleTestOne TestMethod2: Password Entered");

        } catch (Exception e) {
            LoggerUtil.logLoader_error(this.getClass().getSimpleName(), e.getMessage());
            Assert.fail(e.getMessage());

        }
    }

}
