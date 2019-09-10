package ru.job4j.net;

import com.google.common.base.Joiner;
import org.junit.Test;

import java.io.*;
import java.net.Socket;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * class ClientTest.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 10.09.2019
 */
public class ClientTest {
    private static final String LN = System.getProperty("line.separator");

    @Test
    public void whenAskAnswerThenChoseRandom1() throws IOException {
        this.testClient(
                "exit",
                Joiner.on(LN).join("exit", "")
        );
    }

    @Test
    public void whenAskHelloThenBackGreatOracle() throws IOException {
        this.testClient(
                Joiner.on(LN).join(
                        "Hello oracle",
                        "exit"
                ),
                Joiner.on(LN).join(
                        "Hello oracle",
                        "exit", ""
                )
        );
    }

    @Test
    public void whenUnsupportedAskThenDontUnerstand() throws IOException {
        this.testClient(
                Joiner.on(LN).join("unsupported ask", "exit"),
                Joiner.on(LN).join("unsupported ask", "exit", "")
        );
    }

    private void testClient(String input, String expect) throws IOException {
        Socket socket = mock(Socket.class);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);
        Client client = new Client(socket);
        client.start(new BufferedReader(new InputStreamReader(new ByteArrayInputStream(input.getBytes()))));
        assertThat(out.toString(), is(expect));
    }
}