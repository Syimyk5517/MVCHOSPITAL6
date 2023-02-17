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
    public List<Appointment> findAll() {
        return entityManager.createQuery("select a from Appointment a", Appointment.class).getResultList();
    }
}
