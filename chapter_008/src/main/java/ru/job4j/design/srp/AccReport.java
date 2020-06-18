package ru.job4j.design.srp;

import java.math.BigDecimal;
import java.util.function.Predicate;

/**
 * class AccReport - describing the generation of a report for the accounting department.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 15.06.2020
 */
public class AccReport implements Report {
    private static final String LN = System.lineSeparator();
    private static final double DOLLAR_RATE = 69.58;

    private final Store store;

    public AccReport(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary").append(LN);
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";").append(LN)
                    .append(employee.getHired()).append(";").append(LN)
                    .append(employee.getFired()).append(";").append(LN)
                    .append(new BigDecimal(employee.getSalary() / DOLLAR_RATE)).append("$");
        }
        return text.toString();
    }
}
