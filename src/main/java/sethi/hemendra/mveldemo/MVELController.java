package sethi.hemendra.mveldemo;

import org.springframework.web.bind.annotation.*;
import sethi.hemendra.mveldemo.mvel.context.MVELResponse;
import sethi.hemendra.mveldemo.service.MVELService;

import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/mvel")
public class MVELController {

    private final MVELService mvelService;

    public MVELController(MVELService mvelService) {
        this.mvelService = mvelService;
    }

    @GetMapping
    public String get() {
        return "Hello MVEL!";
    }

    @PostMapping
    public MVELResponse post(@RequestBody Map<String, Object> request) {
        Objects.requireNonNull(request.get("formula"), "Formula field is required");
        return this.mvelService.evaluate(request);
    }
}
