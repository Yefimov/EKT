package com.ekt.qa.common.gui.pages.gadgets;

import com.ekt.qa.common.gui.pages.AbstractPageObject;

public abstract class AbstractGadgetsPageObject extends AbstractPageObject {
    protected final String menuName = "Гаджеты для отдыха";

    public abstract void isOpen();

    @Override
    protected abstract String getPAGE_URL();

    @Override
    protected abstract String getPAGE_NAME();
}