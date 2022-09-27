import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class datePractice {

    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        List<String> dates = new ArrayList<>();

        dates.add("2022-08-23");
        dates.add("2022-09-03");
        dates.add("2022-09-15");
        dates.add("2022-09-26");
        dates.add("2022-10-08");

        LocalDate d1 = LocalDate.from(LocalDate.parse(dates.get(0), formatter));
        LocalDate d2 = LocalDate.from(LocalDate.parse(dates.get(4), formatter));

        System.out.println(d1);
        d1 = d1.plusDays(3);
        System.out.println(d1);

    }
}
