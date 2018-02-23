package com.ex8.site.header;

import com.epam.jdi.uitests.web.selenium.elements.complex.Menu;
import com.ex8.enums.MenuEnum;

public class HeaderMenu extends Menu<MenuEnum> {
    public void selectMenu(MenuEnum menuEnum) {
        select(menuEnum.menu);
    }
}