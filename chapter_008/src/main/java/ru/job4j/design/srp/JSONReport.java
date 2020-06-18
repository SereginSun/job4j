package ru.job4j.design.srp;

import java.util.function.Predicate;

/**
 * class JSONReport - JSON report for IT.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 17.06.2020
 */
public class JSONReport implements Report {
    private static final String LN = System.lineSeparator();

    private final Store store;

    public JSONReport(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("{").append(LN);
        for (Employee employee : store.findBy(filter)) {
            text.append("\"Name\" : \"").append(employee.getName()).append("\",").append(LN)
                    .append("\"Hired\" : \"").append(employee.getHired().getTime()).append("\",").append(LN)
                    .append("\"Fired\" : \"").append(employee.getFired().getTime()).append("\",").append(LN)
                    .append("\"Salary\" : \"").append(employee.getSalary()).append("\"").append(LN)
                    .append("}");
        }
        return text.toString();
    }
}
