package ru.job4j.io;

/**
 * class Args
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 26.08.2019
 */
public class Args {
    private String directory;
    private String exclude;
    private String output;

    public Args(String[] args) {
        for (int i = 0; i < args.length - 1; i++) {
            if (args[i].equals("-d")) {
                this.directory = args[i + 1];
            }
            if (args[i].equals("-e")) {
                this.exclude = args[i + 1].substring(2);
            }
            if (args[i].equals("-o")) {
                this.output = args[i + 1];
            }
        }
    }

    public String getDirectory() {
        return this.directory;
    }

    public String getExclude() {
        return this.exclude;
    }

    public String getOutput() {
        return this.output;
    }
}