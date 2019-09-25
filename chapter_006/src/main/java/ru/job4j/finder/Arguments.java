package ru.job4j.finder;

import org.apache.commons.cli.*;

import java.io.File;

/**
 * class Arguments
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 25.09.2019
 */
public class Arguments {

    private String directory;

    private String name;

    private File output;

    private boolean fullMatch;

    private boolean mask;

    private boolean regex;

    private String[] args;

    public Arguments(String[] args) {
        this.args = args;
    }

    public String getDirectory() {
        return directory;
    }

    public String getName() {
        return name;
    }

    public File getOutput() {
        return output;
    }

    public boolean isFullMatch() {
        return fullMatch;
    }

    public boolean isMask() {
        return mask;
    }

    public boolean isRegex() {
        return regex;
    }

    /**
     * The method is command line parser.
     */
    private void parser() {
        Options options = new Options();

        Option directory = new Option(
                "d", "directory", true, "директория, в которой начинается поиск"
        );
        directory.setRequired(true);
        options.addOption(directory);

        Option name = new Option(
                "n", "name", true, "имя файла, маска или регулярное выражение"
        );
        name.setRequired(true);
        options.addOption(name);

        Option output = new Option(
                "o", "output", true, "результат, записанный в log файл"
        );
        output.setRequired(true);
        options.addOption(output);

        Option mask = new Option("m", "mask", false, "искать по маске");
        options.addOption(mask);

        Option fullName = new Option(
                "f", "full_name", false, "искать по полному совпадению имени"
        );
        options.addOption(fullName);

        Option regex = new Option(
                "r", "regex", false, "искать по регулярному выражению"
        );
        options.addOption(regex);

        CommandLineParser parser = new DefaultParser();
        HelpFormatter helpFormatter = new HelpFormatter();

        try {
            CommandLine cmdLine = parser.parse(options, this.args);

            if (cmdLine.hasOption("f")) {
                System.out.println(cmdLine.getOptionValue("f"));
                this.fullMatch = true;
            }

            if (cmdLine.hasOption("m")) {
                System.out.println(cmdLine.getOptionValue("m"));
                this.mask = true;
            }

            if (cmdLine.hasOption("r")) {
                System.out.println(cmdLine.getOptionValue("r"));
                this.regex = true;
            }

        } catch (ParseException pe) {
            System.out.println(pe.getMessage());
            helpFormatter.printHelp("SearcherApp: ", options);
        }
    }
}