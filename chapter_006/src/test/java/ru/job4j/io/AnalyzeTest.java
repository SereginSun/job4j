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
        testAnalizy.unavailable("c:/projects/job4j/server.log", "c:/projects/job4j/unavailable.csv");
        BufferedReader br = new BufferedReader(new FileReader("c:/projects/job4j/unavailable.csv"));
        assertThat(br.readLine(), is("10:58:01;10:59:01"));
        assertThat(br.readLine(), is("11:01:02;11:02:02"));
    }
}