package tiw.clients.manage.domains;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;


public interface ProductDAO extends CrudRepository<Product, Long>{

	
	public List<Product> findAll();
	public List<Product> findByCategory(String category);
	public Product findById(long product_id);
	public List<Product> findByOwner(String email);
	/*
	public List<Product> findByName(String name);
	public Product findTop1ByName(String name);
	public Product findTop1ByEmail(String email);
	public List<Product> findByNameAndSurname(String name, String surname);
	*/
	
}
