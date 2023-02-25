package peaksoft.repositories.repoImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.models.Department;
import peaksoft.models.Doctor;
import peaksoft.repositories.DoctorRepo;

import java.util.List;


@Repository
@RequiredArgsConstructor
@Transactional
public class DoctorRepoImpl implements DoctorRepo {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Doctor> getAll(Long id) {
        return entityManager.createQuery("select d from Doctor d where d.hospital.id =:id", Doctor.class).setParameter("id",id).getResultList();
    }
    @Override
    public void save(Doctor doctor) {
        entityManager.persist(doctor);

    }

    @Override
    public Doctor findById(Long id) {
     return entityManager.find(Doctor.class,id);

    }

    @Override
    public Doctor update(Doctor doctor) {
        return null;
    }

    @Override
    public void delete(Long id) {
     Doctor doctor = entityManager.find(Doctor.class,id);
//     doctor.setHospital(null);
//     doctor.setAppointments(null);
//     entityManager.remove(doctor);
        entityManager.remove(entityManager.find(Doctor.class, id));

    }


}
