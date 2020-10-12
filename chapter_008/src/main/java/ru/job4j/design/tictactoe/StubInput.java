package ru.job4j.design.tictactoe;

import java.util.List;

public class StubInput implements Input {
    private final String[] value;
    private int position;

    public StubInput(String[] value) {
        this.value = value;
    }

    @Override
    public String askStr(String question) {
        return this.value[this.position++];
    }

    @Override
    public int askInt(String questions, List<Integer> range) {
        int key = Integer.parseInt(this.value[this.position++]);
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (!exist) {
            throw new RangeOutException("Out of board range.");
        }
        return key;
    }
}
