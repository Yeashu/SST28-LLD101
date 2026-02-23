import java.util.List;

public interface Database {
    public void save(StudentRecord r);
    public int count();
    public List<StudentRecord> all();
}