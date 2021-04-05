package phoneDirectory;

import java.util.Collection;
import java.io.*;
import java.util.List;

public class Serialization {

    public void Serialization() {

        try (ObjectOutputStream oos1 = new ObjectOutputStream(new FileOutputStream("Contacts")); ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream("Group"))) { // Метод try-with-resources. Метод close() работает по умолчанию.

            oos1.writeObject(CreatingContact.getLIST());

            oos2.writeObject(CreatingContact.getListGroup());

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

            CreatingContact.setLIST((List) ois1.readObject());
            CreatingContact.setListGroup((List) ois2.readObject());

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
