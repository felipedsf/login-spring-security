package lipe.rocks.login.service;

import lipe.rocks.login.domain.User;

public interface UserService {

	User save(User user);

	User getUserByName(String username);

}
