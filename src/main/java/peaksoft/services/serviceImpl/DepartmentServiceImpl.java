package peaksoft.services.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.exception.BadRequestExseption;
import peaksoft.exception.Exception;
import peaksoft.models.Department;
import peaksoft.models.Hospital;
import peaksoft.repositories.DepartmentRepo;
import peaksoft.repositories.HospitalRepo;
import peaksoft.services.DepartmentService;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepo departmentRepo;
    private final HospitalRepo hospitalRepo;

    @Override
    public List<Department> getAll(Long id) {
        return departmentRepo.getAll(id);
    }

    @Override
    @Transactional
    public void save(Long id, Department department) throws Exception {
        Hospital hospital = hospitalRepo.findById(id);
//      for (Department dep : departmentRepo.getAll()) {
//           if (dep.getName().equalsIgnoreCase(department.getName())) {
//              throw new BadRequestExseption("");
//           } else {
                hospital.addDepartment(department);
                department.setHospital(hospital);
                departmentRepo.save(department);
          }
//      }
//    }


    //        System.out.println("id = " + id);
//        System.out.println("department = " + department);
//        List<Department> departments = departmentRepo.getAll();
//            for (Department d:departments) {
//                if (d.getName().equalsIgnoreCase(department.getName())){
//                     throw new BadRequestExseption("qwerty");
//                }else {
//                     Hospital hospital = hospitalRepo.findById(id);
//                     hospital.addDepartment(department);
//                     department.setHospital(hospital);
//                     departmentRepo.save(department);
////
////                    System.out.println("department = " + department);
////                }
////            }
//    }
    @Override
    public void finById(Long id) {
        departmentRepo.finById(id);
    }

    @Override
    public void deleteById(Long id) {
        departmentRepo.deleteById(id);
    }
}
