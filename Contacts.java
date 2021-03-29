package phoneDirectory;

import java.io.Serializable;

public class Contacts implements Serializable {


    private String name; // имя контакта
    private String lastname; // фамилия конатакта
    private String patronymic; // отчество контакта
    private long numberMob; // номер мобильного
    private long numberHome; // номер домашнего
    private double age; // возраст не больше 150, синхронизировать с дата рождения
    private String email; // электоронный адрес
    private String groups; // группа контактов


    public void setName(String name) {
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public long getNumberMob() {
        return numberMob;
    }

    public void setNumberMob(long numberMob) {
        this.numberMob = numberMob;
    }

    public long getNumberHome() {
        return numberHome;
    }

    public void setNumberHome(long numberHome) {
        this.numberHome = numberHome;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGroups() {
        return groups;
    }

    public void setGroups(String groups) {
        this.groups = groups;
    }


    @Override
    public String toString() {
        return  "имя: " + name + " | " +
                "фамилия: " + lastname + " | " +
                "отчество: " + patronymic + " | " +
                "мобильный номер: " + String.valueOf(numberMob).replaceFirst("(\\d{1})(\\d{3})(\\d{3})(\\d{2})(\\d+)", "$1($2)-$3-$4-$5") + " | " +
                "домашний номер: " + String.valueOf(numberHome).replaceFirst("(\\d{1})(\\d{3})(\\d{3})(\\d{2})(\\d+)", "$1($2)-$3-$4-$5") + " | " +
                "возраст: " + age + " | " +
                "электроный адрес: " + email + " | " +
                "группа контактов: " + groups;
    }

}
