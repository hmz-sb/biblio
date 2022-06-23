package ma.cigma.biblio.service.impl;


import ma.cigma.biblio.common.Constants;
import ma.cigma.biblio.entities.Member;
import ma.cigma.biblio.mapping.MemberMapping;
import ma.cigma.biblio.repository.MemberRepository;
import ma.cigma.biblio.service.impl.IssueServiceImpl;
import ma.cigma.biblio.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private IssueServiceImpl issueService;

	@Autowired
	private MemberMapping memberMapping;
	
	public Long getTotalCount() {
		return memberRepository.count();
	}
	
	public Long getParentsCount() {
		return memberRepository.countByType(Constants.MEMBER_PARENT);
	}
	
	public Long getStudentsCount() {
		return memberRepository.countByType(Constants.MEMBER_STUDENT);
	}
	
	public List<Member> getAll() {
		return memberRepository.findAllByOrderByFirstNameAscMiddleNameAscLastNameAsc();
	}
	
	public Member get(Long id) {
		return memberRepository.findById(id).get();
	}
	
	public Member addNew(Member member) {
		member.setJoiningDate( new Date() );
		return memberRepository.save( member );
	}
	
	public Member save(Member member) {
		return memberRepository.save( member );
	}
	
	public void delete(Member member) {
		memberRepository.delete(member);
	}
	
	public void delete(Long id) {
		memberRepository.deleteById(id);
	}
	
	public boolean hasUsage(Member member) {
		return issueService.getCountByMember(member) > 0;
	}
	
}
