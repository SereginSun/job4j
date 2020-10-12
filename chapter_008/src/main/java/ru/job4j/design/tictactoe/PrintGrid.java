package ru.job4j.design.tictactoe;

/**
 * class PrintGrid implements IDisplay the interface describes the output to the game board console.
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version 1.1
 * @since 06.10.2020
 */
public class PrintGrid implements IDisplay {
    private final IBoard grid;

    public PrintGrid(IBoard grid) {
        this.grid = grid;
    }

    @Override
    public void printGameTable() {
        for (int i = 0; i < grid.getSize(); i++) {
            for (int j = 0; j < grid.getSize(); j++) {
                System.out.printf(" %s", grid.getValue(i, j).getValue());
                if (j != grid.getSize() - 1) {
                    System.out.printf(" %s", "|");
                }
            }
            System.out.printf("%n");
            if (i != grid.getSize() - 1) {
                for (int j = 0; j < grid.getSize(); j++) {
                    System.out.printf("%s", "---");
                    if (j != grid.getSize() - 1) {
                        System.out.printf("%s", "-");
                    }
                }
                System.out.printf("%n");
            }
        }
        System.out.printf("%n");
    }
}
