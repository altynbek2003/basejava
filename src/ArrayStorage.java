import java.util.Arrays;

public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected void fillElement(int index) {
        storage[index] = storage[size - 1];
    }

    @Override
    protected void addElement(Resume resume, int index) {
        storage[size] = resume;
    }

    @Override
    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals (storage[i].getUuid ())) {
                return i;
            }
        }
        return -1;
    }
}
