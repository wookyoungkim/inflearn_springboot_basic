package hello.hellospirng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    //우선순위 : 요청시에 1.스프링 컨테이너 안에서 관련 컨트롤러 찾기 2. resources에서 html 파일 찾기
    @GetMapping("/")
    public String home(){
        return "home";
    }
}
