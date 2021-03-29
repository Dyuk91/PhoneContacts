package phoneDirectory;

import java.io.*;
import java.util.List;

import static phoneDirectory.CreateContact2.LIST;


public class Serializator {

    List<Contacts> list;

    public void serialization() {

        try {

            FileOutputStream fos = new FileOutputStream("cont1"); //для записи последовательности байтов

            ObjectOutputStream oos = new ObjectOutputStream(fos); // для записи файлов

            oos.writeObject(LIST);


            oos.writeObject(LIST);

            oos.close();

        } catch (FileNotFoundException e) {
            System.out.println("Ошибка" + e);
        } catch (IOException e) {
            System.out.println("Ошибка" + e);
        }
    }

    public void printAllContacts() {

        MainMenu menu = new MainMenu();
        System.out.println("///////////////   СПИСОК КОНТАКТОВ   ///////////////");

                if (LIST.isEmpty()){
                    System.out.println("Список пуст");
                    menu.infoMenu();
                }
                if(!LIST.isEmpty()){
                    for (Contacts con : LIST) {
                        System.out.println(con);
                    }
                    searchContact();
                }
    }

    public void searchContact (){
        System.out.println("*******************************************");
        System.out.print("Чтобы найти контакт нажмите '1' , чтобы выйти в ГЛАВНОЕ МЕНЮ нажмите любую клавишу: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String search = reader.readLine();
            switch (search){
                case ("1"):
                    System.out.println("Для поиска в списке введите данные контакта: ");
                    String search2 = reader.readLine();

                    for (Contacts con : LIST) {
                        if (con.getName().equals(search2) || con.getLastname().equals(search2) || con.getPatronymic().equals(search2)) {
                            System.out.println(con);
                        }
                    }
                    searchContact();
                default:
                    MainMenu menu = new MainMenu();
                    menu.infoMenu();
            }
        } catch (IOException e) {
            System.out.println("Ошибка" + e);
        }
    }
}