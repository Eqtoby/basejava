package storage;

import model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class SortedArrayStorage extends AbstractArrayStorage {

    public void clear() {
        Arrays.fill(storage, 0, size,null);
        size = 0;
    }

    public void save(Resume r) {
        if (size == storage.length) {
            System.out.println("Massive model.Resume is full, i don't add your model.Resume");
            return;
        }
        Integer index = find(r.getUuid());
        if (index == -1) {
            storage[size] = r;
            size++;
        }
    }

    public void update(Resume r, Resume n) {
        Integer index = find(r.getUuid());
        if (index != -1) {
            storage[index] = n;
        }
        else{
            System.out.println("I don't find your model.Resume");
        }
    }

    public void delete(String uuid) {
        Integer index = find(uuid);
        if (index != -1) {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        }
        else{
            System.out.println("I don't find your model.Resume");
        }

    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    protected int find(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

}
