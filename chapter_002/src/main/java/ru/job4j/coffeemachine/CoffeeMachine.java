package ru.job4j.coffeemachine;

import java.util.Arrays;

/**
 * класс CoffeeMachine, реализующий метод выдачи сдачи для автомата
 * @author Vladimir Seregin (SereginSun@yandex.ru)
 * @version $Id$
 * @since 11.03.2019
 */
public class CoffeeMachine {
    private int[] smallChange = new int[100];
    private int[] coins = {10, 5, 2, 1};

    /**
     * метод changes реализует выдачу сдачи минимальным количеством монет
     * @param value - купюра покупателя кофе, 50 руб., 100 руб. и т.д.
     * @param price - цена кофе
     * @return массив монет
     */
    public int[] changes (int value, int price) {
        int change = value - price;
        int count = 0;
         for (int i = 0; i < 4;) {
             int quotient = change / coins[i];
             if (quotient >= 1) {
                //
                 // for (int j = 0; j < quotient; j++)
                 int j = 0;
                 while (j < quotient){
                     if (change - coins[i] >= 0) {
                         change -= coins[i];
                         smallChange[count] = coins[i];
                         count++;
                     } else i++;
                     j++;
                 }
             } else i++;
         }
        return Arrays.copyOf(smallChange, count);
    }
}
