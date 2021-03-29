package phoneDirectory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


import static phoneDirectory.CreateContact2.LIST;

class EditContacts {

    MainMenu menu = new MainMenu();
    Contacts con = new Contacts();
    Serializator ser = new Serializator();
    CreateContact2 cr = new CreateContact2();

    public void EditMenu() {

        BufferedReader reader45 = new BufferedReader(new InputStreamReader(System.in));

        if (LIST.isEmpty()) {
            System.out.println("Список пуст. Редактирование невозможно");
            MainMenu menu = new MainMenu();
            menu.infoMenu();
        }

        try {
            System.out.print("Введите название контакта, которого нужно изменить: ");
            String name = reader45.readLine();
            for (Contacts con : LIST) {
                if (con.getName().equals(name) || con.getLastname().equals(name) || con.getPatronymic().equals(name)) {
                    System.out.println(con);
                    System.out.print("Чтобы изменить выбраный контакт нажмите '1' , чтобы выйти в ГЛАВНОЕ МЕНЮ нажмите любую кнопку: ");
                    String num = reader45.readLine().trim();
                    switch (num) {
                        case ("1"):
                            LIST.remove(con);
                            ser.serialization();
                            cr.check();
                            cr.AllName();
                            cr.NumberMob();
                            cr.skipNumberHome();
                            cr.Email();
                            cr.Group();
                            cr.Save();
                            menu.infoMenu();
                            break;
                        default:
                            menu.infoMenu();
                    }
                }else{
                    System.out.println("Запрашивыемого контакта нет в списке");
                    menu.infoMenu();
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка EditMenu" + e);
        }
    }

}
