package cc.mrbird.controller;

import cc.mrbird.exception.UserNotExistException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {
     // http://localhost:8080/user/10
    @GetMapping("/{id:\\d+}")
    public void get(@PathVariable String id) {
        throw new UserNotExistException(id);
    }
    @GetMapping("user/{id:\\d+}")
    public void  get100(@PathVariable String id) {
//        throw new UserNotExistException(id);
        System.out.println("shiming ddd ddd "+id);
        // 感觉直接走的就是 500.html
       throw new RuntimeException(id);
    }
}
