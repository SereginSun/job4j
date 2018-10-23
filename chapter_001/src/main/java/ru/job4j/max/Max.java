package ru.job4j.max;
/**
 * @author Vladimir Seregin (SereginSun@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Max {
    /**
     * Метод max возвращает максимальное число из first и second
     * @param first первое значение
     * @param second второе значение
     * @return максимальное значение
     */
    public int max(int first, int second){
        return first < second ? second : first;
    }

    /**
     * Метод summation сумму двух значений
     * @param first первое значение
     * @param second второе значение
     * @return сумма
     */
    public int summation(int first, int second){
        return first + second;
    }
    public int max(int first, int second, int third) {
        return this.max(this.max(first, second), third);
    }

}

