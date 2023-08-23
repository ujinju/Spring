package hello.Spring;

import hello.Spring.repository.MemberRepository;
import hello.Spring.repository.MemoryMemberRepository;
import hello.Spring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean // 스프링 빈에 등록하라는 뜻
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
