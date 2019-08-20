package ru.job4j.io;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * class Search
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 21.08.2019
 */
public class Search {

    /**
     * The method that returns a list of files with the desired extension from a directory tree.
     * @param parent - The root folder where the search begins.
     * @param exts - list of search extensions.
     * @return list of found files.
     */
    public List<File> files(String parent, List<String> exts) {
        List<File> resultListOfFiles = new ArrayList<>();
        Queue<File> attachments = new LinkedList<>();
        attachments.offer(new File(parent));
        while (!attachments.isEmpty()) {
            File files = attachments.poll();
            if (files != null && files.isDirectory()) {
                for (var file : files.listFiles()) {
                    attachments.offer(file);
                }
            } else {
                if (exts.contains(files.getName().substring(files.getName().lastIndexOf(".") + 1))) {
                    resultListOfFiles   .add(files);
                }
            }
        }
        return resultListOfFiles;
    }
}
