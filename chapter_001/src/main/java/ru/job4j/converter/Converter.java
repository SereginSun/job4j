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
   /**
     * Конвертируем рубли в евро
     * @param value рубли
     * @return евро
     */
    public int rubleToEuro(int value) {
        return value / 70;
    }
    /**
     * Конвертируем рубли в доллары
     * @param value рубли
     * @return доллары
     */
    public  int rubleToDollar(int value) {
        return value / 60;
    }
    /**
     * Конвертируем евро в рубли
     * @param euro евро
     * @return рубли
     */
    public int euroToRuble(int euro) {
        return euro * 70;
    }
    /**
     * Конвертируем доллары в рубли
     * @param dollar доллары
     * @return рубли
     */
    public int dollarToRuble(int dollar) {
        return dollar * 60;
    }
}
