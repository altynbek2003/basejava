import java.util.Arrays;

/**
 * Array based storage for Resumes
 */

public abstract class AbstractArrayStorage implements Storage {
    protected static int storageSize = 10000;
    protected Resume[] storage = new Resume[storageSize];
    protected int size = 0;

    public int size() {
        return size;
    }

    public void clear() {

        for (int i = 0; i < size; i++) {
            Arrays.fill (storage, null);
        }
        size = 0;
    }

    public void update(Resume r) {
        int index = getIndex (r.getUuid ());
        if (index == -1) {
            System.out.println ("Резюме" + r.getUuid () + " не существует");
        } else {
            storage[index] = r;
        }
    }

    public void save(Resume r) {
        //TODO check if resume present & check storage overflow
        int index= getIndex (r.getUuid ());
        if (index >=0) {
            System.out.println ("Резюме " + r.getUuid () + " существует");
        } else if (size >= storage.length) {
            System.out.println ("Хранилище переполнено");
        } else {
            storage[size] = r;
             size++;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */

    public Resume[] getAll() {
        Resume[] limitStorage = new Resume[size];
        System.arraycopy (storage, 0, limitStorage, 0, size);
        return limitStorage;

    }


    public void delete(String uuid) {
        int index = getIndex (uuid);
        if (index < 0) {
            System.out.println ("Resume " + uuid + " not exist");
        } else {
            fillElement (index);
            storage[size - 1] = null;
            size--;
        }
    }

    public Resume get(String uuid) {
        int index = getIndex (uuid);
        if (index < 0) {
            System.out.println ("Resume " + uuid + " not exist");
            return null;
        }
        return storage[index];
    }

    protected abstract void fillElement(int index);

    protected abstract void addElement(Resume r, int index);

    protected abstract int getIndex(String uuid);
}
