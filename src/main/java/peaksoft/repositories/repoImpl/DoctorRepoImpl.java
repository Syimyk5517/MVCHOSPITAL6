package peaksoft.repositories.repoImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
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
    public List<Doctor> getAll() {
        return entityManager.createQuery("select d from Doctor d", Doctor.class).getResultList();
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
     entityManager.remove(doctor);
    }
}
