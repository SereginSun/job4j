package ru.job4j.sqlite;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

/**
 * class Entry
 * Contains the value of the fields.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 21.12.2019
 */
@XmlRootElement
public class Entry {
    private int field;

    public Entry() {
    }

    public Entry(int field) {
        this.field = field;
    }

    public int getField() {
        return field;
    }

    public void setField(int field) {
        this.field = field;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Entry entry = (Entry) o;
        return field == entry.field;
    }

    @Override
    public int hashCode() {
        return Objects.hash(field);
    }
}
