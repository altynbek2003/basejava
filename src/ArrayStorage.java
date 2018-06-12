import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

public class ArrayStorage {
    private int StorageLength = 10000;
    private Resume[] storage = new Resume[StorageLength];//Исправлено
    private int size = 0;
//Исправлено
   // public ArrayStorage() {
      //  size = 0;
        void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }
    void save(Resume r) {
        if (size < StorageLength) {
            storage[size] = r;
            size++;
        } else {
            System.out.println("Хранилище переполнено");
        }
    }

    Resume get(String uuid) {
        Objects.requireNonNull(uuid, "uuis не должен быть равен null");
        for (int i = 0; i < size; i ++) {
            Resume resume = storage[i];
            if (resume != null && uuid.equals(resume.uuid)) {
                return resume;
            } else {
                System.out.println("UUID не существует");
                break;
            }
        }
        return null;
    }
    void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                storage[i] = storage[size - 1];
                storage[size - 1] = null;
                size--;
                return;
            }
        }
        System.out.println("Резюме не существует");
    }
    Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }
}