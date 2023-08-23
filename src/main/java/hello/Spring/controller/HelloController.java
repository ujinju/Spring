package hello.Spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello") //hello라는 경로에 mapping되면 아래 메서드 실행
    public String hello(Model model){
        model.addAttribute("data", "hello!!"); //여기서 data는 ket, hello!!는 값(값은 바뀔 수 있음)
        return "hello"; //resources에 있는 hello를 찾아가서 랜더링 해라.(hello화면을 실행시켜라)
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){ //외부에서 파라미터를 받아옴
        model.addAttribute("name", name); //윗 줄에 파라미터를 받아줌. name은 key임
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody //http에서 바디 부분에 return 내용을 직접 넣겠다는 뜻
    public String helloString(@RequestParam("name") String name){
        return "hello " + name; //문자 반환
    }

    @GetMapping("hello-api")
    @ResponseBody //기본적으로 json으로 반환
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello; //객체 반환

    }
    static class Hello{
        private String name; //key는 name

        public String getName(){
            return name;
        }
        public void setName(String name){
            this.name = name;
        }
    }
}
