package ru.job4j.design.tictactoe;

/**
 * abstract class MenuEntry.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version 1.1
 * @since 06.10.2020
 */
public abstract class MenuEntry {
    private final int key;
    private final String title;

    public MenuEntry(int key, String title) {
        this.title = title;
        this.key = key;
    }

    /**
     * Method for starting a menu item.
     */
    public abstract void run();

    @Override
    public String toString() {
        return "-=" + key + "   " + title;
    }
}
