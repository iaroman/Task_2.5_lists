package pro.sky.task25list;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// непроверяемое исключение
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Этот сотрудник не найден")
public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(String massage) {
        super(massage);
    }
}
