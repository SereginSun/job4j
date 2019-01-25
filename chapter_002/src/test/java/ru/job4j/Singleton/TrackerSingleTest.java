package ru.job4j.Singleton;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Vladimir Seregin (SereginSun@yandex.ru)
 * @version $Id$
 * @since 25.01.2019
 */
public class TrackerSingleTest {

    @Test
    public void whenCreateObjectFirst() {
        TrackerSingleEnum trackerFirst = TrackerSingleEnum.INSTANCE;
        TrackerSingleEnum trackerSecond = TrackerSingleEnum.INSTANCE;
        assertThat(trackerFirst, is(trackerSecond));
    }

    @Test
    public void whenCreateObjectSecond() {
        TrackerSingleStaticField trackerFirst = TrackerSingleStaticField.getInstance();
        TrackerSingleStaticField trackerSecond = TrackerSingleStaticField.getInstance();
        assertThat(trackerFirst, is(trackerSecond));
    }

    @Test
    public void whenCreateObjectTherd() {
        TrackerSingleFinalField trackerFirst = TrackerSingleFinalField.getInstance();
        TrackerSingleFinalField trackerSecond = TrackerSingleFinalField.getInstance();
        assertThat(trackerFirst, is(trackerSecond));
    }

    @Test
    public void whenCreateObjectFourth() {
        TrackerSingleFinalClass trackerFirst = TrackerSingleFinalClass.getInstance();
        TrackerSingleFinalClass trackerSecond = TrackerSingleFinalClass.getInstance();
        assertThat(trackerFirst, is(trackerSecond));
    }

}