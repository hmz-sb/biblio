package ma.cigma.biblio.service;

import ma.cigma.biblio.entities.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Date;
import java.util.List;

public interface UserService {

    public List<User> getAllUsers();


    public List<User> getAllActiveUsers() ;

    public User getByUsername(String username);

    public User getById(Long id);

    public User addNew(User user) ;

    public User update(User user);

    public void delete(User user);

    public void delete(Long id);

    public UserDetails loadUserByUsername(String username);

    boolean existsByUsername(String username);
}
