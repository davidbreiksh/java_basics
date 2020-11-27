import java.util.Comparator;

public class ObjectsComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return (int) (o1.getMonthSalary() - o2.getMonthSalary());
    }
}