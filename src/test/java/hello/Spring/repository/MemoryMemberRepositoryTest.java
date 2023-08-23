package hello.Spring.repository;

import hello.Spring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.lang.invoke.CallSite;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest { //다른 곳에 갖다 쓸 것이 아니기 때문에 public으로 안해도 됨
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach //콜백 메서드(각 테스트 실행이 끝날 때마다 실행 됨)
    public void afterEach(){
        repository.clearStore(); //테스트 끝날 때마다 레퍼지토리를 지움
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get(); //Optional에서는 값을 꺼낼 때 get을 통해 할 수 있음
        assertThat(member).isEqualTo(result); // member가 result랑 똑같음
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
