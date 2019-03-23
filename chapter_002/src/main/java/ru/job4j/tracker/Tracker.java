package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * класс Tracker
 * @author Vladimir Seregin (SereginSun@yandex.ru)
 * @version 1.0.1
 * @since 06.12.2018
 */
public class Tracker {

    /**
     * Массив для хранение заявок.
     */
    private List<Item> items = new ArrayList<>();

    private static final Random RN = new Random();

    /**
     * Метод add() реализаущий добавление заявки в хранилище
     * При добавлении генерируеться случайный id.
     * @param item новая заявка
     * @return - обьект заявки добавляемый в хранилище.
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items.add(item);
        return item;
    }

    /**
     * Метод generateId() генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt(100));
    }

    /**
     * Метод replace() заменяет ячейку в массиве.
     * @param id - аргумент сравниваеться с id элементов массива items.
     * @param item - новый обьект массива items который замещает найденый id.
     */
    public boolean replace(String id, Item item) {
        item.setId(id);
        for (int i = 0; i != this.items.size(); i++) {
            if (this.items.get(i).getId().equals(id)) {
                this.items.set(i, item);
                break;
            }
        }
        return false;
    }

    /**
     * Метод findById() возвращает заявку из массива по id.
     * Проверяет в цикле все элементы массива items, сравнивая id элемента с аргументом String id.
     * @param id элемента.
     * @return заявка массива items.
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     * Метод delete() удаляет элемент из массива по id
     * @param id элемента.
     */
    public boolean delete(String id) {
        for (int i = 0; i != this.items.size(); i++) {
            if (this.items.get(i).getId().equals(id)) {
                this.items.remove(i);
                break;
            }
        }
        return false;
    }

    /**
     * Метод findAll() возвращает список всех заявок.
     * @return - список всех заявок.
     */
    public List<Item> findAll() {
        return items;
    }

    /**
     * Метод findByName() возвращает список заявок по имени.
     * @return массив.
     */
    public List<Item> findByName(String name) {
        List<Item> namedItem = new ArrayList<>();
        for (Item item: items) {
            if (item != null && item.getName().equals(name)) {
                namedItem.add(item);
            }
        }
        return namedItem;
    }
}