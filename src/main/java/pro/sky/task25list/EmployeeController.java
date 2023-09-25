package pro.sky.task25list;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping
    public List<Employee> showAllListEmployee() {
        return employeeService.getEmployeeList();
    }
    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String lastName, @RequestParam String firstName) {
        return employeeService.addEmployeeList(lastName, firstName);
    }
    @GetMapping("/remove")
    public Employee remove(@RequestParam String lastName, @RequestParam String firstName) {
        return employeeService.deleteEmployeeList(lastName, firstName);
    }
    @GetMapping("/find")
    public Employee find(@RequestParam String lastName, @RequestParam String firstName) {
        return employeeService.findEmployeeList(lastName, firstName);
    }
}
