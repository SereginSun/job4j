package ru.job4j.design.menu;

import java.util.Set;
import java.util.TreeSet;

/**
 * class Menu describe actions on menu items.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 31.07.2020
 */
public class Menu implements IAction, IService {
    private final Set<String> titleSet = new TreeSet<>();

    @Override
    public void add(Item item) {
        titleSet.add(item.getName());
    }

    @Override
    public boolean findBy(String name) {
        return titleSet.stream().anyMatch(point -> point.equals(name));
    }

    @Override
    public boolean delete(String name) {
        return titleSet.removeIf(point -> point.equals(name));
    }

    @Override
    public void showMenu() {
        for (String name : titleSet) {
            switch (name.length()) {
                case 4:
                    System.out.printf("%s%s%n", "---", name);
                    break;
                case 6:
                    System.out.printf("%s%s%n", "------", name);
                    break;
                default:
                    System.out.println(name);
            }
        }
    }
}
