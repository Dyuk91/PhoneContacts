package phoneDirectory;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CreateContact2 implements Serializable {

    public static List<Contacts> LIST = new ArrayList<>();
    private List<Group> group;

    Contacts con = new Contacts();

    public void check() {

        try {

            FileInputStream fis = new FileInputStream("cont1");

            ObjectInputStream ois = new ObjectInputStream(fis);

            LIST = (List<Contacts>) ois.readObject();

            ois.close();

        } catch (FileNotFoundException e) {
            System.out.println("Ошибка1" + e);
        } catch (IOException e) {
            System.out.println("Ошибка2" + e);
        } catch (ClassNotFoundException e) {
            System.out.println("Ошибка3" + e);
        }
    }

    public void AllName() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Введите имя: ");
        String name = "пусто";
        try {
            name = reader.readLine();
        } catch (IOException e) { // ошибка ввода-вывода данных
            System.out.print("Ошибка данных");
            return;
        }

        System.out.print("Введите фамилию: ");
        String lastname = "пусто";
        try {
            lastname = reader.readLine();
        } catch (IOException e) {
            System.out.println("Ошибка данных");
            return;
        }

        System.out.print("Введите отчество: ");
        String patronymic = "пусто";
        try {
            patronymic = reader.readLine();
        } catch (IOException e) {
            System.out.print("Ошибка данных");
            return;
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


    public void NumberMob() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long number = 00;

        try {
            System.out.print("Введите номер мобильного телефона, начиная с '8': ");
            number = Long.parseLong(reader.readLine().trim());

            if (String.valueOf(number).startsWith("89") && String.valueOf(number) != null && String.valueOf(number).length() == 11) {

            } else {
                System.out.println("Неккоректный ввод. Повторите попытку");
                NumberMob();
            }
        } catch (IOException e) {
            System.out.print("Ошибка данных");
            NumberMob();
        }
        for (Contacts contact : LIST) {
            if (contact.getNumberMob() == number) {
                System.out.println("Контакт с таким номером уже сущетвует. Измените номер");
                System.out.println(contact);
                NumberMob();
                break;
            }
            }
        con.setNumberMob(number);
        }

    public void skipNumberHome() {

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
        } catch (IOException e) {
            System.out.println("Ошибка" + e);
        } catch (NumberFormatException e) {
            Age();
        }
    }

    public void NumberHome() {


        BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));

        long numberHome = 0;

        try {
            System.out.print("Введите номер домашнего телефона, начиная с '8': ");
            numberHome = Long.parseLong(reader2.readLine().trim());
            if (String.valueOf(numberHome).startsWith("8") && String.valueOf(numberHome) != null && String.valueOf(numberHome).length() < 15 && String.valueOf(numberHome).length() > 6) {
            } else {
                System.out.println("Неккоректный ввод. Повторите попытку");
                NumberHome();
            }
            con.setNumberHome(numberHome);
        } catch (IOException a) {
            System.out.print("Ошибка данных");
            NumberHome();
        } catch (NumberFormatException a) {
            System.out.println("Ошибка ввода. Введидите номер числами");
            NumberHome();
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
        } catch (IOException e) {
            System.out.println("Ошибка данных");
            Age();
        } catch (NumberFormatException e) {
            System.out.println("Ошибка ввода. Введидите номер числами");
            Age();
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
            System.out.println("Ошибка данных");
            Email();
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
                    break;
                case ("2"):
                    con.setGroups("Друзья");
                    break;
                case ("3"):
                    con.setGroups("Работа");
                    break;
                case ("4"):
                    con.setGroups("Услуги");
                    break;
                case ("5"):
                    con.setGroups("Увлечения");
                    break;
                case ("6"):
                    System.out.print("Введите свое имя группы: ");
                    con.setGroups(reader.readLine());
                    break;
                default:
                    con.setGroups("Без группы");
                    break;
            }
        } catch (IOException e) {
            System.out.println("Ошибка" + e);
        }
    }

    public void Save() {

        Serializator ser33 = new Serializator();

        System.out.println(con);
        System.out.println("Контакт успешно сохранен");

        LIST.add(con);

        ser33.serialization();

        con = new Contacts();
    }

    public void DeleteAll() {
        MainMenu menu = new MainMenu();
        Serializator ser34 = new Serializator();
        BufferedReader red34 = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Дальнейшие действия приведут к удалению всех контактов ");
        System.out.print("Если хотите удалить СПИСОК КОНТАКТОВ нажмите '1' , чтобы вернуться в ГЛАВНОЕ МЕНЮ нажмите любую клавишу: ");

        try {
            String number34 = red34.readLine();
            if (number34.equals("1")) {
                LIST.clear();
                LIST = new ArrayList<>();
                ser34.serialization();
                System.out.println("СПИСОК КОНТАКТОВ успешно удален");
                menu.infoMenu();
            } else {
                menu.infoMenu();
            }
        } catch (IOException e) {
            System.out.println("Ошибка" + e);
        }
    }

    public void RemoveContact() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        MainMenu menu = new MainMenu();
        Serializator ser = new Serializator();

        if (LIST.isEmpty()) {
            System.out.println("Список пуст. Удаление невозможно");
            menu.infoMenu();
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
                            ser.serialization();
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
            System.out.println("Ошибка RemoveContact" + e);
        }
    }
}
