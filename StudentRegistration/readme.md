# 🎓 Student Registration System

A JavaFX desktop application for managing student records. Built as part of an Object-Oriented Programming course using Java and FXML.

---

## 📋 Overview

This app allows users to manage a list of students through a graphical interface. Each student has an ID, name, GPA, and major. The system supports adding, removing, searching, and sorting students, as well as finding top performers.

---

## ✨ Features

| Feature                  | Description                                                |
| ------------------------ | ---------------------------------------------------------- |
| Add Student              | Register a new student with ID, name, GPA, and major       |
| Remove Student           | Delete a student record by ID                              |
| Search by Name           | Find all students matching a given name (case-insensitive) |
| Search by ID             | Look up a specific student by their unique ID              |
| Top in All Majors        | Display the student with the highest GPA across all majors |
| Top in Specific Major    | Find the top student within a chosen major                 |
| Sort by GPA (Ascending)  | List all students from lowest to highest GPA               |
| Sort by GPA (Descending) | List all students from highest to lowest GPA               |


---

## 🧱 Project Structure

```
src/
└── studentregistration/
    ├── studentregistration.java        # App entry point (JavaFX Application)
    ├── Student.java                    # Student model (ID, name, GPA, major)
    ├── StudentList.java                # Core logic (add, remove, search, sort)
    ├── StdRegistrationController.java  # UI controller — connects FXML to logic
    └── StdRegistration.fxml            # UI layout (built with JavaFX FXML)
```

---

## 🔧 How It Works

### `Student.java`
Represents a single student. Key rules:
- **ID** cannot be changed once set
- **GPA** must be between 0 and 100

### `StudentList.java`
Manages the list of students using an `ArrayList`. Key behaviors:
- Duplicate IDs are rejected with a warning alert
- Students are removed using an `Iterator` to avoid modification errors
- Search by name is case-insensitive
- Top student is found using Java Stream API (`max` with `Comparator`)

### `StdRegistrationController.java`
Handles all UI events (button clicks). Reads input from `TextField` components, calls `StudentList` methods, and shows results via `Alert` dialogs.

---

## 🛠️ Tech Stack

- **Java** — Core language
- **JavaFX** — GUI framework
- **FXML** — UI layout definition
- **Java Stream API** — For sorting and finding top students
- **NetBeans IDE** — Development environment

---

## ▶️ How to Run

1. Open the project in **NetBeans IDE**
2. Make sure **JavaFX** is configured in your project libraries
3. Click **Run > Run Project** (or press `F6`)

---

## 📌 Notes

- Data is stored **in memory only** — no database or file persistence
- All input validation is handled in the controller with try/catch blocks
