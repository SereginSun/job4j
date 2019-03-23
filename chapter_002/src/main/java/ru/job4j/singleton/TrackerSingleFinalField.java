package ru.job4j.singleton;

/**
 * @author Vladimir Seregin (SereginSun@yandex.ru)
 * @version $Id$
 * @since 25.01.2019
 */
public class TrackerSingleFinalField extends TrackerSingleAbstract {

    private static final TrackerSingleFinalField INSTANCE = new TrackerSingleFinalField();

    private TrackerSingleFinalField() {
    }

    public static TrackerSingleFinalField getInstance(){
        return INSTANCE;
    }
}
