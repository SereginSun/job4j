package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamUsage {
    public static class Task {
        private final String name;
        private final long spent;

        public Task(String name, long spent) {
            this.name = name;
            this.spent = spent;
        }

        @Override
        public String toString() {
            return "Task{"
                    +
                    "name='" + name + '\''
                    +
                    ", spent=" + spent
                    +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<Task> tasks = Arrays.asList(
                new Task("BUG #1", 100),
                new Task("Task #2", 100),
                new Task("BUG #3", 100)
        );

//        List<Task> container = new ArrayList<>();
//        for (Task task : tasks) {
//            if ("BUG".equals(task.name)) {
//                container.add(task);
//            }
//        }

        List<Task> bugs = tasks.stream().filter(
                task -> task.name.contains("BUG")
        ).collect(Collectors.toList());
        bugs.forEach(System.out::println);

//        List<String> container = new ArrayList<>();
//        for (Task task : tasks) {
//            container.add(task.name);
//        }

//        List<String> names = tasks.stream().map(
//                task -> task.name
//        ).collect(Collectors.toList());
//        names.forEach(System.out::println);

//        long total = 0L;
//        for (Task task :tasks) {
//            total += task.spent;
//        }
//        System.out.println(total);

//        long total = tasks.stream().map(
//                task -> task.spent
//        ).reduce(0L, Long::sum);
//        System.out.println(total);
    }
}