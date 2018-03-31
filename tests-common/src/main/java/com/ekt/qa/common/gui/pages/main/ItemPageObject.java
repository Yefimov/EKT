package com.ekt.qa.common.gui.pages.main;

import com.ekt.qa.common.gui.pages.AbstractPageObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItemPageObject extends AbstractPageObject {
    private final Logger log = LogManager.getLogger(this.getClass());
    @FindBy(xpath = ".//*[@class='big-star-off off']")
    WebElement btnBookMarkAdd;
    @FindBy(xpath = ".//*[@class='big-star-on on']")
    WebElement btnBookMarkDelete;
    @FindBy(xpath = ".//*[@class='desc-menu']/*[text()='Описание']")
    WebElement btnDescription;

    @Override
    protected String getPAGE_URL() {
        return "SONY-HDR-AZ1VW.htm";
    }

    @Override
    protected String getPAGE_NAME() {
        return "Товар";
    }

    /**
     * Check that Item is opened.
     */
    @Override
    public void isOpen() {
        isOpen("Описание", btnDescription);
    }

    /**
     * Click Add Bookmark (set on)
     */
    public void addBookMark() {
        log.info("Add Bookmark");
        if (isExists(btnBookMarkDelete, "'Delete Bookmark' button")) {
            click(btnBookMarkDelete, "'Delete Bookmark' button");
        }
        click(btnBookMarkAdd, "'Add Bookmark' button");
    }

    public void deleteBookMark() {
        log.info("Delete Bookmark");
        if (isExists(btnBookMarkAdd, "'Add Bookmark' button")) {
            click(btnBookMarkAdd, "'Add Bookmark' button");
        }
        click(btnBookMarkDelete, "'Delete Bookmark' button");
    }
}
