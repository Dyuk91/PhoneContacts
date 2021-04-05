package phoneDirectory;

public class ClientExeption  extends RuntimeException {
    public ClientExeption(String message, Throwable cause) {
        super(message, cause);
    }
    public ClientExeption() {
        System.out.println("Клиентская ошибка вывода");
    }
}
