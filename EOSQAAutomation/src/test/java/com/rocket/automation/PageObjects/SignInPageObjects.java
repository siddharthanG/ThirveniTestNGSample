package com.rocket.automation.PageObjects;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// created by sid and thirveni

public class SignInPageObjects {

    WebDriver driver;

    @FindBy(xpath = "//*[@id='user_email_login1']")
    WebElement businessEmail;

    @FindBy(xpath = "//*[@id='user_password']")
    WebElement password;

    @FindBy(xpath = "//a[contains(.,'Sign in')]")
    WebElement signIn;


    public SignInPageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Enter BussinessEmail in SignIn Page")
    public void enterBusinessEmail(String arg1) {
    	
        businessEmail.sendKeys(arg1);
    }

    @Step("Enter Password in SignIn Page")
    public void enterPassword(String arg1) {
        password.sendKeys(arg1);
    }

    @Step("Clicking on Sign in button")
    public void clickSignIn() {
        signIn.click();
    }




}
