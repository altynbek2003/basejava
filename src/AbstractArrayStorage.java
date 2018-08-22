import java.util.Arrays;


public abstract class AbstractArrayStorage implements Storage{
    protected static final int STORAGE_SIZE = 10000;
    protected Resume[] storage = new Resume[STORAGE_SIZE];
    protected int size = 0;

    public int size(){
        return size;
    }

    public void clear(){
        Arrays.fill(storage,0,size,null);
        size = 0;
    }

    public void update(Resume resume){
        int index = getIndex(resume.getUuid());
        if (index == -1) {
            System.out.println("Резюме" + resume.getUuid() + " не существует");
        } else {
            storage[index] = resume;
        }
    }

    public void save(Resume resume){
        int index = getIndex(resume.getUuid());
        if (index >= 0) {
            System.out.println("Резюме " + resume.getUuid() + " существует");
        } else if (size >= storage.length) {
            System.out.println("Хранилище переполнено");
        } else {
            storage[size] = resume;
            size++;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */

    public Resume[] getAll(){
        return Arrays.copyOfRange(storage,0,size);
    }

    public void delete(String uuid){
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.println("Resume " + uuid + " not exist");
        } else {
            fillElement(index);
            storage[size - 1] = null;
            size--;
        }
    }

    public Resume get(String uuid){
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.println("Resume " + uuid + " not exist");
            return null;
        }
        return storage[index];
    }

    protected abstract void fillElement(int index);

    protected abstract int getIndex(String uuid);

    protected abstract void addElement(Resume resume,int index);
}
