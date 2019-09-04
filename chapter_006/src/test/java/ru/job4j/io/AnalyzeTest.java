package ru.job4j.io;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AnalyzeTest {

    @Test
    public void whenInputSourceThenOutputTargetWithUnavailableTime() throws IOException {
        Analyze testAnalizy = new Analyze();
        testAnalizy.unavailable(
                ClassLoader.getSystemResource("server.txt").getPath(),
                "src/main/resources/unavailable.csv"
        );
        BufferedReader br = new BufferedReader(new FileReader(
                ClassLoader.getSystemResource("unavailable.csv").getPath()
        ));
        assertThat(br.readLine(), is("10:57:01;10:59:01"));
        assertThat(br.readLine(), is("11:01:02;11:02:02"));
    }
}