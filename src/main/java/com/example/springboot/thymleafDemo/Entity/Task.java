package com.example.springboot.thymleafDemo.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "_task")
public class Task {

    @Id
    @SequenceGenerator(
            name = "task_sequence",
            sequenceName = "task_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "task_sequence")

    private int task_id;
    private String task_name;
    private String intern_executed;
    private String process;

    public Task(){
    }



    public Task(String task_name, String intern_executed, String process) {
        this.task_name = task_name;
        this.intern_executed = intern_executed;
        this.process = process;
    }

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public String getIntern_executed() {
        return intern_executed;
    }

    public void setIntern_executed(String intern_executed) {
        this.intern_executed = intern_executed;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    @Override
    public String toString() {
        return "Task{" +
                "task_id=" + task_id +
                ", task_name='" + task_name + '\'' +
                ", intern_executed='" + intern_executed + '\'' +
                ", process='" + process + '\'' +
                '}';
    }
}
