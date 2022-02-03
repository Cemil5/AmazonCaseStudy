package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage{

    @FindBy(xpath = "//div[@data-name='Active Items']//span[@class='a-truncate-full a-offscreen']")
    public List<WebElement> activeItems;

    @FindBy(xpath = "//div[@data-name='Active Items']//input[@value = 'Delete']")
    public List<WebElement> deleteButtons;



}
