package sethi.hemendra.mveldemo.mvel.context;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.mvel2.MVEL;
import org.mvel2.ParserContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sethi.hemendra.mveldemo.component.CalculationService;

import java.time.LocalDateTime;
import java.util.Date;

@Configuration
public class MVELUtils {

    LocalDateTime now = LocalDateTime.now();

    @Bean
    public ParserContext parserContext() {
        ParserContext parserContext = new ParserContext();
        parserContext.addImport("time", MVEL.getStaticMethod(System.class, "currentTimeMillis", new Class[0]));
        parserContext.addImport("hemu", MVEL.getStaticMethod(CalculationService.class, "hemu", new Class[]{Integer.class, Integer.class}));
        parserContext.addImport("TIMENOW", MVEL.getStaticMethod(LocalDateTime.class, "now", new Class[0]));
        parserContext.addImport("StringUtils", StringUtils.class);
        parserContext.addImport("DateUtils", DateUtils.class);
        parserContext.addImport("DATE", Date.class);
        parserContext.addImport("IF", MVEL.getStaticMethod(CalculationService.class, "IF", new Class[]{String.class, Object.class, Object.class}));
        parserContext.addImport("AND", MVEL.getStaticMethod(CalculationService.class, "AND", new Class[]{Boolean[].class}));
        parserContext.addImport("OR", MVEL.getStaticMethod(CalculationService.class, "OR", new Class[]{Boolean[].class}));
        parserContext.addImport("DATE", MVEL.getStaticMethod(CalculationService.class, "DATE", new Class[]{int.class, int.class, int.class}));
        parserContext.addImport("DATEVALUE", MVEL.getStaticMethod(CalculationService.class, "DATEVALUE", new Class[]{String.class}));
        parserContext.addImport("TODAY", MVEL.getStaticMethod(CalculationService.class, "TODAY", new Class[0]));
        parserContext.addImport("NOW", MVEL.getStaticMethod(CalculationService.class, "NOW", new Class[0]));
        parserContext.addImport("TEXT", MVEL.getStaticMethod(CalculationService.class, "TEXT", new Class[]{Object.class}));
        return parserContext;
    }
}
