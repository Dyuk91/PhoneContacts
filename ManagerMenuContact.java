package phoneDirectory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;

public class ManagerMenuContact {

    public void PrintAllContacts() {

        MainMenu menu = new MainMenu();

        System.out.println("///////////////   СПИСОК КОНТАКТОВ   ///////////////");

        if (CreatingContact.getLIST().isEmpty()) {
            System.out.println("Список пуст");
            menu.InfoMenu();
        }

        Collections.sort(CreatingContact.getLIST(), Comparator.comparing(Contacts::getName));

        for (Contacts con : CreatingContact.getLIST()) {
            System.out.println(con);
        }
            SearchContact();
    }

    public void SearchContact() {
        System.out.println("*******************************************");
        System.out.print("Чтобы найти контакт нажмите '1' , чтобы выйти в ГЛАВНОЕ МЕНЮ нажмите любую клавишу: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String search = reader.readLine();
            switch (search) {
                case ("1"):
                    System.out.println("Для поиска в списке введите данные контакта: ");
                    String search2 = reader.readLine();

                    for (Contacts con : CreatingContact.getLIST()) {
                        if (con.getName().equals(search2) || con.getLastname().equals(search2) || con.getPatronymic().equals(search2)) {
                            System.out.println(con);
                        }
                    }
                    SearchContact();
                    break;
                default:
                    MainMenu menu = new MainMenu();
                    menu.InfoMenu();
                    break;
            }
        } catch (IOException e) {
            throw new ClientException("Ошибка при вводе" , e);
        }
    }

    public void EditContact() {

        BufferedReader reader45 = new BufferedReader(new InputStreamReader(System.in));

        if (CreatingContact.getLIST().isEmpty()) {
            System.out.println("Список пуст. Редактирование невозможно");
            MainMenu menu = new MainMenu();
            menu.InfoMenu();
        }

        try {

            MainMenu menu = new MainMenu();
            CreatingContact cc = new CreatingContact();

            System.out.print("Введите название контакта, которого нужно изменить: ");
            String name = reader45.readLine();

            for (Contacts con : CreatingContact.getLIST()) {
                if (con.getName().equals(name) || con.getLastname().equals(name) || con.getPatronymic().equals(name)) {
                    System.out.println(con);
                    System.out.print("Чтобы изменить выбраный контакт нажмите '1' , чтобы выйти в ГЛАВНОЕ МЕНЮ нажмите любую кнопку: ");
                    String num = reader45.readLine().trim();
                    switch (num) {
                        case ("1"):
                            CreatingContact.getLIST().remove(con);
                            con = new Contacts();
                            cc.AllName();
                            cc.NumberMob();
                            cc.SkipNumberHome();
                            cc.Email();
                            cc.Group();
                            CreatingContact.getLIST().add(con);
                            menu.InfoMenu();
                            break;
                        default:
                            menu.InfoMenu();
                            break;
                    }
                } else {
                    System.out.println("Запрашивыемого контакта нет в списке");
                    menu.InfoMenu();
                }
            }
        } catch (IOException e) {
            throw new ClientException("Ошибка при вводе" , e);
        }
    }

    public void DeleteContact() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        MainMenu menu = new MainMenu();

        if (CreatingContact.getLIST().isEmpty()) {
            System.out.println("Список пуст. Удаление невозможно");
            menu.InfoMenu();
        }

        try {
            System.out.print("Введите название контакта, которого нужно удалить: ");
            String name = reader.readLine().trim();
            for (Contacts con : CreatingContact.getLIST()) {
                if (con.getName().equals(name) || con.getLastname().equals(name) || con.getPatronymic().equals(name)) {
                    System.out.println(con);
                    System.out.print("Чтобы удалить выбраный контакт нажмите '1' , чтобы выйти в ГЛАВНОЕ МЕНЮ нажмите любую кнопку: ");
                    String num = reader.readLine().trim();
                    switch (num) {
                        case ("1"):
                            System.out.println("Контакт удален --> " + con);
                            CreatingContact.getLIST().remove(con);
                            menu.InfoMenu();
                            break;
                        default:
                            menu.InfoMenu();
                            break;
                    }
                }
            }

            System.out.println("Запрашивыемого контакта нет в списке");
            menu.InfoMenu();

        } catch (IOException e) {
            throw new ClientException("Ошибка при вводе" , e);
        }
    }

    public void DeleteAllContact() {

        MainMenu menu = new MainMenu();

        if (CreatingContact.getLIST().isEmpty()) {
            System.out.println("Список пуст. Удаление невозможно");
            menu.InfoMenu();
        }

        BufferedReader red34 = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Дальнейшие действия приведут к удалению всех контактов ");
        System.out.print("Если хотите удалить СПИСОК КОНТАКТОВ нажмите '1' , чтобы вернуться в ГЛАВНОЕ МЕНЮ нажмите любую клавишу: ");

        try {
            String number = red34.readLine();
            switch (number){
                case ("1"):
                    CreatingContact.getLIST().clear();
                    CreatingContact.getListGroup().clear();
                    System.out.println("СПИСОК КОНТАКТОВ успешно удален");
                    menu.InfoMenu();
                default:
                menu.InfoMenu();
            }
        } catch (IOException e) {
            throw new ClientException("Ошибка при вводе" , e);
        }
    }
}
