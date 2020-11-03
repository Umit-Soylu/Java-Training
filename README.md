# Java-Training
This repository provides teaching materials for Java training.
## Getting Started
Following issues are introduced step by step at each commit. Please use the links provided to see code examples of the aforementioned issue.
### First Code
* [Hello World](https://github.com/Umit-Soylu/Java-Training/tree/HelloWorld) example for calling a java program from terminal.
### Core Concepts of Java
* [Variables](https://github.com/Umit-Soylu/Java-Training/tree/Variables) are described. Primitive & Hierarchical types are examplified. 
* [Methods](https://github.com/Umit-Soylu/Java-Training/tree/Methods) are described for return types and void types. 
* [Packages](https://github.com/Umit-Soylu/Java-Training/tree/Packages), which allows storing classes in their respected package hierarchy, is introduced.
* [Access Modifiers](https://github.com/Umit-Soylu/Java-Training/tree/Modifiers), which allows classes, methods, and variables visibility from different packages, classes, and methods, are introduced.
* [Program Flow](https://github.com/Umit-Soylu/Java-Training/tree/ProgramFlow) using following capabilities are introduced:
  - Arithmetic operators can be found in [Arithmetic Operators Package](src/com/bilgeadam/java/tutorials/program_flow/arithmetic_operators)
  - Assignment operators can be found in [Assignment Operators Package](src/com/bilgeadam/java/tutorials/program_flow/assignment_operators)
  - Relational operators can be found in [Relational Operators Package](src/com/bilgeadam/java/tutorials/program_flow/relational_operators)
  - Logical operators can be found in [Logical Operators Package](src/com/bilgeadam/java/tutorials/program_flow/logical_operators)
  - Decision operators can be found in [Decision Operators Package](src/com/bilgeadam/java/tutorials/program_flow/decision_operators)
* [Exceptions](https://github.com/Umit-Soylu/Java-Training/tree/Exceptions) is examplified using mathematical operands and tested via unit tests.
* [Constructors](https://github.com/Umit-Soylu/Java-Training/tree/Constructors) are defined. Default constructor and custom constructors are introduced.
## Object Oriented Java
* [Classes & Objects](https://github.com/Umit-Soylu/Java-Training/tree/ClassesObjects) A simple code for creating a class and and instantiating objects. (New keyword: `static`)
* Object Oriented Concepts
  - Aggregation concepts introduced in the [Aggregation Package](/com/bilgeadam/java/tutorials/enumeration/aggreagation/). (Test classes are under [here](/test/com/bilgeadam/java/tutorials/oop/aggregation/)) 
  - Inheritence concepts introduced in the [Inheritance Package](/com/bilgeadam/java/tutorials/enumeration/inheritance/). (Test classes are under [here](/test/com/bilgeadam/java/tutorials/oop/inheritance/)) (New keywords: `extends`, and `instanceof`)
  - Polymorphism concepts introduced in the [Polymorphism Package](/com/bilgeadam/java/tutorials/enumeration/inheritance/). (Test classes are under [here](/test/com/bilgeadam/java/tutorials/oop/inheritance/)) (New keywords: `@Override`, `final`, `this`, and `super`) 
  - Abstraction concepts introduced in the [Abstraction Package](/com/bilgeadam/java/tutorials/enumeration/abstraction/). (Test classes are under [here](/test/com/bilgeadam/java/tutorials/oop/abstraction/)) (New keywords: `interface`, `abstract`, and `implements`) 
## Common Java Classes
* [Enumeration](https://github.com/Umit-Soylu/Java-Training/tree/Enumeration) class is introduced with example cases. (New keywords: `enum`, and `ordinal`)
* [String](https://github.com/Umit-Soylu/Java-Training/tree/Strings) class is introduced with example cases. (New keywords: `String`, `StringBuilder` and `StringBuffer`)
* [Pattern and Matcher](https://github.com/Umit-Soylu/Java-Training/tree/PatternMatcher) class is introduced with example cases. (New keywords: `Pattern`, `Matcher`, `group`, `compile` and `regex`)
* [Date and Calendar](https://github.com/Umit-Soylu/Java-Training/tree/DateTime) class is introduced with example cases. (New keywords: `Date`, `before`, `after`, `getDisplayname`, and `Gregorian Calendar`)
## Advanced Concepts of Java
* [Collections](https://github.com/Umit-Soylu/Java-Training/tree/Collections) is introduced with its application classes. 
  - List concept and its application classes are in the [Arrays & Lists Package](/src/com/bilgeadam/java/tutorials/collections/arrays_lists/). (Test classes are under [here](/test/com/bilgeadam/java/tutorials/collections/arrays_lists/)) (New keywords: `Array`, `List`, `LinkedList` and `ArrayList`)
  - Queue concept and its application classes are in the [Queues Package](/src/com/bilgeadam/java/tutorials/collections/queues/). (Test classes are under [here](/test/com/bilgeadam/java/tutorials/collections/queues/)) (New keywords: `Queue`, `ArrayQueue`, `PriorityQueue` and `Stack`)
  - Set concept and its application classes are in the [Sets Package](/src/com/bilgeadam/java/tutorials/collections/sets/). (Test classes are under [here](/test/com/bilgeadam/java/tutorials/collections/sets/)) (New keywords: `Set`, `HashSet`, and `TreeSet`)
  - Collections real world example cases can be found [here](/src/com/bilgeadam/java/examples/). 
* [Lambda](https://github.com/Umit-Soylu/Java-Training/edit/Lambdas) is introduced. (New keywords: `@FunctionalInterface`, `lambda`, and `runnable`)  
* [Streams](https://github.com/Umit-Soylu/Java-Training/tree/Streams) is introduced with its application classes. (New keywords: `Stream`, `foreach`, `filter`, `count`, `limit`, `IntStream`, and much more)
* [File Input and Output](https://github.com/Umit-Soylu/Java-Training/tree/FileIO) is introduced with file interactions. (New keywords: `File`, `FileOutputStream`, `FileInputStream`, `FileWriter`, `FileReader`, `BufferedReader`, and much more)
* [Localization](https://github.com/Umit-Soylu/Java-Training/tree/Localization) is introduced with file interactions. (New keywords: `NumberFormat`, `DateTimeFormatter`, and `Locale`)
## Concurrency & Multithreading
* [Threads](https://github.com/Umit-Soylu/Java-Training/tree/Threads) are introduced. (New Keywords: `Thread`, `ThreadGroups`, `Priorities`, `start`, `run`, and `synchronized`)
  - Thread Synchronization, multithreading, and concurrency is introduced via [examples](https://github.com/Umit-Soylu/Java-Training/tree/Threads/src/com/bilgeadam/java/tutorials/examples) (New Keywords: `ThreadFactory`, `sleep`, `wait`, `notify`, and `notifyAll`)  
    - `Sleep` vs `Wait` explained.
    - Object locks explained  
