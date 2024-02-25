package hello.springmvc.basic.request;


import com.fasterxml.jackson.databind.ObjectMapper;
import hello.springmvc.basic.request.entity.HelloData;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

@Slf4j
@Controller
public class RequestBodyStrongController {
    
    private final ObjectMapper objectMapper = new ObjectMapper();
    
    @PostMapping("request-body-string-v1")
    public void requestBodyString(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletInputStream inputStream = request.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        
    }
    @PostMapping("request-body-string-v2")
    public void requestBodyStringV2(InputStream inputStream, Writer writer) throws IOException {
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        writer.write(messageBody);
    }
    
    @PostMapping("request-body-string-v3")
    @ResponseStatus(HttpStatus.OK)
    public HttpEntity<HelloData> requestBodyStringV3(HttpEntity<String> httpEntity) throws IOException {
        
        String body = httpEntity.getBody();
        HelloData helloData = objectMapper.readValue(body, HelloData.class);
        log.info("username = {}",helloData.getUsername());
        
        return new HttpEntity<>(helloData);
    }
}
