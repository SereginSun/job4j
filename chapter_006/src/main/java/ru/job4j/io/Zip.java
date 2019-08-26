package ru.job4j.io;

import java.io.*;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * class Zip
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 26.08.2019
 */
public class Zip {

    /**
     * The method archives the specified directory in a zip archive,
     * excluding files with the specified extension and preserving the project structure.
     *
     * @param source - project directory.
     * @param target - project archive.
     * @param exc - extension of files that do not need to be included in the archive.
     */
    public void pack(File source, File target, String exc) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (File file : this.seekBy(source.getParent(), exc)) {
                zip.putNextEntry(new ZipEntry(source.getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(file))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Args argument = new Args(args);
        new Zip().pack(new File(argument.getDirectory()), new File(argument.getOutput()), argument.getExclude());
    }

    /**
     * The method returns a list of all files contained in the root folder and all its internal folders,
     * except for files with the specified extension.
     * @param root - source directory.
     * @param ext - extension of files that do not need to be included in the list.
     * @return returns a list of files with the extension excluding ext.
     */
    public List<File> seekBy(String root, String ext) {
        List<File> resultListOfFiles = new ArrayList<>();
        Queue<File> attachmens = new LinkedList<>();
        attachmens.offer(new File(root));
        while (!attachmens.isEmpty()) {
            File files = attachmens.poll();
            if (files != null && files.isDirectory()) {
                for (var file : Objects.requireNonNull(files.listFiles())) {
                    attachmens.offer(file);
                }
            } else {
                if (files.isFile() && !files.getName().endsWith(ext)) {
                    resultListOfFiles.add(files);
                }
            }
        }
        return resultListOfFiles;
    }
}