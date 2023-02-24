package peaksoft.services.serviceImpl;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.models.Hospital;
import peaksoft.repositories.HospitalRepo;
import peaksoft.services.HospitalService;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
public class HospitalServiceImpl implements HospitalService {
    private final HospitalRepo hospitalRepo;
    @Override
    public List<Hospital> getAll() {
        return hospitalRepo.getAll();
    }

    @Override
    public void save(Hospital hospital) {
            if (hospital.getName().toLowerCase().length()<1){
                for (Character i:hospital.getName().toCharArray()) {
                    if (!Character.isLetter(i)){
                        System.out.println("Aty jok hospital bolboit!!!");
                }
            }
        }else {
                try {
                    hospitalRepo.save(hospital);
            }catch (RuntimeException e){
                    System.out.println(e.getMessage());
                }
        }

    }

    @Override
    public Hospital findById(Long id) {
        return hospitalRepo.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        hospitalRepo.deleteById(id);

    }

    @Override
    public void ubdateHospital(Long id, Hospital newHospital) {
        System.out.println("jskfn");
        hospitalRepo.ubdateHospital(id,newHospital);
    }
}
