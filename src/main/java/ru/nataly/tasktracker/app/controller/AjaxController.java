package ru.nataly.tasktracker.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.nataly.tasktracker.app.service.TaskService;
import ru.nataly.tasktracker.infra.jpa.entity.EmployeeEntity;
import ru.nataly.tasktracker.infra.jpa.entity.TaskEntity;

import java.util.List;

@Controller
@RequestMapping("/ajax")
@RequiredArgsConstructor
public class AjaxController {

    private final TaskService taskService;

    @ResponseBody
    @GetMapping("/all")
    public List<TaskEntity> getAllTasks(){
        return taskService.findAll();
    }

    @ResponseBody
    @GetMapping("/all/in-progress")
    public List<TaskEntity> getAllTasksInProgress(){
        return taskService.findAllInProgress();
    }

    @ResponseBody
    @GetMapping("/getTask/{id}")
    public TaskEntity getById(@PathVariable("id") Long id){
        return taskService.findById(id);
    }

    @ResponseBody
    @PostMapping("/saveTask")
    public TaskEntity save(@RequestBody TaskEntity task){
        var taskForSave = taskService.findById(task.getId());
        taskForSave.toBuilder()
        .endDate(task.getEndDate())
                .build();
        return taskService.save(taskForSave);
    }

}
