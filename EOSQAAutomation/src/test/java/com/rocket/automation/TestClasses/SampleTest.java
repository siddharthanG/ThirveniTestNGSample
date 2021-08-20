package com.rocket.automation.TestClasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import com.rocket.automation.PageObjects.SamplePageObjects;
import com.rocket.automation.Utils.LoggerUtil;
import com.rocket.automation.Wrappers.UIWrappers;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

// created by sid and thirveni

@Listeners({com.rocket.automation.Listeners.TestAllureReportListener.class})
public class SampleTest extends UIWrappers {


    SamplePageObjects objects;

    public SampleTest() {
        propertyLoader();
    }

    // this method will be executed before every @test method
    @BeforeMethod
    public void firstTest() {
        this.driver = launchBrowser();
        driver.get(propLoader.prop.getProperty("baseURI"));
        objects = new SamplePageObjects(driver);
        LoggerUtil.logInfo("SampleTestOne BeforeTest: " + driver.toString());
        LoggerUtil.logInfo("SampleTestOne Thread ID: " + Thread.currentThread().getId());
    }

    @AfterMethod
    public void lastTest() {
        closeBrowser(driver);

    }


    @Test(priority = 0, description = "verifying the header")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify login page title test on Login Page")
    @Story("Story Name: To check login page title in Firefox browser")
    public void verifyValidURL() {
        try {
            objects.veryHeader();
            LoggerUtil.logLoader_info(this.getClass().getSimpleName(), objects.getHeader() + "Text is available as header");
        } catch (Exception e) {
            LoggerUtil.logLoader_error(this.getClass().getSimpleName(), e.getMessage());
            Assert.fail(e.getMessage());

        }
    }

    @Test(priority = 1, description = "Verify Succussful login")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify Succussful login")
    @Story("Story Name: To check login page title in Firefox browser")
    public void SuccefullLogin() {
        try {
            objects.clickSignIn();
            objects.enterFullName("email");
            objects.enterPassword("password");
//		objects.clickSignIn();

            LoggerUtil.logLoader_info(this.getClass().getSimpleName(), "Login Success");
        } catch (Exception e) {
            LoggerUtil.logLoader_error(this.getClass().getSimpleName(), e.getMessage());
            Assert.fail(e.getMessage());

        }
    }

}
