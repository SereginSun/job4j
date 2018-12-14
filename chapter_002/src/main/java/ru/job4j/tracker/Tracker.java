package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

/**
 * класс Item
 * @author Vladimir Seregin (SereginSun@yandex.ru)
 * @version 1.0.1
 * @since 06.12.2018
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private Item[] items = new Item[100];

    private static final Random RN = new Random();
    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;
    /**
     * Метод add() реализаущий добавление заявки в хранилище
     * При добавлении генерируеться случайный id.
     * @param item новая заявка
     * @return - обьект заявки добавляемый в хранилище.
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
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
        for (int i = 0; i != this.position; i++) {
            if (item.getId().equals(id)) {
                this.items[i] = item;
                break;
            }
        }
        return false;
    }
    /**
     * Метод findById() возвращает заявку из массива по id.
     * Проверяет в цикле все элементы массива items, сравнивая id элемента с аргументом String id.
     * @param id
     * @return заявка массива items.
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : this.items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }
    /**
     * Метод delete() удаляет элемент из массива по id
     * @param id
     */
    public boolean delete(String id) {
        for (int i = 0; i != position; i++) {
            if (this.items[i].getId().equals(id)) {
                System.arraycopy(this.items, i + 1, this.items, i, items.length - 1 - i);
                position--;
                break;
            }
        }
        return false;
    }
    /**
     * Метод findAll() возвращает список всех заявок.
     * @return - список всех заявок.
     */
    public Item[] findAll() {
        return Arrays.copyOf(this.items, this.position);
    }
    /**
     * Метод findByName() возвращает список заявок по имени.
     * @return массив.
     */
    public Item[] findByName(String name) {
        int count = 0;
        Item[] namedItem = new Item[position];
        for (Item item: items) {
            if (item != null && item.getName().equals(name)) {
                namedItem[count] = item;
                count++;
            }
        }
        return Arrays.copyOf(namedItem, count);
    }
}