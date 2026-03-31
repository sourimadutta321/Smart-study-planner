package com.studyplanner.service;

import com.studyplanner.model.Task;
import java.util.*;
import java.util.stream.Collectors;

public class SchedulerService {
    public List<Task> generateSmartSchedule(List<Task> allTasks, double maxHours) {
        List<Task> sorted = allTasks.stream()
                .filter(t -> !t.isCompleted())
                .sorted()
                .collect(Collectors.toList());

        List<Task> schedule = new ArrayList<>();
        double currentHours = 0;
        for (Task t : sorted) {
            if (currentHours + t.getEstimatedHours() <= maxHours) {
                schedule.add(t);
                currentHours += t.getEstimatedHours();
            }
        }
        return schedule;
    }
}