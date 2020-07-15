package domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test {
    public static void main(String[] args) throws ParseException {
        String data = "2019.11.11";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        Date date = sdf.parse(data);
        System.out.println(date);
    }
}
