package pro.sky.task25list;

public class EmployeeAlreadyAddedException extends Exception{
    public EmployeeAlreadyAddedException(String massage) {
        super(massage);
    }
}
