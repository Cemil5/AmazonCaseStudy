package com.amazon.step_definitions;

import com.amazon.pages.LoginPage;
import com.amazon.pages.MainPage;
import com.amazon.pages.ProductDetailPage;
import com.amazon.pages.SearchPage;
import com.amazon.utilities.BrowserUtils;
import com.amazon.utilities.ConfigurationReader;
import com.amazon.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchStepDefs {

    SearchPage searchPage = new SearchPage();

    @Given("the user logged in to homepage")
    public void the_user_logged_in_to_homepage() {
        MainPage mainPage = new MainPage();
        LoginPage loginPage = new LoginPage();

        Driver.get().get(ConfigurationReader.get("url"));
        mainPage.helloSigninButton.click();

        loginPage.emailBox.sendKeys(ConfigurationReader.get("user"));
        loginPage.continueButton.click();
        loginPage.passwordBox.sendKeys(ConfigurationReader.get("password"));
        try {
            loginPage.signinButton.click();
        } catch (Exception e) {

        }

    }

    @When("the user enters {string} to the search bar on the top part of the screen and clicks search")
    public void the_user_enters_to_the_search_bar_on_the_top_part_of_the_screen_and_click_search(String itemName) {
        searchPage.searchBox.sendKeys(itemName);
        searchPage.searchButton.click();
    }

    @Then("the user confirms that search results include a {string} product")
    public void the_user_confirms_that_search_results_include_a_product(String itemName) {
        List<WebElement> list = searchPage.searchResult(itemName);
        Assert.assertTrue("verify that search results include product", list.size() > 0);
    }

    @When("the user navigates to second search page")
    public void the_user_navigates_to_second_search_page() {
        searchPage.secondPage.click();
        BrowserUtils.waitFor(3);
    }

    @Then("the user confirms that user is in the second page")
    public void theUserConfirmsThatUserIsInTheSecondPage() {
        String actualText = searchPage.confirmingSecondPage.getText();
        System.out.println("actualText = " + actualText);
        Assert.assertTrue(actualText.contains("17-32"));
    }

    @When("the user clicks on the {int} rd product in current page")
    public void the_user_clicks_on_the_rd_product_in_current_page(Integer indexNumber) {
        searchPage.selectDesiredItem(indexNumber).click();
    }

    ProductDetailPage productDetailPage = new ProductDetailPage();

    @When("the user adds the selected product in current page to the cart")
    public void the_user_adds_rd_product_in_current_page_to_the_cart() {
        productDetailPage.addToCartButton.click();
    }

    @Then("the user verifies that Cart subtotal shows one item on the pop up window")
    public void the_user_verifies_that_Cart_subtotal_shows_item_on_the_pop_up_window() {
        BrowserUtils.waitFor(3);
        String actualText = productDetailPage.cartSubTotal.getText();
        System.out.println("actualText = " + actualText);
        Assert.assertTrue("verify that Cart subtotal shows 1 item", actualText.contains("1"));
    }
}
