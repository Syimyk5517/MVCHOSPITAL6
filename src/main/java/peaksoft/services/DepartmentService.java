package peaksoft.services;

import peaksoft.models.Department;

import java.util.List;



public interface DepartmentService {
    List<Department> getAll();
    void save(Long id ,Department department) throws peaksoft.exception.Exception;
    void finById(Long id);
    void deleteById(Long id);
}
