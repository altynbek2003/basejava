/**
 * Array based storage for Resumes
 */
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
public class ArrayStorage {
    private int storageLenght = 10000;
    private Resume[] storage = new Resume[storageLenght];
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
        if (size < storageLenght) {storage[size] = r;
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

    public void delete(String uuid) {
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
        Resume[] limitStroge = new Resume[size];
        for (int i = 0; i < size; i++) {
            limitStroge[i] = storage[i];
        }
        return limitStroge;

    }

    public int size() {
        return size ;
    }

}
