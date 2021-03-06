package ru.job4j.condition;

public class Triangle {
    private Point a;
    private Point b;
    private Point c;
    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    /**
     * Метод вычисления полупериметра по длинам сторон
     *
     * Формула
     *
     * (ab + ac + bc)/2;
     *
     * @param ab расстояние между точками a b;
     * @param ac расстояние между точками a c;
     * @param bc расстояние между точками d c;
     * @return периметр;
     */
    public double period(double ab, double ac, double bc) {
        return (ab + ac + bc) / 2;
    }
    /**
     * Метод должен вычислять площадь треугольника.
     *
     * @return Вернуть площадь, если треугольник существует или -1, если треугольника нет.
     */
    public double area() {
        double result = -1;
        double ab = this.a.distanceTo(this.b);
        double ac = this.a.distanceTo(this.c);
        double bc = this.b.distanceTo(this.c);
        double p = this.period(ab, ac, bc);
        if (this.exist(ab, bc, ac)) {
            result = Math.sqrt(p * (p - ab) * (p - ac) * (p - bc));
        }
        return result;
    }
    /**
     * Метод проверяет можно ли построить треугольник с такими длинами сторон.
     *
     * @param ab Длина от точки a b.
     * @param ac Длина от точки a c.
     * @param bc Длина от точки b c.
     * @return false.
     */
    private boolean exist(double ab, double ac, double bc) {
        return (ab < bc + ac) && (ac < ab + bc) && (bc < ab + ac);
    }
}
