package peaksoft.repositories.repoImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.models.Department;
import peaksoft.repositories.DepartmentRepo;

import java.util.List;


@RequiredArgsConstructor
@Repository
@Transactional
public class DepartmentRepoImpl implements DepartmentRepo {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Department> getAll() {
        return entityManager.createQuery("select d from Department d", Department.class).getResultList();
    }

    @Override
    public void save(Department department) {
     entityManager.persist(department);
    }

    @Override
    public Department finById(Long id) {
       return entityManager.find(Department.class,id);


    }
    @Override
    public void deleteById(Long id) {
        Department department = entityManager.find(Department.class, id);
        entityManager.remove(department);
    }
}
