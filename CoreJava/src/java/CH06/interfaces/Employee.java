package CH06.interfaces;

public class Employee implements Comparable<Employee> {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
    public void raiseSalary(double byPercent) {

        double raise = salary * byPercent / 100;
        salary = +raise;
    }


    @Override
    public int compareTo(Employee o) {
        return Double.compare(salary, o.salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

}
