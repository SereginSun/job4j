package ru.job4j.gc;

public class GCDemo {
    private static final long KB = 1000;
    private static final Runtime ENVIRONMENT = Runtime.getRuntime();

    public static void info() {
        final long freeMemory = ENVIRONMENT.freeMemory();
        final long totalMemory = ENVIRONMENT.totalMemory();
        final long maxMemory = ENVIRONMENT.maxMemory();
        System.out.println("=== Environment state ===");
        System.out.printf("Free: %d%n", freeMemory / KB);
        System.out.printf("Total: %d%n", totalMemory / KB);
        System.out.printf("Max: %d%n", maxMemory / KB);
    }

    public static void main(String[] args) {
        info();
        for (int i = 1; i < 7000; i++) {
            new Person(i, "N" + i);
        }
        info();
    }
}
