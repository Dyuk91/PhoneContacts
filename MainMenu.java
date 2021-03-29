package phoneDirectory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainMenu  {

    public static void main(String[] args) {

        MainMenu menu = new MainMenu();
        menu.infoMenu();
    }

    public void infoMenu() {
        CreateContact2 cr = new CreateContact2();
        cr.check();
        System.out.println("*******************************************");
        System.out.println("////////    ГЛАВНОЕ МЕНЮ    ///////////////");
        System.out.println("*******************************************");
        System.out.println("1.  ПРОСМОТР СПИСКА И ПОИСК КОНТАКТОВ");
        System.out.println("2.  СОЗДАТЬ КОНТАКТ");
        System.out.println("3.  РЕДАКТИРОВАТЬ КОНТАКТ");
        System.out.println("4.  УДАЛИТЬ КОНТАКТ");
        System.out.println("5.  ПРОСМОТР И ВЫБОР ГРУПП КОНТАКТОВ");
        System.out.println("6.  СОЗДАТЬ ГРУППУ");
        System.out.println("7.  РЕДАКТИРОВАНИЕ ГРУППЫ");
        System.out.println("8.  УДАЛИТЬ ГРУППУ");
        System.out.println("9.  УДАЛИТЬ ВСЕ ГРУППЫ");
        System.out.println("10. УДАЛИТЬ ВСЕ КОНТАКТЫ ");
        System.out.println(" ");
        System.out.println("0. ВЫХОД ИЗ ПРОГРАММЫ");
        System.out.println("*******************************************");

        selectionMenu();
    }

    public void selectionMenu(){

        CreateContact2 cr = new CreateContact2();
        Serializator ser = new Serializator();
        EditContacts ec = new EditContacts();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            try {
                System.out.print("Чтобы начать работу нажмите цифру, соответствующую пункту меню: ");
                String num = reader.readLine();
                System.out.println("*******************************************");
                switch (num) {
                    case ("1"): // Вывод на экран и поиск контактов
                        ser.printAllContacts();
                        break;
                    case ("2"):// Создать контакт
                        cr.AllName();
                        cr.NumberMob();
                        cr.skipNumberHome();
                        cr.Email();
                        cr.Group();
                        cr.Save();
                        infoMenu();
                        break;
                    case ("3"):// Редактирование контакта
                        ec.EditMenu();
                        break;
                    case ("4")://Удалить контакт
                        cr.RemoveContact();
                        break;
                    case ("5"):
                    case ("6"):
                    case ("7"):
                    case ("8"):
                    case ("9"):
                    case ("10"):
                        cr.DeleteAll();
                        break;
                    case ("0"):// Выход из программы с сохранением данных в файл
                        Serializator seriz = new Serializator();
                        seriz.serialization();
                        System.out.println("УСПЕШНЫЙ ВЫХОД ИЗ ПРОГРАММЫ");
                        System.exit(0);
                    default:
                        selectionMenu();
                        break;
                }
            } catch (IOException e) {
                System.out.println("Ошибка" + e);
        }
    }
}
