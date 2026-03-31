package com.studyplanner.model;

import com.studyplanner.util.DateUtils;
import java.time.LocalDate;
import java.util.UUID;

public class Task implements Comparable<Task> {
    private final String id;
    private String title;
    private String subject;
    private LocalDate deadline;
    private Priority priority;
    private double estimatedHours;
    private boolean isCompleted;

    public Task(String title, String subject, LocalDate deadline, Priority priority, double estimatedHours) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.subject = subject;
        this.deadline = deadline;
        this.priority = priority;
        this.estimatedHours = estimatedHours;
        this.isCompleted = false;
    }

    public Task(String id, String title, String subject, LocalDate deadline, Priority priority, double estimatedHours, boolean isCompleted) {
        this.id = id;
        this.title = title;
        this.subject = subject;
        this.deadline = deadline;
        this.priority = priority;
        this.estimatedHours = estimatedHours;
        this.isCompleted = isCompleted;
    }

    @Override
    public int compareTo(Task other) {
        int dateCompare = this.deadline.compareTo(other.deadline);
        if (dateCompare != 0) return dateCompare;
        int priorityCompare = Integer.compare(other.priority.getLevel(), this.priority.getLevel());
        if (priorityCompare != 0) return priorityCompare;
        return Double.compare(this.estimatedHours, other.estimatedHours);
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getSubject() { return subject; }
    public LocalDate getDeadline() { return deadline; }
    public Priority getPriority() { return priority; }
    public double getEstimatedHours() { return estimatedHours; }
    public boolean isCompleted() { return isCompleted; }
    public void setCompleted(boolean completed) { isCompleted = completed; }

    @Override
    public String toString() {
        return String.format("[%s] %-15s | %-10s | Due: %s | Priority: %-6s | Hrs: %.1f",
                isCompleted ? "DONE" : "TODO", title, subject, DateUtils.formatForDisplay(deadline), priority, estimatedHours);
    }
}