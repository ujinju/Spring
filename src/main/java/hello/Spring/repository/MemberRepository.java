package hello.Spring.repository;

import hello.Spring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id); //id로 회원을 찾는 것
    Optional<Member> findByName(String name); //name으로 회원을 찾는 것
    List<Member> findAll(); //저장된 모든 회원 리스트를 반환

    //Optional은 null을 감싸서 반환하는 것
}
