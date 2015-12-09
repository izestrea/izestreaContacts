package izestreaContacts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import izestreaContacts.model.User;
import izestreaContacts.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
}
