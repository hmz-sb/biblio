package ma.cigma.biblio.repository;

import ma.cigma.biblio.entities.Issue;
import ma.cigma.biblio.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IssueRepository extends JpaRepository<Issue, Long> {
     List<Issue> findByReturned(Integer returned);
     Long countByMemberAndReturned(Member member, Integer returned);
}
