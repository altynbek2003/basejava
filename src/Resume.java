public class Resume{

    // Unique identifier
    private String uuid;

    public Resume(String uuid){
        this.uuid = uuid;
    }

    public Resume(){

    }

    public String getUuid(){
        return uuid;
    }

    public void setUuid(String uuid){
        this.uuid = uuid;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resume resume = (Resume)o;

        return getUuid().equals(resume.getUuid());
    }

    @Override
    public int hashCode(){
        return getUuid().hashCode();
    }

    @Override
    public String toString(){
        return getUuid();
    }
}






