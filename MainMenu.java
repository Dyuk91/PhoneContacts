package phoneDirectory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainMenu  {

    public static void main(String[] args) {

        MainMenu menu = new MainMenu();
        Serialization ser = new Serialization();

        ser.Deserialization();
        menu.InfoMenu();
    }

    public void InfoMenu() {

        CreatingContact menu = new CreatingContact();

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

        CreatingContact menu = new CreatingContact();
        Serialization ser = new Serialization();
        ManagerMenuContact mmc = new ManagerMenuContact();
        ManagerMenuGroup mmg = new ManagerMenuGroup();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            try {
                System.out.print("Чтобы начать работу нажмите цифру, соответствующую пункту меню: ");
                String num = reader.readLine();
                System.out.println("*******************************************");
                switch (num) {
                    case ("1"): // Вывод на экран и поиск контактов
                        mmc.PrintAllContacts();
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
                        mmc.EditContact();
                        break;
                    case ("4")://Удалить контакт
                        mmc.DeleteContact();
                        break;
                    case ("5"):
                        mmg.PrintAllGroup();
                        break;
                    case ("6"):
                        mmg.CreateGroup();
                        break;
                    case ("7"):
                        mmg.EditGroup();
                        break;
                    case ("8"):
                        mmg.DeleteGroup();
                        break;
                    case ("9"):
                        mmg.DeleteAllGroup();
                        break;
                    case ("10"):
                        mmc.DeleteAllContact();
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
                throw new ClientException("Ошибка при вводе" , e);
        }
    }
}
