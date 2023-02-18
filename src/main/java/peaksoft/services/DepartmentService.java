package peaksoft.services;

import org.springframework.stereotype.Service;
import peaksoft.models.Department;

import java.util.List;


@Service
public interface DepartmentService {
    List<Department> getAll();
    void save(Long id ,Department department) throws peaksoft.exception.Exception;
    void finById(Long id);
    void deleteById(Long id);
}
