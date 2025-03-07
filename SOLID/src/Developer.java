class Developer extends Employee {
    public Developer(String name, int id) {
        super(name, id);
    }

    public void writeCode() {
        System.out.println(getName() + " is writing code.");
    }
}