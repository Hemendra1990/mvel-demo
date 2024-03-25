package sethi.hemendra.mveldemo.component;

import org.apache.commons.lang3.time.DateUtils;
import org.mvel2.MVEL;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;


@Component
public class CalculationService {
    public static Integer hemu(Integer a, Integer b) {
        String name = "Hemendra";
        return a + b;
    }

    /*IF(logical_test, value_if_true, value_if_false)*/
    public static Object IF(String condition, Object trueValue, Object falseValue) {
        Serializable serializable = MVEL.compileExpression(condition);
        Boolean result  = (Boolean) MVEL.executeExpression(serializable);
        if(StringUtils.isEmpty(trueValue) || StringUtils.isEmpty(falseValue)) {
            throw new IllegalArgumentException("Value cannot be null or empty");
        }
        if (org.apache.commons.lang3.StringUtils.equalsIgnoreCase("true", String.valueOf(trueValue))
                || org.apache.commons.lang3.StringUtils.equalsIgnoreCase("false", String.valueOf(trueValue))) {
            return result ? Boolean.valueOf(String.valueOf(trueValue)) : Boolean.valueOf(String.valueOf(falseValue));
        }
        return result ? trueValue : falseValue;
    }

    public static Boolean AND(Boolean... values) {
        for (Boolean value : values) {
            if (!value) {
                return false;
            }
        }
        return true;
    }

    public static Boolean OR(Boolean... values) {
        for (Boolean value : values) {
            if (value) {
                return true;
            }
        }
        return false;
    }

    public static Date DATE(int year, int month, int day) throws ParseException {
        Calendar instance = Calendar.getInstance();
        instance.set(year, month, day);
        Date time = instance.getTime();
        String format = new SimpleDateFormat("yyyy-MM-dd").format(time);
        return DateUtils.parseDate(format, "yyyy-MM-dd");
    }

    public static Date DATEVALUE(String date) throws ParseException {
        Date parseDate = DateUtils.parseDate(date, "yyyy-MM-dd");
        return parseDate;
    }

    public static LocalDate TODAY() {
        return LocalDateTime.now().toLocalDate();
    }

    public static LocalDateTime NOW() {
        return LocalDateTime.now();
    }

    public static String TEXT(Object text) {
        return String.valueOf(text);
    }


}
