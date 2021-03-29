package phoneDirectory;


public class Test {


    public static void main(String[] args) {

        CreateContact2 cr = new CreateContact2();
        Serializator ser = new Serializator();
        MainMenu menu = new MainMenu();

        //while (true) {
//            menu.infoMenu();
            cr.check();
//            cr.AllName();
            cr.NumberMob();
//            cr.Age();
//            cr.Email();
//            cr.Group();
            cr.Save();
//            ser.serialization();
//            ser.printAllContacts();

            System.exit(0);
        //}

        }
    }

/*
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
            } else {
                con.setNumberMob(number);
            }
        }
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
                con.setNumberHome(numberHome);
            } else {
                System.out.println("Неккоректный ввод. Повторите попытку");
                NumberHome();
            }
        } catch (IOException a) {
            System.out.print("Ошибка данных");
            NumberHome();
        } catch (NumberFormatException a) {
            System.out.println("Ошибка ввода. Введидите номер числами");
            NumberHome();
        }
        Age();

 */