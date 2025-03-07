class Manager extends Employee {
    public Manager(String name, int id) {
        super(name, id);
    }

    public void conductMeeting() {
        System.out.println(getName() + " is conducting a meeting.");
    }
}