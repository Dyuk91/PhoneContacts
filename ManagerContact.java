package phoneDirectory;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ManagerContact implements Serializable {

    private static List<Contacts> LIST = new ArrayList<>();
    private static List <String> ListGroup = new ArrayList<>();

    public static List<Contacts> getLIST() {
        return LIST;
    }

    public static void setLIST(List<Contacts> LIST) {
        ManagerContact.LIST = LIST;
    }

    public static List<String> getListGroup() {
        return ListGroup;
    }

    public static void setListGroup(List<String> listGroup) {
        ListGroup = listGroup;
    }

    Contacts con = new Contacts();


    public void AllName() { // Вводим данные ФИО контакта

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Введите имя: ");
        String name = "пусто";
        try {
            name = reader.readLine();
        } catch (IOException e) { // ошибка ввода-вывода данных
            System.err.print("Ошибка ввода данных");
            e.printStackTrace();
            // throw new ClientExeption("Ошибка при вводе" , e);
        }

        System.out.print("Введите фамилию: ");
        String lastname = "пусто";
        try {
            lastname = reader.readLine();
        } catch (IOException e) {
            System.err.print("Ошибка ввода данных");
            e.printStackTrace();
        }

        System.out.print("Введите отчество: ");
        String patronymic = "пусто";
        try {
            patronymic = reader.readLine();
        } catch (IOException e) {
            System.err.print("Ошибка ввода данных");
            e.printStackTrace();
        }

        if (!LIST.isEmpty()) {
            for (Contacts contact : LIST) {
                if (contact.getName().equals(name) && contact.getLastname().equals(lastname) && contact.getPatronymic().equals(patronymic)) {
                    System.out.print("Контакт с таким именем уже сущетвует. Чтобы продолжить и создать дубликат нажмите 1, чтобы изменить имя контакта нажмите любую клавишу: ");
                    String a = "a";
                    try {
                        a = reader.readLine().trim();
                    } catch (IOException e) {
                        System.out.print("Ошибка данных");
                    }
                    switch (a) {
                        case "1":
                            break;
                        default:
                            System.out.println("Измените имя конакта");
                            AllName();
                    }
                }

            }
        }
        con.setName(name);
        con.setLastname(lastname);
        con.setPatronymic(patronymic);
    }


    public void NumberMob() { //Вводим мобильный номер

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long number = 00;

        try {
            System.out.print("Введите номер мобильного телефона, начиная с '8': ");
            number = Long.parseLong(reader.readLine().trim());

            if (String.valueOf(number).startsWith("89") && String.valueOf(number).length() == 11) {

            } else {
                System.out.println("Неккоректный ввод. Повторите попытку");
                NumberMob();
            }
        } catch (NumberFormatException e) {
            System.out.println("Введите номер цифрами");
            NumberMob();
        }catch (IOException e) {
            System.err.print("Ошибка ввода данных");
            e.printStackTrace();
        }

        for (Contacts contact : LIST) {
            if (contact.getNumberMob() == number || contact.getNumberHome() == number) {
                System.out.println("Контакт с таким номером уже сущетвует. Измените номер");
                System.out.println(contact);
                NumberMob();
                break;
            }
        }
        con.setNumberMob(number);
    }

    public void SkipNumberHome() { // Пропускаем домашний номер, если нужно

        System.out.print("Нажмите ' 1 ' чтобы ввести домашний, нажмите любую кнопку если домашний номер не нужен контакту: ");
        try {
            BufferedReader reader34 = new BufferedReader(new InputStreamReader(System.in));
            int nextNumber = Integer.parseInt(reader34.readLine());
            switch (nextNumber) {
                case (1):
                    NumberHome();
                    break;
                default:
                    Age();
                    break;
            }
        } catch (NumberFormatException e) {
            Age();
        } catch (IOException e) {
            System.err.print("Ошибка ввода данных");
            e.printStackTrace();
        }
    }

    public void NumberHome() {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.print("Введите номер домашнего телефона, начиная с '8': ");
            long numberHome = Long.parseLong(reader.readLine().trim());

            if (String.valueOf(numberHome).startsWith("8") && String.valueOf(numberHome).length() < 15 && String.valueOf(numberHome).length() > 6) {
                for (Contacts contact : LIST) {
                    if (contact.getNumberHome() == numberHome || contact.getNumberMob() == numberHome) {
                        System.out.println("Контакт с таким номером уже сущетвует. Измените номер");
                        System.out.println(contact);
                        NumberHome();
                        break;
                    }
            }
            }else {
                System.out.println("Неккоректный ввод. Повторите попытку");
                NumberHome();
            }
            con.setNumberHome(numberHome);

        } catch (NumberFormatException e) {
            System.out.println("Ошибка ввода. Введидите номер числами");
            NumberHome();
        } catch (IOException e) {
            System.err.print("Ошибка ввода данных");
            e.printStackTrace();
        }
    }

    public void Age() {

        BufferedReader reader555 = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.print("Введите возраст контакта: ");
            double age = Double.parseDouble(reader555.readLine());
            if (age >= 0 && age < 130) {
                con.setAge(age);
            } else {
                System.out.println("Неверное значение. Повторите ввод");
                Age();
            }
        } catch (NumberFormatException e) {
            System.out.println("Ошибка ввода. Введидите номер числами");
            Age();
        }catch (IOException e) {
            System.err.print("Ошибка ввода данных");
            e.printStackTrace();
        }
    }

    public void Email() {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.print("Введите электронный адрес контакта: ");
            String email = reader.readLine();
            if (email.length() > 20) {
                System.out.println("Некорректный ввод. Электронный адрес не может превышать 20 символов");
                Email();
            }
            con.setEmail(email);
        } catch (IOException e) {
            System.err.print("Ошибка ввода данных");
            e.printStackTrace();
        }
    }

    public void Group() {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Выберите группу из имеющихся или создайте свою");
            System.out.print("Нажмите клавиши, соответствующие разделу группы: 1. Семья, 2. Друзья, 3. Работа, 4.Услуги, 5.Увлечения, 6. Другое : ");
            String groups = reader.readLine();
            switch (groups) {
                case ("1"):
                    con.setGroups("Семья");
                    ListGroup.add("Семья");
                    break;
                case ("2"):
                    con.setGroups("Друзья");
                    ListGroup.add("Друзья");
                    break;
                case ("3"):
                    con.setGroups("Работа");
                    ListGroup.add("Работа");
                    break;
                case ("4"):
                    con.setGroups("Услуги");
                    ListGroup.add("Услуги");
                    break;
                case ("5"):
                    con.setGroups("Увлечения");
                    ListGroup.add("Увлечения");
                    break;
                case ("6"):
                    System.out.print("Введите свое имя группы: ");
                    con.setGroups(reader.readLine());
                    ListGroup.add(reader.readLine());
                    break;
                default:
                    con.setGroups("Без группы");
                    ListGroup.add("Без группы");
                    break;
            }
        } catch (IOException e) {
            System.err.print("Ошибка ввода данных");
            e.printStackTrace();
        }
    }

    public void SaveContact() {

        System.out.println(con);
        System.out.println("Контакт успешно сохранен");

        boolean add = LIST.add(con);

        con = new Contacts();
    }

//    public void Serialization() {
//
//        try (ObjectOutputStream oos1 = new ObjectOutputStream(new FileOutputStream("Contacts")); ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream("Group"))) { // Метод try-with-resources. Метод close() работает по умолчанию.
//
//            oos1.writeObject(LIST);
//
//            oos2.writeObject(ListGroup);
//
//        } catch (FileNotFoundException e) {
//            System.err.println("Файл не найден");
//            e.printStackTrace();
//        } catch (IOException e) {
//            System.err.println("Ошибка");
//            e.printStackTrace();
//        }
//    }
//
//    public void Deserialization() {
//
//        try (ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream("Contacts")); ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream("Group"))) {
//
//            LIST = (List) ois1.readObject();
//
//            ListGroup = (List) ois2.readObject();
//
//        } catch (ClassNotFoundException e) {
//            System.err.println("Ошибка");
//            e.printStackTrace();
//        } catch (FileNotFoundException e) {
////            System.err.println("Ошибка");
////            e.printStackTrace();
//        } catch (IOException e) {
//            System.err.println("Ошибка");
//            e.printStackTrace();
//        }
//    }

    public void PrintAllContacts() {

        MainMenu menu = new MainMenu();

        System.out.println("///////////////   СПИСОК КОНТАКТОВ   ///////////////");

        if (LIST.isEmpty()) {
            System.out.println("Список пуст");
            menu.InfoMenu();
        }

        for (Contacts con : LIST) {
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

                    for (Contacts con : LIST) {
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
            System.err.println("Ошибка ввода");
            e.printStackTrace();
        }
    }

    public void EditContact() {

        BufferedReader reader45 = new BufferedReader(new InputStreamReader(System.in));

        if (LIST.isEmpty()) {
            System.out.println("Список пуст. Редактирование невозможно");
            MainMenu menu = new MainMenu();
            menu.InfoMenu();
        }

        try {

            MainMenu menu = new MainMenu();

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
                            con = new Contacts();
                            AllName();
                            NumberMob();
                            SkipNumberHome();
                            Email();
                            Group();
                            LIST.add(con);
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
            System.err.println("Ошибка ввода");
            e.printStackTrace();
        }
    }

    public void DeleteContact() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        MainMenu menu = new MainMenu();

        if (LIST.isEmpty()) {
            System.out.println("Список пуст. Удаление невозможно");
            menu.InfoMenu();
        }

        try {
            System.out.print("Введите название контакта, которого нужно удалить: ");
            String name = reader.readLine().trim();
            for (Contacts con : LIST) {
                if (con.getName().equals(name) || con.getLastname().equals(name) || con.getPatronymic().equals(name)) {
                    System.out.println(con);
                    System.out.print("Чтобы удалить выбраный контакт нажмите '1' , чтобы выйти в ГЛАВНОЕ МЕНЮ нажмите любую кнопку: ");
                    String num = reader.readLine().trim();
                    switch (num) {
                        case ("1"):
                            System.out.println("Контакт удален --> " + con);
                            LIST.remove(con);
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
            System.err.println("Ошибка ввода");
            e.printStackTrace();
        }
    }

    public void DeleteAllContact() {

        MainMenu menu = new MainMenu();

        if (LIST.isEmpty()) {
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
                    LIST.clear();
                    System.out.println("СПИСОК КОНТАКТОВ успешно удален");
                    menu.InfoMenu();
                default:
                menu.InfoMenu();
            }
        } catch (IOException e) {
            System.err.println("Ошибка ввода");
            e.printStackTrace();
        }
    }

    public void PrintAllGroup() {

        if (ListGroup.isEmpty()) {
            System.out.println("Список пуст");
            MainMenu menu = new MainMenu();
            menu.InfoMenu();
        }

        System.out.println("Список групп");
            for (String group : ListGroup) {
                System.out.println(group);
        }
            SearchGroup();
    }

    public void SearchGroup() {

        BufferedReader SG = new BufferedReader(new InputStreamReader(System.in));

        MainMenu menu = new MainMenu();

//        List<Contacts> searchContact = new ArrayList<>();

        try {
            System.out.print("Просмотреть контакты группы нажмите 1. Выйти в ГЛАВНОЕ МЕНЮ нажмите любую кнопку: ");

            String click = SG.readLine();

            switch (click){
                case ("1"):
                    for (String str : ListGroup) {
                        System.out.println(str);
                    }
                    System.out.print("Чтобы просмореть данные группы введите ее название: ");
                    String searchGr = SG.readLine();

                    for (Contacts con : LIST) {
                        if (searchGr.equals(con.getGroups())) {
                            System.out.println(con);
                        }
                        SearchGroup();
                        break;
                    }
//                    for (Contacts con2 : searchContact) {
//                        System.out.println(con2);
//                        SearchGroup();
//                        break;
//                    }
                    System.out.println("Группа не найдена");
                    SearchGroup();
                    menu.InfoMenu();
                    break;

                default:
                     menu.InfoMenu();
                     break;
            }
        } catch (IOException e) {
            System.err.println("Ошибка ввода");
            e.printStackTrace();
        }
    }

    public void CreateGroup() {

        if (ListGroup.isEmpty()) {
            System.out.println("Список пуст");
            MainMenu menu = new MainMenu();
            menu.InfoMenu();
        }

            System.out.println("Список групп");
            for (String str : ListGroup) {
                System.out.println(str);
            }


            System.out.print("Редактировать группу нажмите 1. Выйти в ГЛАВНОЕ МЕНЮ нажмите любую кнопку: ");

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            MainMenu mainMenu = new MainMenu();

            try {
                String num = reader.readLine();
                switch (num) {
                    case ("1"):
                        System.out.println("Введите имя создаваемой группы: ");
                        String nameGroup = reader.readLine();
                        ListGroup.add(nameGroup);
                        System.out.println("Группа " + nameGroup + " создана");
                        mainMenu.InfoMenu();
                        break;
                    default:
                        mainMenu.InfoMenu();
                        break;
                }

        } catch(IOException e){
            System.err.println("Ошибка ввода");
            e.printStackTrace();
        }
    }

    public void EditGroup() {

        if (ListGroup.isEmpty()) {
            System.out.println("Список пуст");
            MainMenu menu = new MainMenu();
            menu.InfoMenu();
        }

        System.out.println("Список групп");
        for (String str : ListGroup){
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
                    for (String str: ListGroup){
                        if (!exportGroup.equals(str)){
                            System.out.println("Группа с таким именем не найдена");
                            EditGroup();
                        }
                    }
                    String importGroup = reader.readLine();
                    for (String str2: ListGroup) {
                        if (!importGroup.equals(str2)) {
                            System.out.println("Группа с таким именем не найдена");
                            EditGroup();
                        }
                    }

                    for (Contacts cont : LIST){
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
            System.err.println("Ошибка ввода");
            e.printStackTrace();
        }

    }

    public void DeleteGroup() {

        if (ListGroup.isEmpty()) {
            System.out.println("Список пуст");
            MainMenu menu = new MainMenu();
            menu.InfoMenu();
        }

        System.out.println("Список групп");
        for (String str : ListGroup){
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
                    ListGroup.remove(nameGroup);
                    System.out.println("Группа " + nameGroup + " удалена");

                    for (Contacts cont : LIST){
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
            System.err.println("Ошибка ввода");
            e.printStackTrace();
        }
    }

    public void DeleteAllGroup() {

        if (ListGroup.isEmpty()) {
            System.out.println("Список пуст");
            MainMenu menu = new MainMenu();
            menu.InfoMenu();
        }

        System.out.println("Список групп");
        for (String str : ListGroup){
            System.out.println(str);
        }

        System.out.print("УДАЛИТЬ ВСЕ ГРУППЫ нажмите 1. Выйти в ГЛАВНОЕ МЕНЮ нажмите любую кнопку: ");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        MainMenu mainMenu = new MainMenu();

        try {
            String num = reader.readLine();
            switch (num){
                case ("1"):

                    for (String str2 : ListGroup){
                        ListGroup.remove(str2);
                    }

                    for (Contacts cont : LIST){
                        cont.setGroups("Без группы");
                    }
                    mainMenu.InfoMenu();
                    break;
                default:
                    mainMenu.InfoMenu();
                    break;
            }
        } catch (IOException e) {
            System.err.println("Ошибка ввода");
            e.printStackTrace();
        }

    }

}

