package com.ekt.qa.common.gui.pages.main;

import com.ekt.qa.common.gui.pages.AbstractPageObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyMenuPageObject extends AbstractPageObject {
    private final Logger log = LogManager.getLogger(this.getClass());

    private final String itmBookmarksXPath = "//*[@name='wu-bookmarks']/following::*[@class='user-history-item']";
    private final String itmStoryXPath = "//*[@name='wu-bookmarks']/following::*[@class='user-history-item']";
    @FindBy(xpath = ".//*[@class='user-menu-title']")
    WebElement lblMyMenu;
    @FindBy(xpath = itmBookmarksXPath)
    WebElement itmBookmarks;
    @FindBy(xpath = itmStoryXPath)
    WebElement itmStory;

    @Override
    protected String getPAGE_URL() {
        return "ek-wu.php?idwu_=fppjutgmvvg&view_=user";
    }

    @Override
    protected String getPAGE_NAME() {
        return "My Menu";
    }

    /**
     * Check that My Menu is opened.
     */
    public void isOpen() {
        isOpen("Мое Меню", lblMyMenu);
    }

    public void checkBookMark(String bookMarkName) {
        log.info("Checking bookmark " + bookMarkName);
        WebElement itemName = webdriverHelper.getElementFromXpath(itmBookmarksXPath + "//*[text()='" + bookMarkName + "']");
        org.testng.Assert.assertEquals(itemName.getText(), bookMarkName);
    }

    public void checkHistory(String itemStoryName) {
        log.info("Checking history " + itemStoryName);
        WebElement itemName = webdriverHelper.getElementFromXpath(itmStoryXPath + "//*[text()='" + itemStoryName + "']");
        org.testng.Assert.assertEquals(itemName.getText(), itemStoryName);
    }
}
