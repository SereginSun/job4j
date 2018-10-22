package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.*;

public class TriangleTest {
    @Test
    public void whenAreaSetThreePointsThenTriangleArea() {
        // Создаём три объекта класса Point.
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        Point c = new Point(2, 0);
        // Создаём объект треугольник и передаём в него объекты точек.
        Triangle triangle = new Triangle(a, b, c);
        // Вычисляем площадь.
        double result = triangle.area();
        // Задаём ожидамый результат.
        double expected = 2D;
        // Проверяем результат и ожидаемое значение.
        assertThat(result, closeTo(expected, 0.1));
    }
}