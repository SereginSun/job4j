package ru.job4j.pseudo;

/**
 * @author Seregin Vladimir (SereginSun@yandex.ru);
 * @version $Id$
 * @since 0.1
 */
public class Paint {
    public void draw (Shape shape) {
        System.out.println(shape.draw());
    }

    public static void main (String[] args) {
        Paint paint = new Paint();
        Triangle triangle = new Triangle();
        Square square = new Square();
        paint.draw(triangle);
        paint.draw(square);
    }
}
