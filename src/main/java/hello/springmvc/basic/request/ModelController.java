package hello.springmvc.basic.request;

import hello.springmvc.basic.request.entity.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@Slf4j
public class ModelController {
    
    @GetMapping("/model-attribute-v2")
    @ResponseBody
    public String modelV2(@ModelAttribute(name = "helloData") HelloData helloData) {
        log.info("username = {}", helloData.getUsername());
        log.info("age = {}", helloData.getAge());
        return "ok";
    }
}
