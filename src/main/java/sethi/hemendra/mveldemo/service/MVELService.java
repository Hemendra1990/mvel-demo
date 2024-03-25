package sethi.hemendra.mveldemo.service;

import org.mvel2.MVEL;
import org.mvel2.ParserContext;
import org.springframework.stereotype.Service;
import sethi.hemendra.mveldemo.component.CalculationService;
import sethi.hemendra.mveldemo.mvel.context.MVELResponse;
import sethi.hemendra.mveldemo.mvel.context.MVELUtils;

import java.util.Map;

@Service
public class MVELService {

    private final ParserContext parserContext;

    public MVELService(ParserContext parserContext) {
        this.parserContext = parserContext;
    }


    public MVELResponse evaluate(Map<String, Object> request) {
        String formula = String.valueOf(request.get("formula"));
        try {
            Object eval = MVEL.compileExpression(formula, parserContext);
            Object result = MVEL.executeExpression(eval, request);
            return new MVELResponse(result, result.getClass().getSimpleName());
        } catch (Exception e) {
            e.printStackTrace();
            return new MVELResponse(e.getMessage(), "Error");
        }
    }
}
