package com.amazon.pages;

import io.cucumber.java.en_lol.WEN;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailPage extends BasePage{

    @FindBy(id = "add-to-cart-button")
    public WebElement addToCartButton;

    @FindBy(id = "attach-accessory-cart-total-string")
    public WebElement cartSubTotal;

    @FindBy (id = "attach-sidesheet-view-cart-button")
    public WebElement cartButton;

}
