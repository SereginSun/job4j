package ru.job4j.condition;

/**
 * Расстояние между точками  в системе координат
 *
 * @author Vladimir Seregin (SereginSun@yandex.ru)
 *
 * @version $Id$
 *
 * @since 0.1
 */
public class Point {
    /**
     * поля для инициализации точки в системе координат
     */
    private int x;
    private int y;

    /**
     * конструктор для инициализации точки в системе координат
     * @param x координата, отложенная по оси х
     * @param y координата, отложенная по оси у
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * метод distanceTo рассчитывает растояние от текущей точки до входязщей точки.
     * @param that входящая точка.
     *
     * @return растояние от текущей точки до входящей точки, рассчитаное по формуле.
     */
    public double distanceTo(Point that) {

        //Точка А - это текущая точка. К ней мы обращаемся через оператор this.
        //Point a = this;
        // Точка В - это входящая точка. К ней мы можем обратиться напрямую через имя переменной that
        // или для удобства мы создали новую переменную b и к ней присвоили переменную that.
        //Point b = that;

        //int x1 = a.x;
        //int y1 = a.y;
        //int x2 = b.x;
        //int y2 = b.y;

        return Math.sqrt(Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2));
    }

    /**
     * метод main - точка входа в программу.
     * @param args - args
     */
    public static void main(String[] args) {
        Point a = new Point(0, 1);
        Point b = new Point(2, 5);
        // Сделаем вывод на консоль.
        System.out.println("x1 = " + a.x);
        System.out.println("y1 = " + a.y);
        System.out.println("x2 = " + b.x);
        System.out.println("y2 = " + b.y);

        double result = a.distanceTo(b);
        System.out.println("Расстояние между точками А и В: " + result);
    }
}
