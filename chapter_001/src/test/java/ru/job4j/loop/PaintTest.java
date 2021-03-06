package ru.job4j.loop;

import org.junit.Test;

import java.util.StringJoiner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version 0.1
 * @since 28.10.2018
 */
public class PaintTest {
    @Test
    public void whenPyramid4Right() {
        Paint image = new Paint();
        String rst = image.rightTrl(4);
        System.out.println(rst);
        assertThat(rst, is(new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                                        .add("^   ")
                                        .add("^^  ")
                                        .add("^^^ ")
                                        .add("^^^^")
                                        .toString()));
    }
    @Test
    public void whenPyramid4Left() {
        Paint image = new Paint();
        String rst = image.leftTrl(4);
        System.out.println(rst);
        assertThat(rst, is(new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                                        .add("   ^")
                                        .add("  ^^")
                                        .add(" ^^^")
                                        .add("^^^^")
                                        .toString()));
    }
    @Test
    public void forPyramid() {
        Paint image = new Paint();
        String rst = image.pyramid(4);
        System.out.println(rst);
        assertThat(rst, is(new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("   ^   ")
                .add("  ^^^  ")
                .add(" ^^^^^ ")
                .add("^^^^^^^")
                .toString()));
    }
}