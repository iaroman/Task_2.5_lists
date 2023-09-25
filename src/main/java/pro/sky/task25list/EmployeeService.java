package pro.sky.task25list;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmployeeService {
    static private int counter;
    private List<Employee> employeeList = new ArrayList<>();
    private int maxEmployee = 5;

    public Employee addEmployeeList (String lastName, String firstName) throws EmployeeStorageIsFullException{
        Employee e = new Employee(lastName, firstName);
        if (counter == maxEmployee) {
            throw new EmployeeStorageIsFullException("Сотрудников уже много! Мест больше нет!");
        }
        else {
            employeeList.add(e);
            ++counter;
        }
        return e;
    }
    public Employee deleteEmployeeList (String lastName, String firstName) throws EmployeeNotFoundException{
        Employee e = new Employee(lastName, firstName);
        int i = employeeList.indexOf(new Employee(lastName, firstName));
        if (i != -1) {
            employeeList.remove(i);
            --counter;
        }
//        else {
//            throw new EmployeeNotFoundException("Этот человек у нас не работает");
//        }
        return new Employee(lastName, firstName);
    }
    public void findEmployeeList (String lastName, String firstName) throws EmployeeNotFoundException{
        if (!employeeList.contains(new Employee(lastName, firstName))) {
            throw new EmployeeNotFoundException("Этот человек у нас не работает");
        }
        employeeList.indexOf(new Employee(lastName, firstName));
    }

}
