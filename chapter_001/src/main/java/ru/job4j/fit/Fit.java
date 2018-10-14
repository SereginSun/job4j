package ru.job4j.fit;

/**
 * Fit
 *
 * программа расчёта идеального веса.
 * @author Vladimir Seregin (SereginSun@yandex.ru)
 *
 * @version 1.0.1
 *
 * @since 13.10.2018
 */
public class Fit {
    /**
     * menWeight - метод расчитывающий идеальный вес для мужчины.
     *
     * @param height рост.
     * @return идеальный вес.
     */
    public double manWeight(double height) {
        return (height - 100) * 1.15;
    }

    /**
     * womanWright - метод расчитывающий идеальный вес для женщины.
     *
     * @param height рост.
     * @return идеальный вес.
     */
    public double womanWeight(double height) {
        return (height - 110) * 1.15;
    }
}
