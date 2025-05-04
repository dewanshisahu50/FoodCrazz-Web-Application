package com.tap.dao;

import java.util.List;
import com.tap.model.Menu;

public interface MenuDao {
    void addMenu(Menu menu);
    void updateMenu(Menu menu);
    void deleteMenu(int menuId);
    Menu getMenuById(int menuId);
    List<Menu> getAllMenus(int menuId);
}
