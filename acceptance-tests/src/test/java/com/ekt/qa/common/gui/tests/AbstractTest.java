package com.ekt.qa.common.gui.tests;

import com.ekt.qa.common.gui.ScreenListener;
import com.ekt.qa.common.gui.pages.main.MainPageObject;
import com.ekt.qa.common.gui.webdriver.BaseSelenium;
import io.qameta.allure.Attachment;
import org.testng.annotations.*;

@Listeners({ScreenListener.class})
public class AbstractTest {
    private static final String LOGIN = "ilyayefimov@maildrop.cc";
    private static final String PASSWORD = "password";
    private static final String NICKNAME = "IlyaYefimovAT";

    /**
     * Initialization of the WebDriver
     */
    @BeforeSuite
    public static void initSelenium() {
        BaseSelenium.init();
    }

    protected static void loggingIn() {
        MainPageObject mainPage = new MainPageObject();
        mainPage.open();
        mainPage.isOpen();
        mainPage.signingIn(LOGIN, PASSWORD);
        mainPage.isLogin(NICKNAME);
    }

    @AfterSuite
    public static void closeSelenium() {
        BaseSelenium.close();
    }

    @BeforeClass
    public static void login() {
        MainPageObject mainPage = new MainPageObject();
        if (!mainPage.isLoginWithoutAssert(NICKNAME)) {
            loggingIn();
        }
    }

    @AfterClass
    public static void logout() {
        MainPageObject mainPage = new MainPageObject();
        if (mainPage.isLoginWithoutAssert(NICKNAME)) {
            mainPage.logOut();
        }
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }
}