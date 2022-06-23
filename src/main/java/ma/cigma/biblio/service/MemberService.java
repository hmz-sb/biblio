package ma.cigma.biblio.service;

import ma.cigma.biblio.common.Constants;
import ma.cigma.biblio.entities.Member;

import java.util.Date;
import java.util.List;

public interface MemberService {

    public Long getTotalCount();

    public Long getParentsCount();

    public Long getStudentsCount();

    public List<Member> getAll();

    public Member get(Long id);

    public Member addNew(Member member);

    public Member save(Member member);

    public void delete(Member member);

    public void delete(Long id);

    public boolean hasUsage(Member member);

}
