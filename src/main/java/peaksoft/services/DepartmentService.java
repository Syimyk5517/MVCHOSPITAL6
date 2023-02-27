package peaksoft.services;

import peaksoft.models.Department;
import peaksoft.models.Doctor;

import java.util.List;



public interface DepartmentService {
    List<Department> getAll(Long id);
    void save(Long id ,Department department) throws peaksoft.exception.Exception;
    Department finById(Long id);
    void deleteById(Long id);
    void update(Long departmentId,Department department);
    void assignDoctor(Long doctorId, Doctor doctor);
}
