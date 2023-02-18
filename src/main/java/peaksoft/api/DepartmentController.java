package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.exception.Exception;
import peaksoft.models.Department;
import peaksoft.repositories.DepartmentRepo;
import peaksoft.repositories.HospitalRepo;
import peaksoft.services.DepartmentService;
import peaksoft.services.HospitalService;

import java.util.List;

@Controller
@RequestMapping("/departments")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;
    private final HospitalService hospitalService;
    @GetMapping
    String getAllDepartments(Model model){
        List<Department> departments = departmentService.getAll();
          model.addAttribute("departments",departments);
          return "department/departments";
    }
    @PostMapping("/new")
    String create(@ModelAttribute("newDepartment")Department department,
                  @RequestParam("hospitalId") Long id) throws Exception {
         departmentService.save(id,department);
         return "redirect:/departments";
    }
    @GetMapping("/saveDepartment")
    String save(Model model){
        model.addAttribute("department",new Department());
        model.addAttribute("hospitals",hospitalService.getAll());
        return "department/saveDepartment";
    }

}
