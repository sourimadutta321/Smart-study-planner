📚 Smart Study Planner

A Java-based console application that helps students manage study tasks intelligently using a multi-criteria priority scheduling algorithm.
📖 Project Overview

Students often struggle with managing multiple subjects, overlapping deadlines, and varying task priorities. The Smart Study Planner solves this by automatically generating a day-wise study schedule using a priority scheduling algorithm inspired by Earliest Deadline First (EDF) scheduling.

The planner takes your tasks, sorts them by deadline, priority, and estimated duration, then distributes them across study days — ensuring the most critical work is always done first.
✨ Features
Feature	Description
➕ Add Tasks	Create tasks with title, deadline, priority, and study time
📅 Smart Scheduling	Auto-generates a schedule using EDF + priority algorithm
✅ Mark Complete	Mark tasks as done; schedule regenerates automatically
📋 View Tasks	See all pending and completed tasks at a glance
💾 Persistence	All data saved to plain text files; loaded on next run
🧠 Scheduling Algorithm

The core algorithm is a Multi-Criteria Priority Scheduler:

    Priority Queue (min-heap) sorted by:

        Deadline → Earlier deadline = higher urgency (EDF)

        Priority Level → HIGH > MEDIUM > LOW

        Estimated Hours → Shorter tasks first (Tie-break)

    Distribution:

        First-Fit bin packing into daily study slots.

        Tasks are never placed after their deadline.

🏗️ Architecture
Plaintext

smart-study-planner/
│
├── src/main/java/com/studyplanner/
│   ├── Main.java                 ← Entry point
│   ├── model/                    ← Data containers
│   │   ├── Task.java             ← Implements Comparable
│   │   └── Priority.java         ← Type-safe enum
│   ├── service/                  ← Business logic
│   │   └── SchedulerService.java ← The Algorithm
│   ├── repository/               ← Data Storage
│   │   └── FileHandler.java      ← Text file I/O
│   └── util/                     ← Helpers
│       └── DateUtils.java        ← Formatting
│
├── data/
│   └── tasks.txt                 ← Persisted tasks
└── README.md

🛠️ Tech Stack

    Language: Java 25 (Standard Library)

    Data Structures: PriorityQueue, ArrayList, List

    Date Handling: java.time.LocalDate

    File I/O: BufferedReader, PrintWriter

⚙️ Setup & Running
Prerequisites

    Java 17 or higher installed

    VS Code with Java Extension Pack

Running the App

    Clone the repository
    Bash

    git clone https://github.com/sourimadutta321/Smart-study-planner.git
    cd Smart-study-planner

    Run in VS Code

        Open the folder in VS Code.

        Open Main.java.

        Press the Run button above the main method.

🖥️ Example Usage
Plaintext

  ╔════════════════════════════════════════╗
  ║        📚  SMART STUDY PLANNER         ║
  ╚════════════════════════════════════════╝

  1. Add Task
  2. Generate Smart Schedule
  3. View All Tasks
  4. Mark Task as Complete
  5. Exit

👨‍💻 Author

Sourima Dutta

    GitHub: @sourimadutta321