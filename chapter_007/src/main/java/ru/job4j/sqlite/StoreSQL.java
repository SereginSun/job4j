package ru.job4j.sqlite;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * class StoreSQL
 * Database Interaction.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 21.12.2019
 */
public class StoreSQL implements AutoCloseable {
    private final Config config;
    private Connection conn;

    public StoreSQL(Config config) {
        this.config = config;
        config.init();
        this.init();
    }

    /**
     * This method creates a connection to the database, checks if the table exists,
     * if the table is missing, creates it. If the table contains entries, then they are deleted.
     */
    public void init() {
        try {
            conn = DriverManager.getConnection(this.config.get("url"));
            conn.setAutoCommit(false);
            try (Statement st = conn.createStatement()) {
                st.execute("CREATE TABLE IF NOT EXISTS entry(field INTEGER)");
                st.executeUpdate("DELETE FROM entry");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * generates n records in the database.
     * @param size number of records.
     */
    public void generate(int size) {
        try (PreparedStatement ps = conn.prepareStatement("INSERT INTO entry VALUES (?)")) {
            for (int i = 1; i <= size; i++) {
                ps.setInt(1, i);
                ps.addBatch();
            }
            try {
                ps.executeBatch();
                conn.commit();
            } catch (SQLException e1) {
                conn.rollback();
                e1.printStackTrace();
            }
        } catch (SQLException e) {
                e.printStackTrace();
        }
    }

    /**
     * The method returns a list of all Entry.
     * @return List<Entry>
     */
    public List<Entry> load() {
        List<Entry> result = new ArrayList<>();
        try (Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT * FROM entry");
            while (rs.next()) {
                result.add(new Entry(rs.getInt("field")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void close() throws Exception {
        if (conn != null) {
            conn.close();
        }
    }
}
