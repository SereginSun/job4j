package ru.job4j.search;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Test for class PhoneDictionary
 * @author Vladimir Seregin (SereginSun@yandex.ru)
 * @version $Id$
 * @since 14.03.2019
 */
public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person("Vladimir", "Seregin", "2770789", "Voronezh"));
        List<Person> persons = phones.find("Vlad");
        assertThat(persons.iterator().next().getSurname(), is("Seregin"));
    }

    @Test
    public void whenFindByAddress() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person("Kirill", "Kovnin", "2422081", "Podolsk"));
        List<Person> persons = phones.find("Pod");
        assertThat(persons.iterator().next().getSurname(), is("Kovnin"));
    }
}