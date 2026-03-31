package com.studyplanner.model;

import java.util.List;

public class StudySchedule {
    private List<Task> scheduledTasks;

    public StudySchedule(List<Task> scheduledTasks) {
        this.scheduledTasks = scheduledTasks;
    }

    public List<Task> getScheduledTasks() {
        return scheduledTasks;
    }
}