package ru.job4j.post;

/**
 * class MainPost
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 12.10.2019
 */
public class MainPost {

    public static void main(String[] args) {

        Merger merger = new Merger();
        System.out.println("Enter your username and press Enter.");
        System.out.println("On the next line, enter its Emails and press Enter");
        System.out.println("Enter 'finish' when the data entry is complete!");
        merger.run();
    }
}