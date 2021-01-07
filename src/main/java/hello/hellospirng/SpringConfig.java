package hello.hellospirng;

import hello.hellospirng.repository.MemberRepository;
import hello.hellospirng.repository.MemoryMemberRepository;
import hello.hellospirng.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    //스프링 빈에 등록하라는 어노테이션
    // 뜰때 -> 멤버 서비스와 멤버 리포지토리 둘다 컨테이너에 등록
    // 스프링 빈 등록되어 있는 멤버 리포지토리를 서비스에 넣어줌
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
