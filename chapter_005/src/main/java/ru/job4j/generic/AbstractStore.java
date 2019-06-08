package ru.job4j.generic;

/**
 * class AbstractStore
 *
 * @author Seregin Vladimir (SereginSun@yandex.ru)
 * @version $Id$
 * @since 07.06.2019
 */
public class AbstractStore<T extends Base> implements Store<T> {
    private SimpleArray<T> array;

    protected AbstractStore(int size) {
        this.array = new SimpleArray<>(size);
    }

    @Override
    public void add(T model) {
        this.array.add(model);

    }

    @Override
    public boolean replace(String id, T model) {
        boolean result = false;
        int index = this.getIndexById(id);
        if (index != -1) {
            this.array.set(index, model);
            result = true;
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        int index = this.getIndexById(id);
        if (index != 1) {
            this.array.remove(index);
            result = true;
        }
        return result;
    }

    @Override
    public T findById(String id) {
        T result = null;
        int index = this.getIndexById(id);
        if (index != -1) {
            result = this.array.get(index);
        }
        return result;
    }

    private int getIndexById(String id) {
        var result = -1;
        var position = 0;
        for (var index : array) {
            if (index.getId().equals(id)) {
                result = position;
                break;
            }
            position++;
        }
        return result;
    }
}