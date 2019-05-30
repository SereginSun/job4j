package ru.job4j.stream;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * class StreamAPITest.
 *
 * @author Vladimir Seregin (SereginSun@yandex.ru)
 * @version $Id$
 * @since 30.05.2019
 */
public class StreamAPITest {

    @Test
    public void whenSqueredOfEvenNumbersOfArrayAreSummedThen() {
        int[] result = {1, 2, 3, 4, 5, 11, 12, 13, 14, 15};
        assertThat(new StreamAPI().streamOperations(result), is(360));
    }

}