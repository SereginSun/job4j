package ru.job4j.design.menu;

/**
 * interface IAction.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 31.07.2020
 */
public interface IAction {

    /**
     * Adds an item to the menu.
     * @param item - new menu item.
     */
    void add(Item item);

    /**
     * Searches for a menu item by its name.
     * @param name - the name of the selected menu item.
     * @return true if the selected menu item there is in set of titles; false otherwise.
     */
    boolean findBy(String name);

    /**
     * Deletes a menu item by its name.
     * @param name - the name of the menu item to be deleted.
     * @return true if the selected menu item is in the title set and has been deleted; false otherwise.
     */
    boolean delete(String name);
}
