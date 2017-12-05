package lipe.rocks.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lipe.rocks.login.domain.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByDescription(String name);

}
