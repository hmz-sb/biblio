package ma.cigma.biblio.service;

import ma.cigma.biblio.common.Constants;
import ma.cigma.biblio.entities.Issue;
import ma.cigma.biblio.entities.Member;

import java.util.Date;
import java.util.List;

public interface IssueService {

    public List<Issue> getAll();

    public Issue get(Long id);

    public List<Issue> getAllUnreturned();

    public Issue addNew(Issue issue) ;

    public Issue save(Issue issue);

    public Long getCountByMember(Member member);
}
