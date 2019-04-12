package ru.job4j.bank;

import java.util.Objects;

/**
 * class Account
 * @author Vladimir Seregin (SereginSun@yandex.ru)
 * @version $Id$
 * @since 12.04.2019
 */
public class Account {
    private double value;
    private String requisites;

    public Account(double value, String requesites) {
        this.value = value;
        this.requisites = requesites;
    }

    public double getValue() {
        return value;
    }

    public String getRequisites() {
        return requisites;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        return (o != null && getClass() == o.getClass() && this.requisites.equals(((Account)o).requisites));
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, requisites);
    }

    @Override
    public String toString() {
        return "Account{" + "values=" + value + ", requisites='" + requisites + "\\" + "}";
    }
}