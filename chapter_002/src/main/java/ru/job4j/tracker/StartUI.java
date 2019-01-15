package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.lang.String;

/**
 *класс StartUI
 * @author Vladimir Seregin (SereginSun@yandex.ru)
 * @version 1.0.2
 * @since 14.12.2018
 */

public class StartUI {
    /**
     * Констатнта меню для добавления новой заявки.
     */
    private static final String ADD = "0";

    /**
     * Константа для вывода списка заявок
     */
    private static final String FIND_ALL = "1";

    /**
     * Константа для редактирования заявки
     */
    private static final String REPLACE = "2";

    /**
     * Константа для удаления заявки
     */
    private static final String DELETE = "3";

    /**
     * Константа для вызова заявки по ID
     */
    public static final String FIND_BY_ID = "4";

    /**
     * кОНСТАНТА ДЛЯ ВЫЗОВА ЗАЯВКИ ПО НАЗВАНИЮ
     */
    public static final String FIND_BY_NAME = "5";

    /**
     * Констата для выхода из цикла.
     */
    private static final String EXIT = "6";

    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * хранилище заявок
     */
    private final Tracker tracker;

    /**
     * Конструктор инициализирующий поля.
     * @param input;
     * @param tracker хранилище заявок
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основной цикл программы
     */
    public void init() {
        //String s;
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        List<Integer> range = new ArrayList<>();
        menu.fillActions();
        for (int i = 0; i < menu.getActionsLength(); i++) {
            range.add(i);
        }
        do {
            menu.Show();
            menu.select(input.ask("Введите пункт меню: ", range));
        } while (!"да".equals(this.input.ask("Выход? (да): ")));
    }

        /*boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню: ");
            if (ADD.equals(answer)) {
                // добавление заявки вынесено в отдельный метод
                this.createItem();
            } else if (FIND_ALL.equals(answer)) {
                // Добавить остальные действия системы по меню.
                this.findAllItem();
            } else if (REPLACE.equals(answer)) {
                this.replaceItem();
            } else if (DELETE.equals(answer)) {
                this.deleteItem();
            } else if (FIND_BY_ID.equals(answer)) {
                this.findItemById();
            } else if (FIND_BY_NAME.equals(answer)) {
                this.findItemByName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    /**
     * Метод createItem() реализует добавление новой заявки в хранилище.
     */
 /*   private void createItem() {
        System.out.println("------------ Добавление новой заявки ------------");
        String name = this.input.ask("Введите номер завявки: ");
        String description = this.input.ask("Введите описание заявки: ");
        Item item = new Item(name, description, 123L);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getID: " + item.getId() + "------------");
    }
*/
        /**
         * Метод findAllItem() выводит список всех заявок
         */
  /*  private void findAllItem() {
        System.out.println("------------ Список всех заявок ------------");
        Item[] items = this.tracker.findAll();
        for (Item item: items) {
            System.out.println("Название заявки: " + item.getName() + " Описание завки: " + item.getDescription());
        }
    }
*/
        /**
         * Метод replaceItem() редактирует заявку, выбранную по введённому пользовыателем ID
         */
  /*  private void replaceItem() {
        System.out.println("------------ Редактирование заявки ------------");
        String id = this.input.ask("Введите ID редактируемой заявки: ");
        String name = this.input.ask("Введите название новой заявки: ");
        String description = this.input.ask("Введите описание новой заявки: ");
        Item item = new Item(name, description, 123L);
        if (this.tracker.replace(id, item)) {
            System.out.println("Заявка отредактирована. Новое имя заявки: " + item.getName() + " " + "Описание новой заявки: " + item.getDescription());
        } else {
            System.out.println("Заявки с ID: " + id + "не существует.");
        }
    }
*/
        /**
         * Метод deleteItem() удаляет заявку по введённому ID
         */
/*    private void deleteItem() {
        System.out.println("------------ Удаление заявки ------------");
        String id = this.input.ask("Введите ID заявки: ");
        if (this.tracker.delete(id)) {
            System.out.println("Заявка удалена!");
        } else {
            System.out.println("Такой заявки не существует!");
        }
    }
*/
        /**
         * Метод findItemById() ищет заявку по ID
         */
    /*private void findItemById() {
        System.out.println("------------ Поиск заявки по ID ------------");
        String id = this.input.ask("Введите ID заявки: ");
        Item item = this.tracker.findById(id);
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("Такой заявки не существует!");
        }
    }*/
/*
    /**
     * Метод findItemByName() ищет заявку по имени
     */
 /*   private void findItemByName() {
        System.out.println("------------ Поиск заявки по имени ------------");
        String name = this.input.ask("Введите имя заявки: ");
        Item[] item = this.tracker.findByName(name);
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("Такой заявки не существует!");
        }
    }*/
/*
    private void showMenu() {
        System.out.println("Меню.");
        // добавить остальные пункты меню.
        System.out.println("0. Добавить новую заявку.");
        System.out.println("1. Показать список всех заявок.");
        System.out.println("2. Редактировать заявку.");
        System.out.println("3. Удалить заявку.");
        System.out.println("4. Найти заявку по ID.");
        System.out.println("5. Найти заявку по названию.");
        System.out.println("6. Выход из программы.");
    }
    */
        /**
         * Запуск программы
         * @param args
         */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(), new Tracker()).init();
    }
}

