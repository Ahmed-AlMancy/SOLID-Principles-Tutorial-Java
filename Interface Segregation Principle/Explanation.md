`Explanation`: It states That a class Should not be forced to depend upon methods that they don't use, Interfaces Belongs to Clients not to hierarchies, In another words, Clients should not be forced to depend on interfaces they don't use.
----
### Interface Segregation Principle (ISP) Violation and Fix

#### ISP Violation
The original code violates ISP because `Developer` is forced to implement a method (`print()`) that it does not need:
```java
interface Worker {
    void work();
    void print();
}

class Developer implements Worker {
    public void work() {
        System.out.println("Writing code...");
    }

    public void print() {
        throw new UnsupportedOperationException("Developers don’t need to print.");
    }
}
```
`Issue`: The `Worker interface` forces `all workers` to implement both `work()` and `print()`, even if they `don’t need both`.
`Breaks ISP`: Clients should not be forced to depend on methods they do not use.
----
## The Fix: 
```java
interface Workable {
    void work();
}

interface Printable {
    void print();
}

class Developer implements Workable {
    public void work() {
        System.out.println("Writing code...");
    }
}

class OfficeAssistant implements Workable, Printable {
    public void work() {
        System.out.println("Managing office tasks...");
    }

    public void print() {
        System.out.println("Printing documents...");
    }
}
```
Now, `Developer` only implements `Workable`, avoiding unnecessary methods.
`OfficeAssistant` implements both `Workable` and `Printable`, as it needs both functionalities.
ISP is maintained: Each class only depends on the interfaces it actually uses.
---
