package gr.efthymiou.petros.backbaseassignment.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtils {

    public static String formatDate(Long timestamp, String pattern) {
        try {
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            sdf.setTimeZone(cal.getTimeZone());
            return sdf.format(timestamp * 1000);
        } catch (Exception e) {
            return "";
        }
    }
}
