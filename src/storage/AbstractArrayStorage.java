package storage;

import model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage implements Storage {

    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected static Integer size = 0;

    public Resume get(String uuid) {
        Integer index = find(uuid);
        if (index == -1) {
            System.out.println("I don't find your model.Resume");
            return null;
        }
        return storage[index];
    }

    public int size() {
        return size;
    }

    protected abstract int find(String uuid);

}

