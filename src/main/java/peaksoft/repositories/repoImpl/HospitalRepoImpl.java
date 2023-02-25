package peaksoft.repositories.repoImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.models.Hospital;
import peaksoft.repositories.HospitalRepo;

import java.util.List;


@Repository
@RequiredArgsConstructor
@Transactional
public class HospitalRepoImpl implements HospitalRepo {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Hospital> getAll() {
        return entityManager.createQuery("select h from Hospital h", Hospital.class).getResultList();
    }

    @Override
    public void save(Hospital hospital) {
        entityManager.persist(hospital);

    }

    @Override
    public Hospital findById(Long id) {
        return entityManager.find(Hospital.class,id);
    }

    @Override
    public void deleteById(Long id) {
        Hospital hospital = findById(id);
        entityManager.remove(entityManager.contains(hospital) ? hospital : entityManager.merge(hospital));
    }

    @Override
    public void ubdateHospital(Long id,Hospital newHospital) {
        System.out.println("sjdk");
        Hospital hospital = findById(id);
        hospital.setImage(newHospital.getImage());
        hospital.setName(newHospital.getName());
        hospital.setAddress(newHospital.getAddress());
        entityManager.merge(newHospital);

    }
}
