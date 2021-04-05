package phoneDirectory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;

public class MainMenu  {

    public static void main(String[] args) {

        MainMenu menu = new MainMenu();
        Serialization ser = new Serialization();

        ser.Deserialization();
        menu.InfoMenu();
    }

    public void InfoMenu() {

        ManagerContact menu = new ManagerContact();

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
        System.out.println();
        System.out.println("0. ВЫХОД ИЗ ПРОГРАММЫ");
        System.out.println("*******************************************");

        SelectionMenu();
    }

    public void SelectionMenu(){

        ManagerContact menu = new ManagerContact();
        Serialization ser = new Serialization();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            try {
                System.out.print("Чтобы начать работу нажмите цифру, соответствующую пункту меню: ");
                String num = reader.readLine();
                System.out.println("*******************************************");
                switch (num) {
                    case ("1"): // Вывод на экран и поиск контактов
                        menu.PrintAllContacts();
                        break;
                    case ("2"):// Создать контакт
                        menu.AllName();
                        menu.NumberMob();
                        menu.SkipNumberHome();
                        menu.Email();
                        menu.Group();
                        menu.SaveContact();
                        break;
                    case ("3"):// Редактирование контакта
                        menu.EditContact();
                        break;
                    case ("4")://Удалить контакт
                        menu.DeleteContact();
                        break;
                    case ("5"):
                        menu.PrintAllGroup();
                        break;
                    case ("6"):
                        menu.CreateGroup();
                        break;
                    case ("7"):
                        menu.EditGroup();
                        break;
                    case ("8"):
                        menu.DeleteGroup();
                        break;
                    case ("9"):
                        menu.DeleteAllGroup();
                        break;
                    case ("10"):
                        menu.DeleteAllContact();
                        break;
                    case ("0"):// Выход из программы с сохранением данных в файл
                        ser.Serialization();
                        System.out.println("УСПЕШНЫЙ ВЫХОД ИЗ ПРОГРАММЫ");
                        System.exit(0);
                    default:
                        SelectionMenu();
                        break;
                }

                InfoMenu();

            } catch (IOException e) {
                System.err.println("Ошибка ввода");
                e.printStackTrace();
        }
    }
}
