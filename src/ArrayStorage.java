import java.util.Objects;

public class ArrayStorage {
    private int StorageLength = 10000;
    private Resume[] storage = new Resume[StorageLength];
    private int size = 0;

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

    Resume[] get(String uuid) {
        Objects.requireNonNull(uuid, "uuis не должен быть равен null");
        for (int i = 0; i < size; i++) {
            Resume resume = storage[i];
            return new Resume[]{storage[i]};
        }

        void delete (String uuid)
        {
            for (int i = 0; i < size; i++) {
                if (storage[i].uuid.equals(uuid)) {
                    storage[i] = storage[size - 1];
                    storage[size - 1] = null;
                    size--;
                }
            }
            System.out.println("Резюме не существует");
        }

        Resume[] getAll;
        {
            Resume[] NonEmpty = new Resume[size];
            System.arraycopy(storage, 0, NonEmpty, 0, size);
            return NonEmpty;
        }
    }

    int size(String uuid) {

        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i])) {
                return i;
            }
        }
        return 0;
    }
}