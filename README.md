# ENSF 338 - Practical Data Structures and Algorithms
## Winter 2023

### Project Outline

**Objective:**
The objective of this project is to create a library for common data structures, including various linear data structures, tree structures, and graph algorithms.

### Implementation Options

You can choose to implement this project in either one of the following languages:
1. Java
2. Python

**Note:** The screenshots in this document are made with the assumption of implementing using Java. However, if you choose Python as the language of choice, your project folder will have a similar hierarchy.

### Project Description

In this project, you will develop your own library of data structures with their associated algorithms. The library will have a multilevel structure to separate each group of data structures into groups based on their class.

The library will be created with a package name "myLib" and will have the following underlying structure:

#### Datastructures
- Contains subfolders for each class of data structures we are implementing.
  - Linear
    - Includes the class implementations of all the linear data structures listed below (you can use the short acronyms).
      - SinglyLinkedList (SLL)
      - DoublyLinkedList (DLL)
      - CircularLinkedList (CSLL)
      - CircularDoublyLinkedList (CDLL)
      - Stack
      - Queue
  - Trees
    - Contains the implementations of the following tree structures:
      - BinarySearchTrees (BST)
      - AVL
  - Heaps
    - Contains two implementations of the vector-based heap class (VBH), one for max heap and one for min heap.
      - The class has a heapsort static function that receives an array, creates a heap structure, and sorts it, then returns it.
  - Nodes
    - Contains the implementation of all the different node classes needed for the data structures mentioned above.

#### Graphalgo
- This folder will have a static class with static methods that apply the different graph algorithms mentioned below.
  - Graphalgo
    - BFS
    - DFS
    - Dijkstra

**Note:** All data structures will be implemented for integer data types as the data member. You can extend your work by making the structures work with generic data types for a bonus, as will be shown in the final project rubric evaluation.

### Testing

You will need to test all functionalities of the data structure by either:

1. Writing a main app program that will comprehensively test the data structures by creating objects of them and testing all the possible functionalities.
2. Using unit tests (Junit for Java that will be written in the test subfolder of your project, or pytest or unittest for Python).

### Project Finalization

To finalize and complete your project, you will build the project using Maven (for Java) to generate a `myLibrary.jar` file. This will be your compiled library that you can copy into any project and import it to use your data structure implementations whenever needed.

The TAs will be testing your project by importing your library jar file into a tester program to run some tests. It is essential to adhere to naming conventions that will be published in each module separately.

(Python implementation will also have to be packaged – instructions on how to achieve that will be published later).

### Project Submission and Deadline

The deadline for the project's final submission is:
- Monday, 10th of April at 12:00 PM.
