package com.studyplanner;

import com.studyplanner.model.*;
import com.studyplanner.repository.TaskRepository;
import com.studyplanner.service.SchedulerService;
import com.studyplanner.util.DateUtils;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final TaskRepository repo = new TaskRepository();
    private static final SchedulerService service = new SchedulerService();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Add 2. Smart Schedule 3. View All 4. Complete 5. Exit");
            String choice = sc.nextLine();
            if (choice.equals("1")) addTask();
            else if (choice.equals("2")) viewSchedule();
            else if (choice.equals("3")) repo.getAllTasks().forEach(System.out::println);
            else if (choice.equals("4")) markDone();
            else if (choice.equals("5")) break;
        }
    }

    private static void addTask() {
        try {
            System.out.print("Title: "); String t = sc.nextLine();
            System.out.print("Subject: "); String s = sc.nextLine();
            System.out.print("Deadline (YYYY-MM-DD): "); LocalDate d = DateUtils.parseDate(sc.nextLine());
            System.out.print("Priority (HIGH/MEDIUM/LOW): "); Priority p = Priority.valueOf(sc.nextLine().toUpperCase());
            System.out.print("Hours: "); double h = Double.parseDouble(sc.nextLine());
            repo.addTask(new Task(t, s, d, p, h));
        } catch (Exception e) { System.out.println("Error: " + e.getMessage()); }
    }

    private static void viewSchedule() {
        System.out.print("Available Hours: ");
        double h = Double.parseDouble(sc.nextLine());
        service.generateSmartSchedule(repo.getAllTasks(), h).forEach(System.out::println);
    }

    private static void markDone() {
        System.out.print("Enter Title: ");
        repo.findByTitle(sc.nextLine()).ifPresent(t -> { t.setCompleted(true); repo.saveAll(); });
    }
}
