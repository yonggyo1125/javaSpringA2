package exam01;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ex02 {
    public static void main(String[] args) {
        String dateStr = "04/24/2022 23:30:30";
        String pattern = "MM/dd/yyyy HH:mm:ss";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);

        LocalDateTime date = LocalDateTime.parse(dateStr, formatter);
        System.out.println(date);
    }
}
