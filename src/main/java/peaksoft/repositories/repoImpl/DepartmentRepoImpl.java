package peaksoft.repositories.repoImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.models.Department;
import peaksoft.models.Doctor;
import peaksoft.repositories.DepartmentRepo;

import java.util.List;


@RequiredArgsConstructor
@Repository
@Transactional
public class DepartmentRepoImpl implements DepartmentRepo {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Department> getAll(Long id) {
        return entityManager.createQuery("select d from Department d where d.hospital.id=:id", Department.class).setParameter("id",id).getResultList();
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
        department.setHospital(null);
        department.setDoctors(null);
        entityManager.remove(department);
    }

    @Override
    public void update( Department department) {
//        Department oldDepartment = finById(id);
//        oldDepartment.setName(department.getName());
        entityManager.merge(department);
    }

    @Override
    public void assignDoctor(Doctor doctor) {
//        Doctor doctor = entityManager.find(Doctor.class,doctorId);
//        Department department = entityManager.find(Department.class,departmentId);
////        for (Department dep: doc.getDepartments()) {
////            if (dep.getName().equalsIgnoreCase(department.getName())){
////                throw new BadRequestExseption("LLLLL");
////            }else {
//        doctor.addDepartment(department);
//        department.addDoctor(doctor);
//        entityManager.merge(doctor);
//        entityManager.merge(department);
//            }
//        }
        entityManager.merge(doctor);
    }
}
