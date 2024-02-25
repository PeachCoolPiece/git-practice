package hello.springmvc.basic.request.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HelloData {
    
    private String username;
    private Integer age;
    
}
