package pro.sky.task25list;

public class EmployeeStorageIsFullException extends Exception{
    public EmployeeStorageIsFullException(String massage) {
        super(massage);
    }
}
