package hello.Spring.controller;

import hello.Spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired // 스프링 컨테이너가 멤버 서비스와 연결을 시켜줌
    public MemberController(MemberService memberService) { // 생성자 주입
        this.memberService = memberService;
    }
}
