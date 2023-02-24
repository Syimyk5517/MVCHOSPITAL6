package peaksoft.repositories;

import org.springframework.stereotype.Repository;
import peaksoft.api.HospitalController;
import peaksoft.models.Hospital;

import java.util.List;


@Repository
public interface HospitalRepo {
    List<Hospital> getAll();
    void save(Hospital hospital);
    Hospital findById(Long id);
    void deleteById(Long id);
    void ubdateHospital(Long id,Hospital newHospital);


}
