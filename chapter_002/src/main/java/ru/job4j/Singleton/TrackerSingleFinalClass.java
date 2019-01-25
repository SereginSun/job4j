package ru.job4j.Singleton;

public class TrackerSingleFinalClass extends TrackerSingleAbstract {

    private TrackerSingleFinalClass() {
    }

    public static TrackerSingleFinalClass getInstance() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        private static final TrackerSingleFinalClass INSTANCE = new TrackerSingleFinalClass();
    }
}
