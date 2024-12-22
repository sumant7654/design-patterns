# Design Patterns in Java

Welcome to the **Design Patterns in Java** repository! This repository showcases various design patterns implemented in Java, providing a comprehensive guide and practical examples for software developers.

## Table of Contents
- [Introduction](#introduction)
- [Patterns Covered](#patterns-covered)
- [Usage](#usage)
- [Examples](#examples)
- [Contributing](#contributing)
- [License](#license)

## Introduction
Design patterns are proven solutions to common problems in software design. They provide a template for how to solve a problem in various contexts and enhance code readability, reusability, and maintainability.

This repository aims to demonstrate how different design patterns can be implemented in Java, making it easier for developers to understand and apply these patterns in their projects.

## Patterns Covered
1. **Creational Patterns**
   - Singleton
   - Factory Method
   - Abstract Factory
   - Builder
   - Prototype

2. **Structural Patterns**
   - Adapter
   - Bridge
   - Composite
   - Decorator
   - Facade
   - Flyweight
   - Proxy

3. **Behavioral Patterns**
   - Chain of Responsibility
   - Command
   - Interpreter
   - Iterator
   - Mediator
   - Memento
   - Observer
   - State
   - Strategy
   - Template Method
   - Visitor


### Creational Patterns
1. Singleton: Ensures a class has only one instance and provides a global point of access to it. Useful when exactly one object is needed to coordinate actions across the system.
2. Factory Method: Defines an interface for creating an object, but lets subclasses alter the type of objects that will be created. Promotes loose coupling by eliminating the need to bind application-specific classes into the code.
3. Abstract Factory: Provides an interface for creating families of related or dependent objects without specifying their concrete classes. Useful for creating a suite of related products.
4. Builder: Separates the construction of a complex object from its representation, allowing the same construction process to create different representations. Particularly useful for creating complex objects step by step.
5. Prototype: Allows cloning of existing objects without making the code dependent on their classes. Useful when the cost of creating a new object is more expensive than cloning an existing one.

### Structural Patterns
1. Adapter: Allows incompatible interfaces to work together. This pattern converts the interface of a class into another interface that clients expect.
2. Bridge: Decouples an abstraction from its implementation so that the two can vary independently. Useful when both the abstractions and their implementations should be extensible.
3. Composite: Composes objects into tree structures to represent part-whole hierarchies. Composite lets clients treat individual objects and compositions of objects uniformly.
4. Decorator: Adds additional responsibilities to an object dynamically. Decorators provide a flexible alternative to subclassing for extending functionality.
5. Facade: Provides a simplified interface to a complex subsystem. It shields clients from complex subsystem components and makes the subsystem easier to use.
6. Flyweight: Uses sharing to support large numbers of fine-grained objects efficiently. Flyweight reduces memory use by sharing as much data as possible with other similar objects.
7. Proxy: Provides a surrogate or placeholder for another object to control access to it. Useful for controlling access, lazy initialization, logging, etc.

### Behavioral Patterns
1. Chain of Responsibility: Passes a request along a chain of handlers. Each handler can either handle the request or pass it to the next handler in the chain.
2. Command: Encapsulates a request as an object, thereby allowing for parameterization of clients with queues, requests, and operations. Supports undoable operations.
3. Interpreter: Defines a representation of the grammar for a language and an interpreter that uses the representation to interpret sentences in the language.
4. Iterator: Provides a way to access the elements of an aggregate object sequentially without exposing its underlying representation.
5. Mediator: Defines an object that encapsulates how a set of objects interact. Mediator promotes loose coupling by keeping objects from referring to each other explicitly.
6. Memento: Captures and externalizes an object's internal state so that it can be restored later, without violating encapsulation. Useful for implementing undo and redo features.
7. Observer: Defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.
8. State: Allows an object to alter its behavior when its internal state changes. The object will appear to change its class.
9. Strategy: Defines a family of algorithms, encapsulates each one, and makes them interchangeable. Strategy lets the algorithm vary independently from the clients that use it.
10. Template Method: Defines the skeleton of an algorithm in a method, deferring some steps to subclasses. Template Method lets subclasses redefine certain steps of an algorithm without changing the algorithm's structure.
<!--11. Visitor: Represents an operation to be performed on the elements of an object structure. Visitor lets you define a new operation without changing the classes of the elements on which it operates.
-->


## Usage
To explore and use the design patterns, clone this repository to your local machine using the following command:

```sh
git clone https://github.com/sumant7654/design-patterns.git

