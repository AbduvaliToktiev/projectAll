package mainPackage;

import family.Children;
import family.Parents;
import kindergarten.Kindergarten;
import school.School;

import java.util.List;
import java.util.Scanner;

public class Administrators extends Rayons{
    private Integer id;
    private String fio;
    private String email;
    private String login;
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void administratorsMenu() {
        Scanner sc = new Scanner(System.in);
        Rayons rayons = new Rayons();
        School school = new School();
        Kindergarten kindergarten = new Kindergarten();
        boolean exitMenu = true;
        while (exitMenu) {
            System.out.println("Выберите действие:");
            System.out.println("Информация о районах");
            System.out.println("Информация о школах");
            System.out.println("Информация о детских садах");
            System.out.println("Информация о семьях");
            System.out.println("Выход в главное меню");
            String choice = sc.nextLine();
            switch (choice) {
                case "Информация о районах":
                    // Метод для показания информации о районе
                    List<Rayons> rayonsList = rayons.getRayonsFromDataBase();
                    if (rayonsList.isEmpty()) {
                        System.out.println("EMPTY RAYONS");
                    } else {
                        for (Rayons r : rayonsList) {
                            System.out.println(r);
                            System.out.println("----------");
                        }
                    }
                    break;

                case "Информация о школах":
                    // Метод для показания информации о школе
                    List<School> schoolList = school.getSchoolsFromDataBase();
                    if (schoolList.isEmpty()) {
                        System.out.println("EMPTY SCHOOLS");
                    } else {
                        for (School s : schoolList) {
                            System.out.println(s);
                            System.out.println("----------");
                        }
                    }
                    break;

                case "Информация о детских садах":
                    // Метод для показания информации о детских садах
                    List<Kindergarten> kindergartenList = kindergarten.getKindergartenFromDataBase();
                    if (kindergartenList.isEmpty()) {
                        System.out.println("EMPTY KINDERGARTEN");
                    } else {
                        for (Kindergarten k : kindergartenList) {
                            System.out.println(k);
                            System.out.println("----------");
                        }
                    }
                    break;

                case "Информация о семьях":
                    // Метод для показания информации о семьях

                    break;

                case "Выход в главное меню":
                    exitMenu = false;
                    break;

                default:
                    System.out.println("-------------------------------------------------------------");
                    System.err.println("Ошибка. Введите название из меню!!!");

            }
        }
    }
}
