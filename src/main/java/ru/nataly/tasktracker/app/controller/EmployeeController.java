package ru.nataly.tasktracker.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.nataly.tasktracker.app.service.EmployeeService;
import ru.nataly.tasktracker.infra.jpa.entity.ClientEntity;
import ru.nataly.tasktracker.infra.jpa.entity.EmployeeEntity;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/all")
    public List<EmployeeEntity> getAllEmployees(){
        return employeeService.findAll();
    }

    @GetMapping("/one")
    public EmployeeEntity getEmployee(Long id){
        return employeeService.findById(id);
    }

//    @PostMapping("/add")
//    public void createEmployee(@RequestBody EmployeeEntity employee){
//        employeeService.save(employee);
//    }

    @GetMapping("/new")
    public String newEmployee(Model model) {
        model.addAttribute("employee", new EmployeeEntity());
        return "create-employee";
    }

    @PostMapping("/add")
    public String createEmployee(@ModelAttribute("employee") EmployeeEntity employee){
//        if (result.hasErrors()) {
//            return "create-new-doctor";
//        }
        employeeService.save(employee);
        return "redirect:/";
    }
}
