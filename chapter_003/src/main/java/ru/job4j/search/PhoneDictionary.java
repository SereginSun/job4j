package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;

/**
 * class PhoneDictionary is a directory model
 * @author Vladimir Seregin (SereginSun@yandex.ru)
 * @version $Id$
 * @since 14.03.2019
 */
public class PhoneDictionary {
    private List<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * return a list of all users that contain key in any fields
     * @param key search key
     * @return list of relevant users
     */
    public List<Person> find(String key) {
        List<Person> result = new ArrayList<>();
        for (Person person : this.persons) {
            if (person.getName().contains(key) || person.getSurname().contains(key) || person.getPhone().contains(key)
                    || person.getAddress().contains(key)) {
                result.add(person);
            }
        }
        return result;
    }
}
