package com.ekt.qa.common.gui.pages.gadgets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ActionCamerasPageObject extends AbstractGadgetsPageObject {
    private final Logger log = LogManager.getLogger(this.getClass());
    //<editor-folder desc="WebElements">

    @FindBy(xpath = ".//*[@class='rm-div open']")
    private WebElement tblFilter;
    @FindBy(xpath = ".//*[@id='list_form1']")
    private WebElement tblResult;
    @FindBy(xpath = ".//*[@id='resultsTable']/tbody/tr[2]/td[1]//tbody")
    private WebElement checkboxTopArticle;
    @FindBy(xpath = ".//*[@class='rm-div open']//*[text()='NFC-чип']/parent::*")
    private WebElement checkBoxNFC;
    @FindBy(xpath = ".//*[@class='show-models']")
    private WebElement btnSearch;

    //</editor-folder>

    @Override
    protected String getPAGE_URL() {
        return "k695.htm";
    }

    @Override
    protected String getPAGE_NAME() {
        return "Action камеры";
    }

    /**
     * Check that News Management page is opened.
     */
    public void isOpen() {
        isOpen("Action камеры", menuName);
    }

    /**
     * Checking that Filters Table actually exists
     *
     * @return true if page exists (Sub Title is "Action камеры")
     */
    public boolean isFilterTableExists() {
        return isExists(tblFilter, "Filter Table");
    }

    /**
     * Checking that Match Result Table actually exists
     *
     * @return true if page exists
     */
    public boolean isResultTableExists() {
        return isExists(tblResult, "Result Table");
    }

    /**
     * Selecting the filter checkbox
     *
     * @param checkBoxName Name of the checkbox to select
     */
    public void selectFilter(String checkBoxName) {
        WebElement checkBox = webdriverHelper.getElementFromXpath(".//*[@class='rm-div open']//*[text()='" + checkBoxName + "']/parent::*");
        click(checkBox, checkBoxName + " checkbox on the FilterTable");
    }

    public void selectFunction(String functionName) {
        if (functionName.contains("NFC")) {
            click(checkBoxNFC, functionName + " checkbox on the FilterTable");
        } else throw new ElementNotVisibleException("This function doesn't exists!");
    }

    /**
     * Pressing button for search by News name
     */
    public void pressSearchButton() {
        click(btnSearch, "'Search' button");
    }

    /**
     * Open Item page
     *
     * @param itemName Item Label
     */
    public void openItemInfo(String itemName) {
        WebElement checkBox = webdriverHelper.getElementFromXpath(webdriverHelper.getElementXPath(tblResult) + "//*[text()='" + itemName + "']");
        click(checkBox, itemName + " item on the ResultTable");
    }
}