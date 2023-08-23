package hello.Spring.repository;

import hello.Spring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>(); //key가 회원의 id이니까 Long으로 함. 값은 Member
    private static long sequence = 0L; //sequence는 0,1,2,... key값을 생성해주는 애

    @Override
    public Member save(Member member) {
        member.setId(++sequence); //setId할 때 시퀀스 값을 하나씩 올림
        store.put(member.getId(), member); //stroe에 저장. Map에 저장이 됨
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); //null이 반환될 가능성이 있음 -> 값이 null이어도 감싸서 반환
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream() //루프를 돌리는 것
                .filter(member -> member.getName().equals(name)) //member에서 getName이 파라미터에 넘어온 name과 같은지 비교
                .findAny(); //같은 경우에만 필터링이 되어 반환됨(하나라도 있으면 찾는 것)
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); //루프를 돌리기 편하기 위해 List를 많이 사용. values들이 Member임
    }

    public void clearStore(){
        store.clear();
    }
    //구현체
}
