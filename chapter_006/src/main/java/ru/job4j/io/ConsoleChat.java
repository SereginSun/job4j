package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * class ConsoleChat.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 29.08.2019
 */
public class ConsoleChat {
    private String input;
    private String output;

    /**
     * Constructor.
     *
     * @param input - path to file with bot's phrases.
     * @param output - path to file with chat's log.
     */
    public ConsoleChat(String input, String output) {
        this.input = input;
        this.output = output;
    }

    /**
     * The method reads a text file with bot's phrases to a List.
     *
     * @param source - source file to read.
     * @return list of lines.
     */
    public List<String> readChatText(String source) {
        List<String> result = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(source))) {
            result = br.lines().collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * The method return a string from a list randomly.
     *
     * @param input - incoming list of strings.
     * @return a random string from a list.
     */
    private String getRandomPhrase(List<String> input) {
        Random random = new Random();
        String result = input.get(random.nextInt(input.size()));
        System.out.printf("%s: %s%n", "BOT", result);
        return result;
    }

    /**
     * The method starts the chat and organizes handling of user's answers.
     */
    public void run() {
        List<String> log = new LinkedList<>();
        boolean mute = false;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            List<String> response = this.readChatText(this.input);
            String message = br.readLine();
            while (!"finish".equals(message)) {
                if ("stop".equals(message)) {
                    mute = true;
                }
                if ("continue".equals(message)) {
                    mute = false;
                }
                log.add(String.format("%-10s%-20s", "*User:", message));
                if (!mute) {
                    log.add(String.format("%-10s%-20s%n", "*Bot:", this.getRandomPhrase(response)));
                }
                message = br.readLine();
            }
            log.add(String.format("%-10s%-20s%n", "*User:", message));
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.writeLog(this.output, log);
    }

    /**
     * The method writes a list of chat logs to a file.
     * @param target - file with chat's log.
     * @param log - a list of chat logs.
     */
    private void writeLog(String target, List<String> log) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(target))) {
            for (String line : log) {
                bw.write(line + '\n');
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        PrintWriter pw = new PrintWriter(System.out, true);
        pw.println("Enter any phrase");
        pw.println("stop - the program is silent");
        pw.println("continue - the program starts responding again");
        pw.println("finish - the program stops working.");
        ConsoleChat bot = new ConsoleChat(
                ClassLoader.getSystemResource("bot'sPhrases.txt").getPath(),
                "chapter_006/src/main/resources/log.txt"
        );
        bot.run();
    }
}