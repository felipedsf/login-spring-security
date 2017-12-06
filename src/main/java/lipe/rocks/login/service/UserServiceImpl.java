package lipe.rocks.login.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import lipe.rocks.login.domain.User;
import lipe.rocks.login.repository.RoleRepository;
import lipe.rocks.login.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	private RoleRepository roleRepository;

	public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}

	@Override
	public User save(User user) {
		user.setRole(roleRepository.findByDescription("user"));
		user.setCreatedDate(new Date());
		return userRepository.save(user);
	}

	@Override
	public User getUserByName(String username) {
		User userSaved = userRepository.findByName(username);
		return userSaved;
	}

}
