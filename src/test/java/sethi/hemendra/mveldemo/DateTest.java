package sethi.hemendra.mveldemo;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.Date;

public class DateTest {
    @Test
    void test() {
        Date date = DateUtils.addDays(new Date(), 1);
        String format = DateFormatUtils.format(date, "hh");
        System.out.println(format);

        try {
            Date date1 = DateUtils.parseDate("2021-01-01", "yyyy-MM-dd");
            System.out.println(date1);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
