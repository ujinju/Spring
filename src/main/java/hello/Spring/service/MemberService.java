package hello.Spring.service;

import hello.Spring.domain.Member;
import hello.Spring.repository.MemberRepository;
import hello.Spring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository){ // memberRepository를 외부에서 넣어주도록 함
        this.memberRepository = memberRepository;
    }
    public Long join(Member member){ //회원가입
       //같은 이름이 있는 중복 회원 X

        validateDuplicateMember(member); // 중복 회원 검증

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    public List<Member> findMembers(){ // 전체 회원 조회
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
