package ru.job4j.search;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test for class PhoneDictionary
 * @author Vladimir Seregin (SereginSun@yandex.ru)
 * @version $Id$
 * @since 14.03.2019
 */
public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        var phones = new PhoneDictionary();
        phones.add(new Person("Vladimir", "Seregin", "2770789", "Voronezh"));
        var persons = phones.find("Vlad");
        assertThat(persons.iterator().next().getSurname(), is("Seregin"));
    }

    @Test
    public void whenFindByAddress() {
        var phones = new PhoneDictionary();
        phones.add(new Person("Kirill", "Kovnin", "2422081", "Podolsk"));
        var persons = phones.find("Pod");
        assertThat(persons.iterator().next().getSurname(), is("Kovnin"));
    }
}