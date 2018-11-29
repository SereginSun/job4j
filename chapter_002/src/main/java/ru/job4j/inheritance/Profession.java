package ru.job4j.inheritance;
/**
 * Profession - базовый класс
 * @author Vladimir Seregin (SereginSun@yandex.ru)
 * @version 0.0.1
 * @since 28.11.2018
 */
public class Profession {
    private String name;
    private String profession;

    /**
     * метод getName() возвращает имя при вызове его для любого класса
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * метод getProfession() возвращает название профессии при вызове его для любого класса
     * @return profession
     */
    public String getProfession() {
        return profession;
    }
}
