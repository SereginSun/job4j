package ru.job4j.finder;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * class Searcher - Searches for files in a directory and subdirectories
 * by criteria - the file name can be specified in full, by mask or by regular expression.
 * The result is written to the specified file.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 25.09.2019
 */
public class Searcher {

    private String root;

    private String searchingFile;

    private File output;

    private List<File> result = new ArrayList<>();

    private Arguments args;

    public Searcher(Arguments args) {
        this.root = args.getDirectory();
        this.searchingFile = args.getName();
        this.output = args.getOutput();
    }

    /**
     * The method Searches for files in a directory and subdirectories
     * by criteria - the file name can be specified in full, by mask or by regular expression.
     */
    private void seekBy() {
        Queue<File> queue = new LinkedList<>();
        queue.offer(new File(root));
        while (!queue.isEmpty()) {
            File file = queue.poll();
            File[] list = file.listFiles();
            if (file.isDirectory() && list != null) {
                for (File tempFile : list) {
                    queue.offer(tempFile);
                }
            } else {
                if (args.isFullMatch() && searchingFile.equalsIgnoreCase(file.getName())) {
                    result.add(file);
                }
                if (args.isMask() && searchingFile.replaceAll("\\*", ".*").equalsIgnoreCase(file.getName())) {
                    result.add(file);
                }
                if (args.isRegex() && file.getName().matches(args.getName())) {
                    result.add(file);
                }
            }
        }
        this.writeLog(output, result);
    }

    /**
     * The method writes the result to the specified file.
     *
     * @param target - name specified file.
     * @param result - list of found files.
     */
    public void writeLog(File target, List<File> result) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(target))) {
            for (File line : result) {
                bw.write(line + System.lineSeparator());
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Arguments arg = new Arguments(args);
        new Searcher(arg).seekBy();
    }
}