package ru.job4j.gc.cache;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SoftCachedProcessorTest {

    @Test
    public void whenGetNamesFromCache() {
        SoftCachedProcessor cache = new SoftCachedProcessor("./src/main/resources");
        String result = cache.getValue("Names.txt");
        String expected = "Arnold" + System.lineSeparator()
                + "John" + System.lineSeparator()
                + "Vladimir" + System.lineSeparator();
        assertThat(result, is(expected));
    }

    @Test
    public void whenGetAddressesFromCache() {
        SoftCachedProcessor cache = new SoftCachedProcessor("./src/main/resources");
        String result = cache.getValue("Address.txt");
        String expected = "Moscow" + System.lineSeparator()
                + "St.Petersburg" + System.lineSeparator()
                + "Voronezh" + System.lineSeparator();
        assertThat(result, is(expected));
    }
}