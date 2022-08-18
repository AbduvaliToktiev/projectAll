package sql;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public interface Datable {
    String DATE_FORMAT = "dd/MM/yyyy";

    default java.sql.Date readDate() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите дату рождения человека (Пример для даты{dd/MM/yyyy})");
        Date date = new SimpleDateFormat(DATE_FORMAT).parse(scanner.nextLine());
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        setDate(date);
        return sqlDate;
    }

    default void setDate(Date date) {
        System.out.println(date);
    }
}
