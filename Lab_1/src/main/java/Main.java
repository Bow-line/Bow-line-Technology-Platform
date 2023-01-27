import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String [] args) {

        Set<Employee> e1 = new HashSet<Employee>();
        Set<Employee> e1_2 = new HashSet<Employee>();
        Set<Employee> e2 = new HashSet<Employee>();
        Set<Employee> e2_2 = new HashSet<Employee>();
        Set<Employee> e3 = new HashSet<Employee>();
        Set<Employee> e3_2 = new HashSet<Employee>();
        Set<Employee> e3_3 = new HashSet<Employee>();

        Employee emp1 = new Employee("Jack","Minister","Ministry of Science",3,15500, e1); //ap 1
        Employee emp2 = new Employee("Robert","Vice-Minister","Ministry of Social Affairs",4,12000, e1_2); //ap1
        Employee emp3 = new Employee("Emily","Minister","Ministry of Social Security",2,10000, new HashSet<Employee>()); //ap1
        Employee emp4 = new Employee("James","Vice-Minister","Ministry of Sports",8,14000, e2);
        Employee emp5 = new Employee("Oliver","Minister","Ministry of Home Affairs",7,12365, e2_2);
        Employee emp6 = new Employee("Daniel","Vice-Minister","Ministry of Justice",1,8000, new HashSet<Employee>());
        Employee emp7 = new Employee("Emma","Vice-Minister","Ministry of Labor",9,9000, e3);
        Employee emp8 = new Employee("Georgia","Minister","Ministry of Religious Affairs",6,11500, e3_2);
        Employee emp9 = new Employee("Elizabeth","Minister","Ministry of Piece",2,12000, e3_3);
        Employee emp10 = new Employee("Rupert","Minister","Ministry of Magic",3,10000, new HashSet<Employee>());

        e1.add(emp2);
        e1_2.add(emp3);

        e2.add(emp5);
        e2_2.add(emp6);

        e3.add(emp8);
        e3_2.add(emp9);
        e3_3.add(emp10);



        Set<Employee> hashSet = new HashSet<Employee>();
        hashSet.add(emp1);
        hashSet.add(emp2);
        hashSet.add(emp3);
        hashSet.add(emp4);
        hashSet.add(emp5);
        hashSet.add(emp6);
        hashSet.add(emp7);
        hashSet.add(emp8);
        hashSet.add(emp9);
        hashSet.add(emp10);


        switch(args[0]){
            case "no_sort"-> {
                System.out.println("no_sort");
                System.out.println(hashSet);
            }
            case"sort" -> {
                System.out.println("sort");
                TreeSet<Employee> tree = new TreeSet<Employee>(hashSet);
                System.out.println(tree);
            }

            case "alt_sort" -> {
                System.out.println("alt_sort");
                TreeSet<Employee> altS = new TreeSet<Employee>(hashSet);
                Set<Employee> sorted = new TreeSet<Employee>(new EmployeeComperator());
                sorted.addAll(altS);
                System.out.println(sorted);
            }
        }
    }

}
