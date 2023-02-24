package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.exception.Exception;
import peaksoft.models.Department;
import peaksoft.services.DepartmentService;


import java.util.List;

@Controller
@RequestMapping("/{id}/departments")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;

    @GetMapping
    String getAllDepartments(@PathVariable("id") Long id, Model model) {
        List<Department> departments = departmentService.getAll(id);
        model.addAttribute("departments", departments);
        model.addAttribute("hospitalId", id);
        return "department/departments";
    }

    @GetMapping("/saveDepartment")
    String save(Model model, @PathVariable("id") Long id) {
        model.addAttribute("department", new Department());
        model.addAttribute("hospitalId", id);
        return "/department/saveDepartment";
    }

    @PostMapping("/new")
    String create(@ModelAttribute("department") Department department, @PathVariable("id") Long id) throws Exception {
        departmentService.save(id, department);
        return "redirect:/{id}/departments";
    }

    @DeleteMapping("{departmentId}/delete")
    String delete (@PathVariable("departmentId") Long id) {
        departmentService.deleteById(id);
        return "redirect:/{id}/departments";

    }
}