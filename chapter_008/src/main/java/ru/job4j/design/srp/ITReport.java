package ru.job4j.design.srp;

import java.util.function.Predicate;

/**
 * ITReport class - description of report generation for the IT department in the form html.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 15.06.2020
 */
public class ITReport implements Report {
    private final Store store;

    private static final String LN = System.lineSeparator();

    public ITReport(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("<!DOCTYPE html>").append(LN)
                .append("<html>").append(LN)
                .append("<head>").append(LN)
                .append("<title>").append("Report for IT department").append("</title>").append(LN)
                .append("<meta charset=\"utf-8\">").append(LN)
                .append("</head>").append(LN)
                .append("<body>").append(LN)
                .append("<table>").append(LN)
                .append("<tr>").append(LN)
                .append("<th>").append("Name").append("</th>").append(LN)
                .append("<th>").append("Hired").append("</th>").append(LN)
                .append("<th>").append("Fired").append("</th>").append(LN)
                .append("<th>").append("Salary").append("</th>").append(LN)
                .append("</tr>").append(LN);
        for (Employee employee : store.findBy(filter)) {
            text.append("<tr>").append(LN)
                    .append("<td>").append(employee.getName()).append("</td>").append(LN)
                    .append("<td>").append(employee.getHired()).append("</td>").append(LN)
                    .append("<td>").append(employee.getFired()).append("</td>").append(LN)
                    .append("<td>").append(employee.getSalary()).append("</td>").append(LN)
                    .append("</tr>").append(LN);
        }

        text.append("</table>").append(LN)
                .append("</body>").append(LN)
                .append("</html>");
        return text.toString();
    }
}
