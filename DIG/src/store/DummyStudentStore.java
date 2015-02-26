package store;

import impl.Student;
import spec.StudentStore;

import javax.inject.Singleton;
import java.util.HashMap;
import java.util.Map;

@Singleton
public class DummyStudentStore implements StudentStore {

    private final Map<Integer, Student> studentMap;

    public DummyStudentStore() {
        studentMap = new HashMap<>();
    }

    @Override
    public boolean exists(Integer id) {
        return studentMap.containsKey(id);
    }

    @Override
    public Student load(Integer id) {
        return studentMap.get(id);
    }

    @Override
    public Student save(Student p) {
        if (p.getId() == null) {
            p.setId(studentMap.size() + 1);
        }
        studentMap.put(p.getId(), p);
        return p;
    }

}
