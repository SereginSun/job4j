package ru.job4j.design.srp;

import java.util.function.Predicate;

/**
 * class ReportEngine - Initial report for the IT department.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 15.06.2020
 */
public class ReportEngine implements Report {
    private static final String LN = System.lineSeparator();

    private final Store store;

    public ReportEngine(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary").append(LN);
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary()).append(LN);
        }
        return text.toString();
    }
}
