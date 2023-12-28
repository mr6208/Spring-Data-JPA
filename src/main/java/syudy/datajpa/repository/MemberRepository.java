package syudy.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import syudy.datajpa.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

}
