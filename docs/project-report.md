# Linked List Management System — Project Report

## 1. Introduction
This project is a menu-driven Java console application that demonstrates dynamic data management using singly and doubly linked lists.

## 2. Objectives
- Implement linked-list nodes and links manually.
- Perform insertion, deletion, searching, updating, traversal, and utility operations.
- Compare singly and doubly linked lists.
- Apply time-complexity analysis and test edge cases.

## 3. Technology
- Language: Java
- Interface: Console
- Input: `Scanner`
- Data structures: Custom node classes and references

## 4. Design
`Main.java` handles the menus and input. `SinglyLinkedList.java` implements nodes with a `next` reference. `DoublyLinkedList.java` implements nodes with `prev` and `next` references and maintains both `head` and `tail`.

## 5. Algorithms
- Search: traverse nodes until a matching value is found.
- Reverse singly list: iteratively redirect `next` references using `previous`, `current`, and `next`.
- Reverse doubly list: swap each node's `prev` and `next` references, then swap `head` and `tail`.
- Sort: Bubble Sort by swapping node data.
- Remove duplicates: nested traversal, retaining the first occurrence.

## 6. Complexity
Most traversal-based operations take O(n). Insertion at the beginning is O(1). Singly-list insertion at end is O(n), while the doubly list uses a tail reference and inserts at end in O(1). Bubble Sort and the duplicate-removal implementation take O(n²).

## 7. Test cases
Test the empty list, one-node list, insertion/deletion at position 1, append at `count + 1`, invalid positions, missing values, duplicate values, zero and negative values, and reverse/sort on empty and one-node lists.

## 8. Conclusion
The application demonstrates the structure, operations, and complexity trade-offs of singly and doubly linked lists. The source code can be extended with automated tests or a graphical interface.

## 9. Before submission
Add student and course details, capture real screenshots of your own execution, and confirm the project compiles and behaves correctly in your environment.
