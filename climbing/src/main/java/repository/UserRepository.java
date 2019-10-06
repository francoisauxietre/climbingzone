package repository;

import com.escalade.demo.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findAllByName(String name);
    List<User> findAllByFirstName(String firstName);
    User findByNameAndFirstName(String name, String firstName);
    List<User> findAllByNameAndFirstName(String name, String firstName);
    List<User> findAllFriendsListByNameAndFirstName(String name, String firstName);
    List<User> findAll();
    Optional<User> findById(Long id);

    void deleteUserByNameAndFirstName(String name, String firstName);
    void deleteUserByName(String name);
    void deleteUserById(Long id);




}
