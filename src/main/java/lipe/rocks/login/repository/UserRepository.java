package lipe.rocks.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lipe.rocks.login.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByName(String name);

}
