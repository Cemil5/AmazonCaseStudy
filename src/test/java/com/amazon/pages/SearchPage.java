package com.amazon.pages;

import com.amazon.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends MainPage{

    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchBox;

    @FindBy(id = "nav-search-submit-button")
    public WebElement searchButton;

    public List<WebElement> searchResult(String itemName){
        String path = "//div[@class = 's-main-slot s-result-list s-search-results sg-row']//span[contains(text()," +
                "'"+ itemName+ "')]";
        return Driver.get().findElements(By.xpath(path));
    }

    @FindBy(xpath = "//span[@class = 's-pagination-strip']/a[text() = '2']")
    public WebElement secondPage;

    @FindBy(xpath = "//span[contains(text(),'results for')]")
    public WebElement confirmingSecondPage;

    public static String selectedItemName;

    public WebElement selectDesiredItem(int index){
        String path = "//div[@class = 's-main-slot s-result-list s-search-results sg-row']/div[@data-cel-widget='search_result_"+index+"']";
        String pathItemName = path + "//span[@class='a-size-medium a-color-base a-text-normal']";
        String pathToClick = path + "//h2/a";
        selectedItemName = Driver.get().findElement(By.xpath(pathItemName)).getText();
        System.out.println("selectedItemName = " + selectedItemName);
        return Driver.get().findElement(By.xpath(pathToClick));
    }

}
