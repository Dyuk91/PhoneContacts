package phoneDirectory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ManagerMenuGroup {

    public void PrintAllGroup() {

        if (CreatingContact.getListGroup().isEmpty()) {
            System.out.println("Список пуст");
            MainMenu menu = new MainMenu();
            menu.InfoMenu();
        }

        System.out.println("//////   Список групп   //////");
        for (String group : CreatingContact.getListGroup()) {
            System.out.println(group);
        }
        SearchGroup();
    }

    public void SearchGroup() {

        BufferedReader SG = new BufferedReader(new InputStreamReader(System.in));

        MainMenu menu = new MainMenu();

        try {
            System.out.print("Просмотреть контакты группы нажмите 1. Выйти в ГЛАВНОЕ МЕНЮ нажмите любую кнопку: ");

            String click = SG.readLine();

            switch (click) {
                case ("1"):
                    System.out.print("Чтобы просмореть данные группы введите ее название: ");
                    String searchGr = SG.readLine();

                    for (String str : CreatingContact.getListGroup()) {
                        if (str.equals(searchGr)) {
                            for (Contacts con : CreatingContact.getLIST()) {
                                if (searchGr.equals(con.getGroups())) {
                                    System.out.println(con);
                                    menu.InfoMenu();
                                }
                            }
                        }
                    }
                    break;
                default:
                    menu.InfoMenu();
                    break;
            }
            System.out.println("Группы с таким именем нет. Повторите ввод");
            SearchGroup();

        } catch (IOException e) {
            throw new ClientException("Ошибка при вводе" , e);
        }
    }

    public void CreateGroup() {

        if (CreatingContact.getListGroup().isEmpty()) {
            System.out.println("Список пуст");
            MainMenu menu = new MainMenu();
            menu.InfoMenu();
        }

        System.out.println("//////   Список групп   //////");
        for (String str : CreatingContact.getListGroup()) {
            System.out.println(str);
        }


        System.out.print("Создать группу нажмите 1. Выйти в ГЛАВНОЕ МЕНЮ нажмите любую кнопку: ");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        MainMenu mainMenu = new MainMenu();

        try {
            String num = reader.readLine();
            switch (num) {
                case ("1"):
                    System.out.print("Введите имя создаваемой группы: ");
                    String nameGroup = reader.readLine();
                    for (String string : CreatingContact.getListGroup()){
                        if (nameGroup.equals(string)){
                            System.out.println("Группа с таким именем существует. Введите другое имя");
                            CreateGroup();
                        }
                    }

                    for (String string : CreatingContact.getListGroup()){
                            CreatingContact.getListGroup().add(nameGroup);
                            System.out.println("Группа " + nameGroup + " создана");
                            mainMenu.InfoMenu();
                        }
                    break;
                default:
                    mainMenu.InfoMenu();
                    break;
            }

        } catch(IOException e){
            throw new ClientException("Ошибка при вводе" , e);
        }
    }

    public void EditGroup() {

        if (CreatingContact.getListGroup().isEmpty()) {
            System.out.println("Список пуст");
            MainMenu menu = new MainMenu();
            menu.InfoMenu();
        }

        System.out.println("//////   Список групп   //////");
        for (String str : CreatingContact.getListGroup()){
            System.out.println(str);
        }

        System.out.print("Перенести конакты из одной группы в другую нажмите 1. Выйти в ГЛАВНОЕ МЕНЮ нажмите любую кнопку: ");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        MainMenu mainMenu = new MainMenu();

        try {
            String num = reader.readLine();
            switch (num){
                case ("1"):
                    System.out.println("Введите имя группы, ИЗ которой нужно убрать контакты: ");
                    String exportGroup = reader.readLine();
                    for (String str: CreatingContact.getListGroup()){
                        if (!exportGroup.equals(str)){
                            System.out.println("Группа с таким именем не найдена");
                            EditGroup();
                        }
                    }
                    String importGroup = reader.readLine();
                    for (String str2: CreatingContact.getListGroup()) {
                        if (!importGroup.equals(str2)) {
                            System.out.println("Группа с таким именем не найдена");
                            EditGroup();
                        }
                    }

                    for (Contacts cont : CreatingContact.getLIST()){
                        if (exportGroup.equals(cont.getGroups())){
                            cont.setGroups(importGroup);
                        }
                    }
                    mainMenu.InfoMenu();
                    break;
                default:
                    mainMenu.InfoMenu();
                    break;
            }
        } catch (IOException e) {
            throw new ClientException("Ошибка при вводе" , e);
        }

    }

    public void DeleteGroup() {

        if (CreatingContact.getListGroup().isEmpty()) {
            System.out.println("Список пуст");
            MainMenu menu = new MainMenu();
            menu.InfoMenu();
        }

        System.out.println("//////   Список групп   //////");
        for (String str : CreatingContact.getListGroup()){
            System.out.println(str);
        }

        System.out.print("Удалить группу нажмите 1. Выйти в ГЛАВНОЕ МЕНЮ нажмите любую кнопку: ");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        MainMenu mainMenu = new MainMenu();

        try {
            String num = reader.readLine();
            switch (num){
                case ("1"):
                    System.out.print("Введите имя удаляемой группы: ");
                    String nameGroup = reader.readLine();
                    CreatingContact.getListGroup().remove(nameGroup);
                    System.out.println("Группа " + nameGroup + " удалена");

                    for (Contacts cont : CreatingContact.getLIST()){
                        if (nameGroup.equals(cont.getGroups())){
                            cont.setGroups("Без группы");
                        }
                    }
                    mainMenu.InfoMenu();
                    break;
                default:
                    mainMenu.InfoMenu();
                    break;
            }
        } catch (IOException e) {
            throw new ClientException("Ошибка при вводе" , e);
        }
    }

    public void DeleteAllGroup() {

        if (CreatingContact.getListGroup().isEmpty()) {
            System.out.println("Список пуст");
            MainMenu menu = new MainMenu();
            menu.InfoMenu();
        }

        System.out.println("//////   Список групп   //////");
        for (String str : CreatingContact.getListGroup()){
            System.out.println(str);
        }

        System.out.print("УДАЛИТЬ ВСЕ ГРУППЫ нажмите 1. Выйти в ГЛАВНОЕ МЕНЮ нажмите любую кнопку: ");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        MainMenu mainMenu = new MainMenu();

        try {
            String num = reader.readLine();
            switch (num){
                case ("1"):

                    for (String str2 : CreatingContact.getListGroup()){
                        CreatingContact.getListGroup().remove(str2);
                    }

                    for (Contacts cont : CreatingContact.getLIST()){
                        cont.setGroups("Без группы");
                    }
                    mainMenu.InfoMenu();
                    break;
                default:
                    mainMenu.InfoMenu();
                    break;
            }
        } catch (IOException e) {
            throw new ClientException("Ошибка при вводе" , e);
        }
    }
}
