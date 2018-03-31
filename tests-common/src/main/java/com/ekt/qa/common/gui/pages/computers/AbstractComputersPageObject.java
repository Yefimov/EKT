package com.ekt.qa.common.gui.pages.computers;

import com.ekt.qa.common.gui.pages.AbstractPageObject;

public abstract class AbstractComputersPageObject extends AbstractPageObject {

    public abstract void isOpen();

    @Override
    protected abstract String getPAGE_URL();

    @Override
    protected abstract String getPAGE_NAME();
}