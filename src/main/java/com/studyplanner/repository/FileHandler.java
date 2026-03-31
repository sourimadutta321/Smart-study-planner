package com.studyplanner.repository;

import com.studyplanner.model.Priority;
import com.studyplanner.model.Task;
import java.io.*;
import java.nio.file.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    private static final String FILE_PATH = "data/tasks.txt";
    private static final String DELIMITER = ",";

    public FileHandler() {
        try { Files.createDirectories(Paths.get("data")); } catch (IOException ignored) {}
    }

    public void saveTasks(List<Task> tasks) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(FILE_PATH))) {
            for (Task t : tasks) {
                writer.write(String.join(DELIMITER, t.getId(), t.getTitle(), t.getSubject(), 
                    t.getDeadline().toString(), t.getPriority().name(), 
                    String.valueOf(t.getEstimatedHours()), String.valueOf(t.isCompleted())));
                writer.newLine();
            }
        } catch (IOException e) { System.err.println("Save Error: " + e.getMessage()); }
    }

    public List<Task> loadTasks() {
        List<Task> tasks = new ArrayList<>();
        if (!Files.exists(Paths.get(FILE_PATH))) return tasks;
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] p = line.split(DELIMITER);
                tasks.add(new Task(p[0], p[1], p[2], LocalDate.parse(p[3]), Priority.valueOf(p[4]), Double.parseDouble(p[5]), Boolean.parseBoolean(p[6])));
            }
        } catch (Exception e) { System.err.println("Load Error: " + e.getMessage()); }
        return tasks;
    }
}