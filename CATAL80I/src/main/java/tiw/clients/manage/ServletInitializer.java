package tiw.clients.manage;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tiw.clients.manage.domains.*;

@Controller
@CrossOrigin
public class ServletInitializer {

	@Autowired
	ProductDAO product;

	/****************** OPERATIONS ON ProductS ******************************************/
	

	@RequestMapping(value="/products", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<Product>> getProducts(@RequestParam(value="name",required=false) String id_product){
		List<Product> ProductList;
		ProductList = product.findAll();
		return new ResponseEntity<>(ProductList, HttpStatus.OK);
	}
	
	// Get Products by name - with the parameter in the path
	@RequestMapping(value="/products/category/{category}",  method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<Product>> getProductsByCategory(@PathVariable String category){
		//return daous.findByName(name);
		List<Product> us;
		us = product.findByCategory(category);
		return new ResponseEntity<>(us, HttpStatus.OK);
	}
	
	// Get Products by name - with the parameter in the path
	@RequestMapping(value="/products/id/{product_id}",  method = RequestMethod.GET)
	public @ResponseBody Product get1ProductById(@PathVariable long product_id){
		//return daous.findByName(name);
		return product.findById(product_id);
		}
		
	// Get Products by name - with the parameter in the path
	@RequestMapping(value="/products/owner/{owner}",  method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<Product>> getProductsByOwner(@PathVariable String owner){
		//return daous.findByName(name);
		List<Product> us;
		us = product.findByOwner(owner);
		return new ResponseEntity<>(us, HttpStatus.OK);
	}
	
	// Update a Product
	@RequestMapping(value="/update/{product_id}", method = RequestMethod.PUT)
	public @ResponseBody ResponseEntity<Product> updateProduct(@PathVariable @Validated Long product_id, @RequestBody Product pProduct) {
		ResponseEntity<Product> response;
		//Optional<Product> us = daous.findById(id);
		Product us = product.findById(product_id).orElse(null);
		if (us == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			us.setId_product(pProduct.getId_product());
			us.setTitle(pProduct.getTitle());
			us.setCategory(pProduct.getCategory());
			us.setDescription(pProduct.getDescription());
			us.setImage(pProduct.getImage());
			us.setValue(pProduct.getValue());
			us.setOwner(pProduct.getOwner());
			us.setState(pProduct.getState());
			response = new ResponseEntity<>(product.save(us), HttpStatus.OK);
		}
		return response;
	}
	
	// Delete a Product
	@RequestMapping(value="/delete/{product_id}", method = RequestMethod.DELETE)
	public @ResponseBody ResponseEntity<Product> deleteProduct(@PathVariable @Validated Long product_id) {
		ResponseEntity<Product> response;
		Product us = product.findById(product_id).orElse(null);
		if (us == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			product.delete(us);
			response = new ResponseEntity<>(HttpStatus.OK);
		}
		return response;
	}
	
	// Save a Product
	@RequestMapping(value="/Products", method=RequestMethod.POST)
	public ResponseEntity<Product> saveProduct(@RequestBody Product pProduct){
		ResponseEntity<Product> response;
		Product newProduct = product.save(pProduct);
		if (newProduct == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			response = new ResponseEntity<>(newProduct, HttpStatus.CREATED);
		}
		return response;
	}
	/*
	
	// Get Products by email - with the parameter in the path
	@RequestMapping(value="/login/{email}", method = RequestMethod.GET)
	public @ResponseBody Product get1ProductByEmail(@PathVariable String email){
		//return daous.findByName(name);
		return product.findTop1ByEmail(email);
	}
	
	// Get Products by name and surname - with the parameters in the path
	@RequestMapping(value="/Products/{name}/{surname}",  method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<Product>> getProductByNameAndSurname(@PathVariable String name,
											  @PathVariable String surname){
		return new ResponseEntity<>(product.findByNameAndSurname(name, surname), HttpStatus.OK);
	}
	*/	
}
	




