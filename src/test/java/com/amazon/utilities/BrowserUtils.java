package com.amazon.utilities;

import org.openqa.selenium.*;

import java.util.ArrayList;
import java.util.List;


public class BrowserUtils {

    /**
     * return a list of string from a list of elements
     *
     * param list of webelements
     * return list of string
     */
    public static List<String> getElementsText(List<WebElement> list) {
        List<String> elemTexts = new ArrayList<>();
        for (WebElement el : list) {
            elemTexts.add(el.getText());
        }
        return elemTexts;
    }


    /**
     * Performs a pause
     *
     * param seconds
     */
    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}