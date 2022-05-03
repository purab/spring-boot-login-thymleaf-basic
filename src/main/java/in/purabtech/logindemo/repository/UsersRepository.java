package in.purabtech.logindemo.repository;

import in.purabtech.logindemo.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long> {

    Optional<Users> findByLoginAndPassword(String login, String password);

}
