package ru.job4j.sqlite;

import java.io.File;
import java.util.Objects;
import java.util.Scanner;

/**
 * class Main
 * Application start.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 21.12.2019
 */
public class Main {
    private int number;

    public void run() {
        Scanner scan = new Scanner(System.in);
            System.out.print("Enter a positive integer: ");
            if (scan.hasNextInt()) {
                number = scan.nextInt();
            }
            try (StoreSQL sql = new StoreSQL(new Config())) {
                sql.generate(number);
                File scheme = new File(
                        Objects.requireNonNull(getClass().getClassLoader().getResource("scheme.xsl")).getPath()
                );
                File first = new File(scheme.getParent() + "/first.xml");
                File result = new File(scheme.getParent() + "/result.xml");
                new StoreXML(first).save(sql.load());
                new ConvertXSLT().convert(first, result, scheme);
                int sum = new ParserSAX().parseFile(result);
                System.out.printf("Sum of all elements: %s%n", sum);
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
