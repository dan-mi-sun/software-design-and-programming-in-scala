package spec;

import impl.Student;

public interface StudentStore {
    public boolean exists(Integer id);

    public Student load(Integer id);

    public Student save(Student p);
}
