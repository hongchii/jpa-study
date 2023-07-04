package jpabook.jpashopweb.service;

import jpabook.jpashopweb.domain.Member;
import jpabook.jpashopweb.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true) //읽기전용
@RequiredArgsConstructor //생성자
public class MemberService {

    private final MemberRepository memberRepository;

    //회원가입
    @Transactional //회원가입은 읽기전용을 쓰면 안돼서 따로 @Transactional을 추가해준다.
    public Long join(Member member) {
        validateDuplicateMemeber(member); //중복회원검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMemeber(Member member) {
        //exception
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    //회원 전체 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }
}
