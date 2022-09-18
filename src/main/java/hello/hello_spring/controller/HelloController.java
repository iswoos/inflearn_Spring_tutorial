package hello.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    //MVC방식

    // 바로 아래 GetMapping "hello"는 URL임
    @GetMapping("hello")
    // 스프링이 model을 하나 만들어서 넣어준다. 그 후 모델에다가 키/값을 넣는다
    public String hello(Model model){
        model.addAttribute("data","hello!!");
        // "hello" 이름을 가진 templates 내 파일로 간 후 실행시킨다는 의미
        // 그곳에 model 키/값들도 같이 넘김
        return "hello";
    }

    //MVC방식

    @GetMapping("hello-mvc")
    // http://localhost:8080/hello-mvc?name=spring!! 이라고 URL에 입력할 시,
    // Param을 통해 입력된 name값(spring!!)이 String name에 담기고
    // model에 담긴 뒤 hello-template 로 넘어감
    public String helloMvc(@RequestParam(value="name") String name, Model model){
        model.addAttribute("name",name);
        return "hello-template";
    }

    //API방식

    @GetMapping("hello-string")
    //아래 ResponseBody의 의미는, http body부에 return값을 직접 넣어주겠다는 의미임.
    @ResponseBody
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;
    }

    //API방식
    // 객체를 반환하는 방식
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
