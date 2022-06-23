package ma.cigma.biblio.service.impl;

import ma.cigma.biblio.mapping.BookMapping;
import ma.cigma.biblio.service.BookService;
import ma.cigma.biblio.service.CategoryService;
import ma.cigma.biblio.service.HomeService;
import ma.cigma.biblio.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class HomeServiceImpl implements HomeService {

	@Autowired
	private MemberServiceImpl memberService;
	
	@Autowired
	private CategoryServiceImpl categoryService;
	
	@Autowired
	private BookServiceImpl bookService;

	@Autowired
	private BookMapping bookMapping;
	
	public Map<String, Long> getTopTilesMap() {
		Map<String, Long> map = new HashMap<String, Long>();
		map.put("totalMembers", memberService.getTotalCount());
		map.put("totalStudents", memberService.getStudentsCount());
		map.put("totalParents", memberService.getParentsCount());
		map.put("totalCategories", categoryService.getTotalCount());
		map.put("totalBooks", bookService.getTotalCount());
		map.put("totalIssuedBooks", bookService.getTotalIssuedBooks());
		return map;
	}
	
}
