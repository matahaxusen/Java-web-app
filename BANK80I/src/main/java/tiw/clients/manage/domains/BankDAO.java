package tiw.clients.manage.domains;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;


public interface BankDAO extends CrudRepository<Bank, Long>{

	
	public List<Bank> findAll();
	public Bank findById(long product_id);
	/*
	public List<Product> findByName(String name);
	public Product findTop1ByName(String name);
	public Product findTop1ByEmail(String email);
	public List<Product> findByNameAndSurname(String name, String surname);
	*/
	
}
