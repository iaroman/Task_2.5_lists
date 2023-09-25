package pro.sky.task25list;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping
    public String welcome() {
        return "тестовое сообщение";
    }
    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String lastName, @RequestParam String firstName) throws EmployeeStorageIsFullException {
        return employeeService.addEmployeeList(lastName, firstName);
    }
    @GetMapping("/remove")
    public Employee remove(@RequestParam String lastName, @RequestParam String firstName) throws EmployeeNotFoundException {
        return employeeService.deleteEmployeeList(lastName, firstName);
    }
}
