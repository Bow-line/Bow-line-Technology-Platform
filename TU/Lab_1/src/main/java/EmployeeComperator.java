import java.util.Comparator;

public class EmployeeComperator implements Comparator<Employee> {

    @Override
    public int compare(Employee w1, Employee w2) {
        int ret = w1.getSalary() - w2.getSalary();
        return ret;
    }
}



