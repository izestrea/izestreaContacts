package izestreaContacts.repository;
//comment
import org.springframework.data.repository.CrudRepository;

import izestreaContacts.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	User findByEmail(String email);
}
