package ma.cigma.biblio.service.impl;


import ma.cigma.biblio.entities.Role;
import ma.cigma.biblio.entities.User;
import ma.cigma.biblio.mapping.UserMapping;
import ma.cigma.biblio.repository.UserRepository;
import ma.cigma.biblio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserMapping userMapping;

	private BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();

	
	public List<User> getAllUsers() {
		return userRepository.findAllByOrderByDisplayNameAsc();
	}
	
	public List<User> getAllActiveUsers() { return
		userRepository.findAllByActiveOrderByDisplayNameAsc(1);
	}
	
	public User getByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	public User getById(Long id) {
		return userRepository.findById(id).get();
	}
	
	public User addNew(User user) {
		user.setPassword( passwordEncoder.encode(user.getPassword()) );
		user.setCreatedDate( new Date() );
		user.setLastModifiedDate( user.getCreatedDate() );
		user.setActive(1);
		return userRepository.save(user);
	}
	
	public User update(User user) {
		user.setLastModifiedDate( new Date() );
		return userRepository.save( user );
	}
	
	public void delete(User user) {
		userRepository.delete(user);
	}
	
	public void delete(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),getAuthorities(user.getRoles()));
	}
	private Collection<? extends GrantedAuthority> getAuthorities(List<Role> roles) {
		List<GrantedAuthority> springSecurityAuthorities = new ArrayList<>();
		roles.forEach(r -> springSecurityAuthorities.add(new SimpleGrantedAuthority(r.getRole())));
		return springSecurityAuthorities;
	}

	public boolean existsByUsername(String username) {
		return userRepository.existsByUsername(username);
	}



}
