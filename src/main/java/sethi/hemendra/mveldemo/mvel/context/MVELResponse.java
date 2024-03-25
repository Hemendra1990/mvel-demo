package sethi.hemendra.mveldemo.mvel.context;

public record MVELResponse(Object result, String returnType) {
    public MVELResponse {
        if (result == null) {
            throw new IllegalArgumentException("Result cannot be null");
        }
        if (returnType == null) {
            throw new IllegalArgumentException("Return type cannot be null");
        }
    }
}
