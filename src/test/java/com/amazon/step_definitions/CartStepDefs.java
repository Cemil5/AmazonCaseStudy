package com.amazon.step_definitions;

import com.amazon.pages.CartPage;
import com.amazon.pages.ProductDetailPage;
import com.amazon.pages.SearchPage;
import com.amazon.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class CartStepDefs {

    CartPage cartPage = new CartPage();

    @When("the user navigates to cart page")
    public void the_user_navigates_to_cart_page() {
        try {
            cartPage.navCart.click();
        } catch (Exception e){
            ProductDetailPage productDetailPage = new ProductDetailPage();
            productDetailPage.cartButton.click();
        }
    }

    @Then("the user sees the products that was added to cart")
    public void the_user_sees_the_products_that_was_added_to_cart() {
        List<String> itemList = BrowserUtils.getElementsText(cartPage.activeItems);
        System.out.println("itemList = " + itemList);
        Assert.assertTrue(itemList.contains(SearchPage.selectedItemName));
    }

    @When("the user deletes the first product from the cart")
    public void the_user_delete_the_first_product_from_the_cart() {
        BrowserUtils.waitFor(2);        // to be able to show that cart has an item
        cartPage.deleteButtons.get(0).click();
    }

    @Then("the user confirms that this product deleted from the cart")
    public void the_user_confirms_that_this_product_deleted_from_the_cart() {
        List<String> itemList = BrowserUtils.getElementsText(cartPage.activeItems);
        System.out.println("itemList = " + itemList);
        Assert.assertFalse(itemList.contains(SearchPage.selectedItemName));
    }
}
