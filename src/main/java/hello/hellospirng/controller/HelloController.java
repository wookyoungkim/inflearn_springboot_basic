package hello.hellospirng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name", required = false) String name, Model model) {
        model.addAttribute("name", name);
        return "hello-templates";
    }

    //문자 반환
    @GetMapping("hello-string")
    @ResponseBody
    //http 통신시의 body 부분에 return되는 데이터 직접 넣어주는 annotation
    // ->view(html파일)없이 내가 리턴한 값 그대로 띄우기
    public String helloString(@RequestParam("name") String name){
        return "hello"+name;
    }

    //객체로 반환 -> /hello-api?name=spring시 json 으로 반환
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}