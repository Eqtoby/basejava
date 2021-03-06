package storage;

import model.Resume;

/**
 * Array based storage for Resumes
 */
public interface Storage {

    void clear();

    void save(Resume r);

    void update(Resume r, Resume n);

    Resume get(String uuid);

    void delete(String uuid);

    Resume[] getAll();

    int size();

}
