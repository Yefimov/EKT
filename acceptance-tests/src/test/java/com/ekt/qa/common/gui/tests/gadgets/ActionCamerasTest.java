package com.ekt.qa.common.gui.tests.gadgets;

import com.ekt.qa.common.gui.annotations.TestCaseID;
import com.ekt.qa.common.gui.pages.gadgets.ActionCamerasPageObject;
import com.ekt.qa.common.gui.pages.main.ItemPageObject;
import com.ekt.qa.common.gui.pages.main.MyMenuPageObject;
import com.ekt.qa.common.gui.tests.AbstractTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionCamerasTest extends AbstractTest {
    @BeforeMethod
    public void openPage() {
        new ActionCamerasPageObject().open();
        new ActionCamerasPageObject().isOpen();
    }

    @Test(description = "Checking the bookmarks")
    @TestCaseID("3101")
    public void bookMarksTest() {
        ActionCamerasPageObject actionCameras = new ActionCamerasPageObject();
        ItemPageObject item = new ItemPageObject();
        MyMenuPageObject myMenu = new MyMenuPageObject();

        String brandToFind = "Sony";
        String filterToChoose = "NFC-чип";
        String cameraToFind = "Sony HDR-AZ1VW";

        Assert.assertTrue(actionCameras.isFilterTableExists());
        actionCameras.selectFilter(brandToFind);
        actionCameras.selectFilter("дисплей");
        actionCameras.selectFilter(filterToChoose);
        actionCameras.pressSearchButton();
        Assert.assertTrue(actionCameras.isResultTableExists());
        actionCameras.openItemInfo(cameraToFind);
        item.addBookMark();
        myMenu.open();
        myMenu.checkBookMark(cameraToFind);
        myMenu.checkHistory(cameraToFind);
    }

    //@AfterTest
    @AfterMethod
    public void cleanUp() {
        ItemPageObject item = new ItemPageObject();

        item.open();
        item.deleteBookMark();
    }
}