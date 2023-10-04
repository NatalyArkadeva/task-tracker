package ru.nataly.tasktracker.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.nataly.tasktracker.app.service.TaskService;
import ru.nataly.tasktracker.infra.jpa.entity.EmployeeEntity;
import ru.nataly.tasktracker.infra.jpa.entity.TaskEntity;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/all")
    public List<TaskEntity> getAllTasksByEmployee(@RequestBody EmployeeEntity employee){
        return taskService.findAllByEmployee(employee);
    }

    @GetMapping("/in_progress")
    public List<TaskEntity> getAllInProgressTasksByEmployee(EmployeeEntity employee, boolean isDone){
        return taskService.findAllByEmployeeAndIsDone(employee, isDone);
    }

    @GetMapping("/new")
    public String newTask(Model model) {
        model.addAttribute("task", new TaskEntity());
        return "create-task";
    }

    @PostMapping("/add")
    public String createTask(@ModelAttribute("task") TaskEntity task){
//        if (result.hasErrors()) {
//            return "create-new-doctor";
//        }
        taskService.save(task);
        return "redirect:/";
    }
}
