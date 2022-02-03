package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailPage extends BasePage{

    @FindBy(id = "add-to-cart-button")
    public WebElement addToCartButton;

    @FindBy(xpath = "//span[contains(text(), 'Cart subtotal')]")
    public WebElement cartSubTotal;

    @FindBy (id = "attach-sidesheet-view-cart-button")
    public WebElement cartButton;

}
