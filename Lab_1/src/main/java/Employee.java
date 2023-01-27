import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Employee implements Comparable<Employee>{
    private String name;
    private String jobTitle;
    private String department;
    private int clearanceLevel;
    private int salary;
    private Set<Employee> subordinence;

    public Employee (String name, String jobTitle, String department, int clearanceLevel, int salary, Set<Employee> subordinence){
        this.name = name;
        this.jobTitle = jobTitle;
        this.department = department;
        this.clearanceLevel = clearanceLevel;
        this.salary = salary;
        this.subordinence = subordinence;


    }

    public void addEmployee(Employee other){
        this.subordinence.add(other);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getClearanceLevel() {
        return clearanceLevel;
    }

    public void setClearanceLevel(int clearanceLevel) {
        this.clearanceLevel = clearanceLevel;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Set<Employee> getSubordinence() {
        return subordinence;
    }

    public void setSubordinence(Set<Employee> subordinence) {
        this.subordinence = subordinence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return salary == employee.salary && Objects.equals(name, employee.name) && Objects.equals(jobTitle, employee.jobTitle) && Objects.equals(department, employee.department) && Objects.equals(clearanceLevel, employee.clearanceLevel) && Objects.equals(subordinence, employee.subordinence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, jobTitle, department, clearanceLevel, salary, subordinence);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", department='" + department + '\'' +
                ", cleorenceLevel='" + clearanceLevel + '\'' +
                ", salary=" + salary +
                ", subordinence=" + subordinence +
                '}';
    }
    @Override
    public int compareTo(Employee other) {
        if(this.clearanceLevel > other.clearanceLevel){
            return -1;
        }
        else if (this.clearanceLevel < other.clearanceLevel){
            return 1;
        }
        else {
            return 0;
        }
    }

}
