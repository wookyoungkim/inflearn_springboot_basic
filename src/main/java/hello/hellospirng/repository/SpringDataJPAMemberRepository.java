package hello.hellospirng.repository;

import hello.hellospirng.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
// SpringDataJPA가 자동으로 빈 등록해줌
public interface SpringDataJPAMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    @Override
    Optional<Member> findByName(String name);
}
