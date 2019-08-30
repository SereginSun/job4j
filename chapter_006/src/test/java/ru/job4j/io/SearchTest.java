package ru.job4j.io;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * class SearchTest
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 21.08.2019
 */
public class SearchTest {
    private Search testSearch = new Search();
    private final File root = new File(System.getProperty("java.io.tmpdir") + "/root");
    private File firstFolder = new File(root,  "/firstFolder");
    private File secondFolder = new File(root, "/secondFolder");
    private File thirdFolder = new File(root, "/thirdFolder");
    private File fourthFolder = new File(secondFolder,  "/fourthFolder");
    private File fifthFolder = new File(secondFolder,  "/fifthFolder");
    private File firstFile = new File(root,  "/firstFile.txt");
    private File secondFile = new File(fourthFolder, "/secondFile.log");
    private File thirdFile = new File(fifthFolder, "/thirdFile.doc");
    private File fourthFile = new File(fifthFolder, "/fourthFile.pdf");
    private File fifthFile = new File(thirdFolder, "/fifthFile.log");
    private File sixthFile = new File(thirdFolder, "/sixthFile.doc");
    private File seventhFile = new File(firstFolder, "/seventhFile.gif");

    @Before
    public void init() {
        try {
            root.mkdirs();
            firstFolder.mkdirs();
            secondFolder.mkdir();
            thirdFolder.mkdir();
            fourthFolder.mkdir();
            fifthFolder.mkdir();
            firstFile.createNewFile();
            secondFile.createNewFile();
            thirdFile.createNewFile();
            fourthFile.createNewFile();
            fifthFile.createNewFile();
            sixthFile.createNewFile();
            seventhFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenFilesHasFoundByExtensions() throws IOException {
        List<File> result = testSearch.files(String.valueOf(root), List.of("txt", "doc"));
        List<File> expect = List.of(firstFile, sixthFile, thirdFile);
        assertThat(result, is(expect));
    }

    @Test
    public void whenFilesHasNotFoundByExtensions() throws IOException {
        List<File> result = testSearch.files(String.valueOf(root), List.of("iml", "bmp"));
        List<File> expect = List.of();
        assertThat(result, is(expect));
    }
}