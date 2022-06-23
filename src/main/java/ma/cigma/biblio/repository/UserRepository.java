package ma.cigma.biblio.repository;

import ma.cigma.biblio.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
     List<User> findAllByOrderByDisplayNameAsc();
     List<User> findAllByActiveOrderByDisplayNameAsc(Integer active);
     User findByUsername(String username);
    boolean existsByUsername(String username);
}
