package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * class Analyze - analyzes the incoming file (server.log)
 * for server availability in time periods.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 14.08.2019
 */
public class Analyze {
    private final List<String> result = new ArrayList<>();

    /**
     * The method reads information from the source file,
     * finds ranges when the server was down.
     *
     * @param source - original file.
     */
    public void unavailable(String source, String target) {
        try (BufferedReader br = new BufferedReader(new FileReader(source))) {
            String str;
            String time = null;
            while (br.ready()) {
                str = br.readLine();
                if ((str.contains("400") || str.contains("500")) && time == null) {
                    time = str.substring(4);
                }
                if ((str.contains("200") || str.contains("300")) && time != null) {
                    result.add(String.join(";", time, str.substring(4)));
                    time = null;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        writeToFile(target);
    }

    /**
     * The method writes these ranges to the target file.
     *
     * @param source - original file.
     */
    public void writeToFile(String source) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(source))) {
            for (String timeToTime : result) {
                bw.write(timeToTime);
                bw.write(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
