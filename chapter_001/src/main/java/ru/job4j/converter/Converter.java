package ru.job4j.converter;

/**
 * Конвертер валюты
 *
 * @author Vladimir Seregin (SereginSun@yandex.ru)
 *
 * @version 1.0.1
 *
 * @since 09.10.2018
 */
public class Converter {
    int euro;
    int dollar;
    int rubles;
    /**
     * Конвертируем рубли в евро
     * @param value рубли
     * @return euro евро
     */
    public int rubleToEuro(int value) {
        return euro = value / 70;
    }

    /**
     * Конвертируем рубли в доллары
     * @param value рубли
     * @return dollar доллары
     */
    public  int rubleToDollar(int value) {
        return dollar = value / 60;
    }

    /**
     * Конвертируем евро в рубли
     * @param euro евро
     * @return rubles рубли
     */
    public int euroToRuble(int euro) {
        return rubles = euro * 70;
    }

    /**
     * Конвертируем доллары в рубли
     * @param dollar доллары
     * @return rubles рубли
     */
    public int dollarToRuble(int dollar) {
        return rubles = dollar * 60;
    }
}
