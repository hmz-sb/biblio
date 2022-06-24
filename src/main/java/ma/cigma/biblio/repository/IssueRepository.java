package ma.cigma.biblio.repository;

import ma.cigma.biblio.entities.Action;
import ma.cigma.biblio.entities.Book;
import ma.cigma.biblio.entities.Issue;
import ma.cigma.biblio.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IssueRepository extends JpaRepository<Issue, Long> {
     List<Issue> findByReturned(Integer returned);
     Long countByMemberAndReturned(Member member, Integer returned);
     List<Issue> ReserveBook (Book Title,Member member, Action RESERVE);
     List<Issue> BorrowBook (Book Title,Member member, Action BORROW);
     List<Issue> returnedBook (Issue returned);
     List<Issue> AllReserveBook (Book Title,Member member,Issue issueDate, Action RESERVE);
     List<Issue> AllBorrowBook (Book Title,Member member,Issue expectedReturnDate, Action BORROW);




}
