package com.ekt.qa.common.gui.tests.main;

import com.ekt.qa.common.gui.annotations.TestCaseID;
import com.ekt.qa.common.gui.pages.AbstractPageObject;
import com.ekt.qa.common.gui.pages.computers.TabletsPageObject;
import com.ekt.qa.common.gui.pages.gadgets.ActionCamerasPageObject;
import com.ekt.qa.common.gui.tests.AbstractTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.URISyntaxException;

public class MainTest extends AbstractTest {
    @DataProvider(name = "forClick")
    public Object[] forClick() {
        return new Object[]{
                new ActionCamerasPageObject(),
                new TabletsPageObject()
        };
    }

    @Test(dataProvider = "forClick")
    @TestCaseID("2301")
    public void checkAllPagesTest(AbstractPageObject page) throws URISyntaxException {
        page.open();
        page.isOpen();
    }
}