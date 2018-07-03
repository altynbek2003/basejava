/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private int storageSize = 10000;
    private Resume[] storage = new Resume[storageSize];
    private int size = 0;

    void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;

    }

    public void update(Resume r) {
        int index;
        index = getPoint (r.getUuid ());
        if (index == -1) {
            System.out.println ("Резюме" + r.getUuid () + " не существует");
        } else {
            storage[index] = r;
        }
    }

    void save(Resume r) {
        //TODO check if resume present & check storage overflow
        if (getPoint (r.getUuid ()) != -1) {
            System.out.println ("Резюме " + r.getUuid () + " существует");
        } else if (size >= storage.length) {
            System.out.println ("Хранилище переполнено");
        } else {
            storage[size] = r;
            size++;
        }
    }

    Resume get(String uuid) {
        int index;
        index = getPoint (uuid);
        if (index == -1) {
            System.out.println ("Резюме " + uuid + " не существует");
            return null;
        }
        return storage[index];
    }

    void delete(String uuid) {
        // TODO check if resume present
        int index = getPoint (uuid);
        if (index == -1) {
            System.out.println ("Резюме " + uuid + " не существует");
        } else {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */

    Resume[] getAll() {
        Resume[] limitStorage = new Resume[size];
        System.arraycopy (storage, 0, limitStorage, 0, size);
        return limitStorage;

    }

    int size() {
        return size;
    }

    private int getPoint(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals (storage[i].getUuid ())) {
                return i;
            }
        }
        return 0;
    }
}
