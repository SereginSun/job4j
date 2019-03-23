package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

/**
 * класс MenuTracker
 * @author Vladimir Seregin (SereginSun@yandex.ru)
 * @version 1.0.1
 * @since 06.01.2019
 */

public class MenuTracker {

    /**
     * input хранит ссылку на объект.
     */
    private Input input;

    /**
     * tracker хранит ссылку на объект.
     */
    private Tracker tracker;

    /**
     * хранит ссылку на объект типа UserAction.
     */
    private List<UserAction> actions = new ArrayList<>();

    /**
     * Конструктор.
     *
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Метод для получения массива меню.
     *
     * @return длину массива
     */
    public int getActionsLength() {
        return this.actions.size();
    }

    /**
     * Метод заполняет массив.
     */
    public void fillActions() {
        this.actions.add(new AddItem(0, "Добавить новую заявку."));
        this.actions.add(new ShowItems(1, "Показать список всех заявок."));
        this.actions.add(new UpdateItem(2, "Редактировать заявку."));
        this.actions.add(new DeleteItem(3, "Удалить заявку."));
        this.actions.add(new FindById(4, "Найти заявку по ID."));
        this.actions.add(new FindByName(5, "Найти заявку по названию."));
        this.actions.add(new ExitProgram(6, "Выход из программы."));
    }

    /**
     * Метод, в зависимости от указанного ключа, выполняет соответствующее действие.
     *
     * @param key ключ операции
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    /**
     * Метод выводит на экран меню.
     */
    public void Show() {
        for (UserAction actions : this.actions) {
            if (actions != null) {
                System.out.println(actions.info());
            }
        }
    }

    public class AddItem extends BaseAction {

        public AddItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Добавление новой заявки ------------");
            String name = input.ask("Пожалуйста, укажите имя заявки:");
            String desc = input.ask("Пожалуйста, укажите описание заявки:");
            Item item = new Item(name, desc);
            tracker.add(item);
            System.out.println("------------ Новая заявка с ID: " + item.getId());
        }
    }

    public class ShowItems extends BaseAction {

        public ShowItems(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.findAll()) {
                System.out.println(item.toString());
            }
        }
    }

    public class UpdateItem extends BaseAction {

        public UpdateItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Редактирование заявки ------------");
            String id = input.ask("Пожалуйста, введите ID заявки:");
            String name = input.ask("Пожалуйста, введите имя новой заявки:");
            String desc = input.ask("Пожалуйста, введите описание новой заявки:");
            Item item = new Item(name, desc);
            if (tracker.replace(id, item)) {
                System.out.println("Заявка отредактирована. Новое имя заявки: " + item.getName() + " " +
                        "Описание новой заявки: " + item.getDescription()
                );
            } else {
                System.out.println("Заявки с ID: " + id + " не существует.");
            }
        }
    }

    public class DeleteItem extends BaseAction {

        public DeleteItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Удаление заявки ------------");
            String id = input.ask("Пожалуйста, введите ID удаляемой заявки: ");
            if (tracker.delete(id)) {
                System.out.println("Заявка удалена!");
            } else {
                System.out.println("Заявки с ID: " + id + " не существует.");
            }
        }
    }

    public class FindById extends BaseAction {

        public FindById(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по ID ------------");
            String id = input.ask("Пожалуйста, введите ID заявки: ");
            Item item = tracker.findById(id);
            System.out.println(item);
        }
    }

    public class FindByName extends BaseAction {

        public FindByName(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по имени ------------");
            String name = input.ask("Пожалуйста, введите имя заявки: ");
            for (Item item : tracker.findByName(name)) {
                System.out.println(item);
            }
        }
    }

    public class ExitProgram extends BaseAction {

        public ExitProgram(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
        }
    }
}
