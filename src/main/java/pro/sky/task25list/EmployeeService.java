package pro.sky.task25list;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmployeeService {
    /*    static private int counter;*/
    private List<Employee> employeeList = new ArrayList<>();
/*    private int maxEmployee = 5;*/
    public List<Employee> getEmployeeList() {
        return employeeList;
    }
    public Employee addEmployeeList (String lastName, String firstName) {
        if (employeeList.size() == 5) {
            throw new EmployeeStorageIsFullException("Сотрудников уже много! Мест больше нет!");
        }
        String fullName = lastName + firstName;
        for (Employee employee : employeeList) {
            if ((employee.getLastName()+employee.getFirstName()).equals(fullName)) {
                throw new EmployeeAlreadyAddedException("Такой сотрудник уже работает!");
            }
        }
        Employee e = new Employee(lastName, firstName);
        employeeList.add(e);
        return e;
    }
    public Employee deleteEmployeeList (String lastName, String firstName) {
        Employee e = findEmployeeList(lastName, firstName);
        employeeList.remove(employeeList.indexOf(e));
        return e;
    }
    public Employee findEmployeeList (String lastName, String firstName) {
        String fullName = lastName + firstName;
        for (Employee employee : employeeList) {
            if ((employee.getLastName()+employee.getFirstName()).equals(fullName)) {
                return employee;
            }
        }
        throw new EmployeeNotFoundException("Этот сотрудник не найден");
    }
}
