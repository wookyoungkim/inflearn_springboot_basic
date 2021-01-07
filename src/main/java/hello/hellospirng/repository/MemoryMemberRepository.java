package hello.hellospirng.repository;

import hello.hellospirng.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    // 0,1,2등 키값 생성 -> 실무에서는 동시성 문제등을 고려해서 0L 사용 x
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId((++sequence));
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        // 요즘은 널이 반환될때의 처리를 Optional로 감싸서함
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        //java8의 람다
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}

