package utility;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ReportUtils {
    public static String generateTimestamp() {
        return new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    }
}