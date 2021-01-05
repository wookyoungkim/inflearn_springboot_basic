package hello.hellospirng.service;

import hello.hellospirng.domain.Member;
import hello.hellospirng.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;


class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }


    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void 회원가입() {
        //given -> 검증 데이터
        Member member = new Member();
        member.setName("Spring");

        //when -> 검증하려는 것
        Long saveId = memberService.join(member);

        //then -> 검증하는 부분
        Member findMember = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());

    }
    @Test
    void 중복회원예외 () {
        //given
        Member member1 = new Member();
        member1.setName("Spring");

        Member member2 = new Member();
        member2.setName("Spring");

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        //then
        Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

//        memberService.join(member1);
        //then
//        try {
//            memberService.join(member2); //두번째 조인시에 예외가 발생해야
//            fail();
//        } catch (IllegalStateException e) {
//            //예외가 정상적으로 발생한 경우
//            Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }

    }
    @Test
    void findMembers() {

    }

}