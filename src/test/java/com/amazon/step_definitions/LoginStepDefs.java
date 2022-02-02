package com.amazon.step_definitions;

import com.amazon.pages.LoginPage;
import com.amazon.pages.MainPage;
import com.amazon.utilities.ConfigurationReader;
import com.amazon.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {
    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();

    @When("the user navigates to main page")
    public static void the_user_navigates_to_main_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @Then("the user sees that the main page is loaded")
    public void the_user_sees_that_the_main_page_is_loaded() {
        String expected = "Amazon.com. Spend less. Smile more.";
        Assert.assertEquals("verify that main page is loaded", expected, Driver.get().getTitle());
    }

    @When("the user clicks Hello, Sign in Account & List button")
    public void the_user_clicks_button() {
        mainPage.helloSigninButton.click();
    }

    @When("the user enters valid email and password")
    public void the_user_enters_valid_email_and_password() {
        loginPage.emailBox.sendKeys(ConfigurationReader.get("user"));
        loginPage.continueButton.click();
        loginPage.passwordBox.sendKeys(ConfigurationReader.get("password"));
        try {
            loginPage.signinButton.click();
        } catch (Exception e){

        }
    }


    @Then("the user sees username after Hello word next to Language flag")
    public void the_user_sees_username_after_Hello_word_next_to_Language_flag() {
       Assert.assertEquals("verify that user logged in","Hello, egitim", mainPage.username.getText());
    }
}
