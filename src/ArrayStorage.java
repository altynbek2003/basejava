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

    void save(Resume r)
    {
        //TODO check if resume present & check storage overflow
        if (size < storageSize) {storage[size] = r;
        size++;}
    else System.out.println ("Хранилище Переполнено");
    }

       Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid==storage[i].getUuid())
            {
                return storage[i];
            }
        }
        return null;

    }

     void delete(String uuid) {
        // TODO check if resume present
        for (int i = 0; i < size; i++) {
            if (uuid==storage[i].getUuid()) {
                storage[i] = storage[size - 1];
                storage[size - 1] = null;
                size--;
                return;
            }
        }
        System.out.println( "Резюме не существует!");
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
        return size ;
    }

}
