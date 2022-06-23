package ma.cigma.biblio.repository;

import ma.cigma.biblio.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
     List<Member> findAllByOrderByFirstNameAscMiddleNameAscLastNameAsc();
     Long countByType(String type);
}
