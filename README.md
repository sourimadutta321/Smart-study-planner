# 📚 Smart Study Planner
A Java-based console application that helps students manage study tasks intelligently using a multi-criteria priority scheduling algorithm.

## ✨ Features
| Feature | Description |
| :--- | :--- |
| **➕ Add Tasks** | Create tasks with title, deadline, priority, and study time |
| **📅 Smart Scheduling** | Auto-generates a schedule using EDF + priority algorithm |
| **✅ Mark Complete** | Mark tasks as done; schedule regenerates automatically |
| **📋 View Tasks** | See all pending and completed tasks at a glance |
| **💾 Persistence** | All data saved to plain text files; loaded on next run |

## 🏗️ Architecture
```text
smart-study-planner/
├── src/main/java/com/studyplanner/
│   ├── Main.java                 <-- Entry point
│   ├── model/                    <-- Task.java, Priority.java
│   ├── service/                  <-- SchedulerService.java
│   ├── repository/               <-- FileHandler.java
│   └── util/                     <-- DateUtils.java
├── data/
│   └── tasks.txt                 <-- Database File
└── README.md
```

## 🛠️ Tech Stack
Language: Java 25 (Standard Library)

Data Structures: PriorityQueue, ArrayList, List

Date Handling: java.time.LocalDate

File I/O: BufferedReader, PrintWriter

## ⚙️ Setup & Running
Prerequisites

    Java 17 or higher installed

    VS Code with Java Extension Pack

Running the App

    Open the project in VS Code.

    Navigate to src/main/java/com/studyplanner/Main.java.

    Click the Run button above the main method

## 🖥️ Example Usage
╔════════════════════════════════════════╗
║        📚  SMART STUDY PLANNER         ║
╚════════════════════════════════════════╝

  1. Add Task
  2. Generate Smart Schedule
  3. View All Tasks
  4. Mark Task as Complete
  5. Exit

## 👨‍💻 Author
Sourima Dutta GitHub: @sourimadutta321
