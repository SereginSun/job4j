package ru.job4j.tracker;

/**
 * класс Item
 * @author Vladimir Seregin (SereginSun@yandex.ru)
 * @version 1.0.1
 * @since 06.12.2018
 */
public class Item {

    private String id;
    private String name;
    private String description;
    private long create;
    private String[] comment;

    public Item(String name, String desc) {
    }

    public Item(String name, String description, long create) {
        this.name = name;
        this.description = description;
        this.create = create;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getCreate() {
        return this.create;
    }

    public void setCreate(long create) {
        this.create = create;
    }

    public String[] getComment() {
        return this.comment;
    }
    public void setComment(String[] comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return String.format("ID: %s, Название: %s, Описание: %s",
                getId(), getName(), getDescription()
        );
    }
}