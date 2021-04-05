package phoneDirectory;

public class ClientException extends RuntimeException {
    public ClientException(String message, Throwable cause) {
        super(message, cause);
    }
    public ClientException() {
        System.out.println("Клиентская ошибка вывода");
    }
}
