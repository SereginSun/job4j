package ru.job4j.tracker;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * class TrackerSQLTest
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 10.12.2019
 */


public class TrackerSQLTest {

    private TrackerSQL sql;
    private List<Item> result;

    @Before
    public void setUp() {
        sql = new TrackerSQL();
        sql.init();
    }

    @Test
    public void checkConnection() {
        assertThat(sql.init(), is(true));
    }

    @Ignore
    @Test
    public void whenAddItem() {
        Item first = new Item("testNameFirst", "teatDescriptionFirst");
        sql.add(first);
        assertThat(sql.findById(first.getId()).getName(), is("testNameFirst"));
    }

    @Ignore
    @Test
    public void whenReplaceNameOfItem() {
        Item second = new Item("testNameSecond", "testDescriptionSecond");
        Item third = new Item("testNameThird", "testDescriptionThird");
        sql.add(second);
        sql.replace(second.getId(), third);
        assertThat(sql.findById(second.getId()).getName(), is("testNameThird"));
    }

    @Ignore
    @Test
    public void whenFindAllItem() {
        Item fourth = new Item("testNameFourth", "testDescriptionFourth");
        Item fifth = new Item("testNameFifth", "teatDescriptionFifth");
        sql.add(fourth);
        sql.add(fifth);
        result = sql.findAll();
        assertThat(result.get(0).getDescription(), is("testDescriptionSixth"));
    }

    @Ignore
    @Test
    public void whenFindItemByName() {
        Item sixth = new Item("testNameSixth", "testDescriptionSixth");
        sql.add(sixth);
        result = sql.findByName("testNameSixth");
        assertThat(result.get(0).getDescription(), is("testDescriptionSixth"));
    }

    @Ignore
    @Test
    public void whenFindItemById() {
        Item seventh = new Item("testNameSeventh", "testDescriptionSeventh");
        Item eighth = new Item("testNameEighth", "testDescriptionEighth");
        sql.add(seventh);
        sql.add(eighth);
        assertThat(sql.findById(seventh.getId()).getDescription(), is("testDescriptionSeventh"));
    }
}