package com.studyplanner.repository;

import com.studyplanner.model.Task;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TaskRepository {
    private List<Task> tasks;
    private final FileHandler fileHandler;

    public TaskRepository() {
        this.fileHandler = new FileHandler();
        this.tasks = fileHandler.loadTasks();
    }

    public void addTask(Task t) { tasks.add(t); fileHandler.saveTasks(tasks); }
    public List<Task> getAllTasks() { return new ArrayList<>(tasks); }
    public void saveAll() { fileHandler.saveTasks(tasks); }

    public Optional<Task> findByTitle(String title) {
        return tasks.stream().filter(t -> t.getTitle().equalsIgnoreCase(title)).findFirst();
    }
}