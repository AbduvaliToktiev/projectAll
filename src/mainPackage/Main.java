package mainPackage;

import family.Parents;
import sql.Connect;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Connect connect = new Connect();
        Administrators administrators = new Administrators();
        Parents parents = new Parents();
        connect.connection();
        while (true) {
            System.out.println("Выберите роль:");
            System.out.println("Родитель");
            System.out.println("Админ");
            System.out.println("Или введите {Выход} для завершения программы");
            String command = sc.nextLine();
            switch (command) {
                case "Родитель":
                    // Функционал для родителя
                    parents.parentsMenu();
                    break;
                case "Админ":
                    // Функционал для администратора
                    administrators.administratorsMenu();
                    break;
                case "Выход":
                    System.exit(0);
                    break;

                default:
                    System.out.println("-------------------------------------------------------------");
                    System.err.println("Ошибка. Введите название из меню!!!");
            }
        }
    }
}
