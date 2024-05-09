package FileHandling.serialization;

import java.io.Serializable;

public class Employee implements Serializable {
    private static final long serialVersionUID = 131435146146156151L;
    private int id;
    private String empName;
    private double sal;

    public Employee(int id, String empName, double sal) {
        this.id = id;
        this.empName = empName;
        this.sal = sal;
    }

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", empName='" + empName + '\'' +
                ", sal=" + sal +
                '}';
    }
}
