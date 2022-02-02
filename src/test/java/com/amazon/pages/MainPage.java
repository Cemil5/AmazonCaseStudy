package com.amazon.pages;

import io.cucumber.java.en_lol.WEN;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    @FindBy(id = "nav-link-accountList")
    public WebElement helloSigninButton;

    @FindBy(id = "nav-link-accountList-nav-line-1")
    public WebElement username;



}
