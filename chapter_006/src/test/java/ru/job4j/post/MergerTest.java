package ru.job4j.post;

import com.google.common.base.Joiner;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MergerTest {
    private ByteArrayOutputStream output = new ByteArrayOutputStream();
    private static final String LN = System.getProperty("line.separator");

    private String line1 = "user1";
    private String line2 = "xxx@ya.ru, foo@gmail.com, lol@mail.ru";
    private String line3 = "user2";
    private String line4 = "foo@gmail.com, ups@pisem.net";
    private String line5 = "user3";
    private String line6 = "xyz@pisem.net, vasya@pupkin.com";
    private String line7 = "user4";
    private String line8 = "ups@pisem.net, aaa@bbb.ru";
    private String line9 = "user5";
    private String line10 = "xyz@pisem.net";

    private String text = Joiner.on(LN).join(
            line1, line2, line3, line4, line5, line6, line7, line8, line9, line10
    );

    private ByteArrayInputStream in = new ByteArrayInputStream(text.getBytes());

    @Before
    public void setUp() {
        System.setIn(in);
        System.setOut(new PrintStream(output));
    }

    @Test
    public void mergeUsersByEmail() {
        Merger merger = new Merger();
        merger.run();

        Map<String, Set<String>> expected = new HashMap<>();
        expected.put("user1", Set.of("aaa@bbb.ru, ups@pisem.net, lol@mail.ru, xxx@ya.ru, foo@gmail.com"));
        expected.put("user3", Set.of("vasya@pupkin.com, xyz@pisem.net"));

        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, Set<String>> entry : expected.entrySet()) {
            sb.append(entry.getKey());
            sb.append("\n");
            sb.append(entry.getValue());
            sb.append("\n");
        }

        String textExpected = sb.toString();

        String result = output.toString().replaceAll("\r", "");

        assertThat(result, is(textExpected));
    }
}