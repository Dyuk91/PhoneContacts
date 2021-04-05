package phoneDirectory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Serialization {

    private static List<Contacts> LIST = ManagerContact.getLIST();
    private static List <String> ListGroup = ManagerContact.getListGroup();

    public void Serialization() {

        try (ObjectOutputStream oos1 = new ObjectOutputStream(new FileOutputStream("Contacts")); ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream("Group"))) { // Метод try-with-resources. Метод close() работает по умолчанию.

            oos1.writeObject(LIST);

            oos2.writeObject(ListGroup);

        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Ошибка");
            e.printStackTrace();
        }
    }

    public void Deserialization() {

        try (ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream("Contacts")); ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream("Group"))) {

            LIST = (List) ois1.readObject();

            ListGroup = (List) ois2.readObject();

        } catch (ClassNotFoundException e) {
            System.err.println("Ошибка");
            e.printStackTrace();
        } catch (FileNotFoundException e) {
//            System.err.println("Ошибка");
//            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Ошибка");
            e.printStackTrace();
        }
    }
}
