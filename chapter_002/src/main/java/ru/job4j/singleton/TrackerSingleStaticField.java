package ru.job4j.singleton;

/**
 * @author Vladimir Seregin (SereginSun@yandex.ru)
 * @version $Id$
 * @since 25.01.2019
 */
public class TrackerSingleStaticField extends TrackerSingleAbstract {

    private static TrackerSingleStaticField instance;

    private TrackerSingleStaticField() {
    }

    public static TrackerSingleStaticField getInstance() {
        if(instance == null) {
            instance = new TrackerSingleStaticField();
        }
        return instance;
    }
}
