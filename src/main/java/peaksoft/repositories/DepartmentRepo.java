package peaksoft.repositories;



import peaksoft.models.Department;

import java.util.List;



public interface DepartmentRepo {
    List<Department> getAll();
    void save(Department department);
    Department finById(Long id);
    void deleteById(Long id);

}
