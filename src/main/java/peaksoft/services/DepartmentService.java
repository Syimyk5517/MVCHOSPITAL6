package peaksoft.services;

import peaksoft.models.Department;

import java.util.List;



public interface DepartmentService {
    List<Department> getAll(Long id);
    void save(Long id ,Department department) throws peaksoft.exception.Exception;
    void finById(Long id);
    void deleteById(Long id);
    void assignDoctor(Long doctorId,Long departmentId);
}
