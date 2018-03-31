package com.ekt.qa.common.gui.tests.computers;

import com.ekt.qa.common.gui.ScreenListener;
import com.ekt.qa.common.gui.annotations.TestCaseID;
import com.ekt.qa.common.gui.pages.computers.TabletsPageObject;
import com.ekt.qa.common.gui.tests.AbstractTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ScreenListener.class})
public class TabletsTest extends AbstractTest {
    @BeforeMethod
    public void openPage() {
        new TabletsPageObject().open();
        new TabletsPageObject().isOpen();
    }

    @DataProvider(name = "priceMax")
    public Object[] priceMax() {
        return new Object[]{
                "10000",
                "20000"
        };
    }

    @Test(description = "Checking the price range", dataProvider = "priceMax")
    @TestCaseID("3101")
    public void priceRangeTest(String priceMax) {
        TabletsPageObject tables = new TabletsPageObject();

        Assert.assertTrue(tables.isFilterTableExists());
        tables.sendMaxPrice(priceMax);
        tables.pressSearchButton();
        Assert.assertTrue(tables.isResultTableExists());
        tables.checkMaxPrice(priceMax);
    }
}