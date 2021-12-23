package tiw.clients.manage.domains;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;


public interface UserDAO extends CrudRepository<User, Long>{

	
	public List<User> findAll();
	public List<User> findByName(String name);
	public User findTop1ByName(String name);
	public User findTop1ByEmail(String email);
	public List<User> findByNameAndSurname(String name, String surname);
	public User deleteByEmail(String email);
	public User findTop1ByEmailAndPass(String email, String pass);
	
}
