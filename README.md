# Linked List Management System

A menu-driven Java console application for learning and demonstrating **Singly Linked Lists** and **Doubly Linked Lists**. The nodes and linked-list operations are implemented manually; Java's built-in `LinkedList` and `ArrayList` are not used.

## Features

### Singly Linked List
- Insert at beginning, end, position, before a value, and after a value
- Delete from beginning, end, position, and by value
- Search and update
- Display and count nodes
- Find maximum, minimum, and middle element
- Reverse, sort in ascending order, and remove duplicates

### Doubly Linked List
- All the operations above
- Display forward and backward
- Maintains both `head` and `tail` references

### Other features
- Main menu and separate operation menus
- Integer input validation
- Clear messages for empty lists, missing values, and invalid positions
- Singly-vs-doubly comparison table

## Requirements
- Java Development Kit (JDK) 14 or later (switch-arrow syntax is used)
- Terminal or command prompt

## How to run

Open a terminal in the project folder and run:

```bash
javac src/*.java
java -cp src Main
```

On Windows, these commands also work in Command Prompt or PowerShell if the JDK is installed and `javac` is on PATH.

## Implementation notes
- Positions are 1-based.
- Insert at position `count + 1` appends to the end.
- Search, update, insert-before/after, and delete-by-value act on the first matching value.
- For an even-length list, `middle()` returns the second middle element.
- The doubly linked list stores both `head` and `tail`, so insertion/deletion at the end can be O(1).
- Sort uses Bubble Sort by swapping node data.
- Duplicate removal uses nested traversal and runs in O(n²) time.

## Typical time complexity

| Operation | Singly Linked List | Doubly Linked List |
|---|---:|---:|
| Insert at beginning | O(1) | O(1) |
| Insert at end | O(n) | O(1) |
| Insert/delete at position | O(n) | O(n) |
| Delete at beginning | O(1) | O(1) |
| Delete at end | O(n) | O(1) |
| Search/display/count | O(n) | O(n) |
| Find min/max/middle | O(n) | O(n) |
| Reverse | O(n) | O(n) |
| Bubble Sort | O(n²) | O(n²) |
| Remove duplicates | O(n²) | O(n²) |

## Repository structure

```text
Linked-List-Management-System/
├── src/
│   ├── Main.java
│   ├── SinglyLinkedList.java
│   └── DoublyLinkedList.java
├── sample-output/
│   └── output.txt
├── docs/
│   └── project-report.md
├── README.md
└── .gitignore
```

## Author
Talari Yashwanth
