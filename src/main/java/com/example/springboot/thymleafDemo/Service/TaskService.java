package com.example.springboot.thymleafDemo.Service;

import com.example.springboot.thymleafDemo.Entity.Task;
import com.example.springboot.thymleafDemo.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class TaskService {


    @Autowired
    private final TaskRepository taskRepository;


    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getTask(){
        return taskRepository.findAll();
    }

    public void addTask(Task task){
        taskRepository.save(task);
        System.out.print(task);
    }

    public void deleteTask(int task_id){
        boolean exists = taskRepository.existsById(task_id);
        if(!exists){
            throw new IllegalStateException("Task doesn't exists");
        }else{
            taskRepository.deleteById(task_id);
        }
    }

    public void UpdateTask(int task_id , String task_name , String intern_executed , String process){
        Task task = taskRepository.findById(task_id)
                .orElseThrow(() -> new IllegalStateException("Task doesn't exists"));

        if(task_name != null && task_name.length() > 0 && !Objects.equals(task_name , task.getTask_name() )){
            task.setTask_name(task_name);
        }

        if(intern_executed != null && intern_executed.length() > 0 && !Objects.equals(intern_executed , task.getIntern_executed())){
            task.setIntern_executed(intern_executed);
        }

        if(process != null && process.length() > 0 && !Objects.equals(process , task.getProcess())){
            task.setProcess(process);
        }
    }

}
