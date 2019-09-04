package ru.job4j.io;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * class ConfigTest
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 06.08.2019
 */
public class ConfigTest {

    @Test
    public void whenLoadFileThenKeyReturnValue() {
        Config testConfig = new Config(Config.class.getClassLoader().getResource("app.properties").getFile());
        testConfig.load();
        assertThat(testConfig.value("hibernate.dialect"), is("org.hibernate.dialect.PostgreSQLDialect"));
        assertThat(testConfig.value("hibernate.connection.url"), is("jdbc:posgresql://127.0.0.1:5432/trackstudio"));
        assertThat(testConfig.value("hibernate.connection.driver_class"), is("org.postgresql.Driver"));
        assertThat(testConfig.value("hibernate.connection.password"), is("password"));
    }
}