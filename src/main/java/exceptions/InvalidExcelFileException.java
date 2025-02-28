package exceptions;

public class InvalidExcelFileException extends FrameworkException{

    public InvalidExcelFileException(String message){
        super(message);
    }

    public InvalidExcelFileException(String message, Throwable cause){
        super(message, cause);
    }
}
