// Violates ISP: A worker who does not need to print is forced to implement print()
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

// Corrected ISP: Split interfaces into smaller, more specific ones
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
