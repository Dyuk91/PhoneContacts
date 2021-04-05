package phoneDirectory;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CreatingContact implements Serializable {

    private static List<Contacts> LIST = new ArrayList<>();
    private static List <String> ListGroup = new ArrayList<>();

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
            // throw new ClientException("Ошибка при вводе" , e);
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
                    String name = reader.readLine();
                    con.setGroups(name);
                    ListGroup.add(name);
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

    public static List<Contacts> getLIST() {
        return LIST;
    }

    public static void setLIST(List<Contacts> LIST) {
        CreatingContact.LIST = LIST;
    }

    public static List<String> getListGroup() {
        return ListGroup;
    }

    public static void setListGroup(List<String> listGroup) {
        ListGroup = listGroup;
    }
}