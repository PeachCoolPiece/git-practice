package hello.springmvc.basic.request;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {
    
    @GetMapping("request-param-v1")
    public void requestParamV1(@RequestParam Map<String, String> param) {
        String username = param.get("username");
        String age = param.get("age");
        
        
        param.entrySet()
                .stream()
                .map(item -> {
                    Map<String, String> map = new HashMap<>();
                    map.put(item.getKey(), item.getValue());
                    return map;
                });
        
    }
    
    @GetMapping("request-param-v2")
    @ResponseBody
    public String requestParamV2(@RequestParam MultiValueMap<String, String> param) {
        
        if (param.isEmpty()) {
            log.info("비었음");
            return "dd";
        }
        
        
        return "ok";
        
    }
}
