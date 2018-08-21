import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {
    @Override
    protected void fillElement(int index) {
        int fillNum = size - index - 1;
        if (fillNum > 0) {
            System.arraycopy (storage, index + 1, storage, index, fillNum);
        }
    }

    @Override
    protected void addElement(Resume resume, int index) {
        int addNum = -index - 1;
        System.arraycopy (storage, addNum, storage, addNum + 1, size - addNum);
        storage[addNum] = resume;
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume (uuid);
        searchKey.setUuid (uuid);
        return Arrays.binarySearch (storage, 0, size, searchKey);
    }
}

