package com.ekt.qa.common.gui.pages.main;

import com.ekt.qa.common.gui.pages.AbstractPageObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPageObject extends AbstractPageObject {
    private final Logger log = LogManager.getLogger(this.getClass());
    @FindBy(xpath = ".//*[@id=\"mui_user_login_row\"]/span")
    private WebElement lblLogin;

    //<editor-folder desc="WebElements">
    @FindBy(xpath = ".//*[@id='mui_user_login_window_avt']/input")
    private WebElement inputLogin;
    @FindBy(xpath = ".//*[@id='mui_user_login_window_avt']/div[1]/input")
    private WebElement inputPassword;
    @FindBy(xpath = ".//*[@id='mui_user_login_window_avt']/div[3]/input")
    private WebElement btnLogin;

    @Override
    protected String getPAGE_URL() {
        return "";
    }

    //</editor-folder>

    @Override
    protected String getPAGE_NAME() {
        return "Main Page";
    }

    /**
     * Check that Main page is opened.
     */
    public void isOpen() {
        isOpen("Войти", lblLogin);
    }

    public void open() {
        log.info("Opening the " + getPAGE_NAME());
        webdriverHelper.open(getPAGE_URL());
    }

    public void signingIn(String login, String password) {
        click(lblLogin, "'Войти' button");
        sendKeys(inputLogin, login, "'Login'");
        sendKeys(inputPassword, password, "'Password'");
        click(btnLogin, "'Login' button");
    }

    /**
     * Get the element with special text in the Headline News Table
     *
     * @param text What to look for
     * @return Headline News Table element with the specific text
     */
    public WebElement findElementInHeadlineNewsTable(String text) {
        log.info("Find element with text '" + text + "' in the Headline News table on the main page");
        return webdriverHelper.getElementFromXpath(".//*[@class='mainheader fromdivpadding']//*[text()=' " + text + " ']");
    }

    /**
     * Check that this element does't exists in the Headline News Table on the Main page
     *
     * @param value What to look for
     * @return Headline News Table element status (true if exists)
     */
    public boolean isSpecificArticleFromHeadlineNewsTableExists(String value) {
        log.info("Checking if article '" + value + "' exists on the " + getPAGE_NAME());
        return isExists(".//*[@class='mainheader fromdivpadding']//*[text()=' " + value + " ']", value);
    }
}
