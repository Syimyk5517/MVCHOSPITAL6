package peaksoft.repositories.repoImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.models.Appointment;
import peaksoft.repositories.AppointmentRepo;

import java.util.List;


@Repository
@RequiredArgsConstructor
@Transactional
public class AppointmentRepoImpl implements AppointmentRepo {
    @PersistenceContext
    private final EntityManager entityManager;
    @Override
    public List<Appointment> findAll(Long id) {
       return entityManager.createQuery("select a from Appointment a where a.department.hospital.id =:id", Appointment.class).setParameter("id",id).getResultList();
    }

    @Override
    public void save(Appointment appointment) {
        entityManager.persist(appointment);

    }

    @Override
    public Appointment getById(Long id) {
      return entityManager.find(Appointment.class, id);

    }

    @Override
    public void deleteById(Long id) {
        entityManager.remove(entityManager.find(Appointment.class,id));

    }

    @Override
    public Appointment update(Appointment appointment) {
        return entityManager.merge(appointment);
    }
}
