# Library Management System

This is project that I have worked on in class. Basically it is a Library Management System written in Java that manages books and library members. I added built in features such as being about to add a book, view it, or search one up. While the system can also issue, return, or list a borrowed book.  
This is similar to the bank project that I made but instead this project dived deeper in object-oriented programming and data structures instead of Java’s Scanner input approach.

---

## Features

-Book Management –> Add new books with details like title, author, and ID.
-Member Management –> Add new members and keep track of their borrowed books.
-Borrowing System –> Members can borrow and return books, updating the library’s available stock.
-Display Book – View lists of all books currently in the system by searching ISBN, title, or author.

---

## How It Works

-The program defines three main classes:

  -Book.java: Represents each book, containing details like title, author, ID, and availability.
  -Member.java: Represents each library member, tracking their name, ID, and borrowed books.
  -LibraryManagementSystem.java: The main class that connects everything, initializing lists of books and members and performing operations (add, view, borrow, return).

-Instead of reading inputs line-by-line, it programmatically manages all records through lists and object manipulation, showing how data structures can be used to simulate real-world operations in a digital library.

---

## Purpose

This project was created to find more intuative apporach into how object-oriented programming and data structures can be used to manage real-world systems. It’s an evolution from simpler projects (like the bank project) by focusing on efficient data handling, code organization, and reusability.

---

## Example Workflow

1. Create book and member objects.
2. Add them to the library’s Hashmap.
3. Perform actions such as borrowing or returning a book.
4. Display updated library records.

---

Language: Java
Concepts Used: Classes, Objects, Hashmaps, Encapsulation, Methods
