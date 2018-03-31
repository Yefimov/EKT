package com.ekt.qa.common.gui.pages.computers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TabletsPageObject extends AbstractComputersPageObject {
    private final Logger log = LogManager.getLogger(this.getClass());
    //<editor-folder desc="WebElements">

    @FindBy(xpath = ".//*[@class='h1 ib']")
    private WebElement lblTitle;
    @FindBy(xpath = ".//*[@class='rm-div open']")
    private WebElement tblFilter;
    @FindBy(xpath = ".//*[@id='list_form1']")
    private WebElement tblResult;
    @FindBy(xpath = "//input[@id='maxPrice_']")
    private WebElement inputMaxPrice;
    @FindBy(xpath = ".//*[@class='show-models']")
    private WebElement btnSearch;

    //</editor-folder>

    @Override
    protected String getPAGE_URL() {
        return "k30.htm";
    }

    @Override
    protected String getPAGE_NAME() {
        return "Планшеты";
    }

    /**
     * Check that News Management page is opened.
     */
    public void isOpen() {
        isOpen("Планшеты ", lblTitle);
    }

    /**
     * Checking that Filters Table actually exists
     *
     * @return true if page exists (Sub Title is "Action камеры")
     */
    public boolean isFilterTableExists() {
        return isExists(tblFilter, "Filter Table");
    }

    public void sendMaxPrice(String priceMax) {
        sendKeys(inputMaxPrice, priceMax, "'Max price' input field");
    }

    /**
     * Pressing button for search by News name
     */
    public void pressSearchButton() {
        click(btnSearch, "'Search' button");
    }

    /**
     * Checking that Match Result Table actually exists
     *
     * @return true if page exists
     */
    public boolean isResultTableExists() {
        return isExists(tblResult, "Result Table");
    }

    public void checkMaxPrice(String price) {
        log.info("Checking that all prices are not higher than " + price);
        for (int priceNumber = 1; priceNumber < 25; priceNumber++) {
            log.debug("Check number " + priceNumber);
            WebElement priceFrom = webdriverHelper.getElementFromXpath(".//*[@id='list_form1']/div[" + priceNumber + "]//div[@class='model-price-range']//span");
            int priceFromWithoutSpaces = Integer.parseInt(priceFrom.getText().replaceAll("\\s+", ""));
            log.debug("Is " + price + " smaller than " + priceFromWithoutSpaces);
            org.testng.Assert.assertFalse(priceFromWithoutSpaces > Integer.parseInt(price));
        }
    }
}