package peaksoft.repositories;



import peaksoft.models.Department;
import peaksoft.models.Doctor;

import java.util.List;



public interface DepartmentRepo {
    List<Department> getAll(Long id);
    void save(Department department);
    Department finById(Long id);
    void deleteById(Long id);
    void assignDoctor(Doctor doctor);

}
