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
	BankDAO transaction;

	/****************** OPERATIONS ON transactionS ******************************************/
	

	@RequestMapping(value="/transactions", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<Bank>> gettransactions(@RequestParam(value="name",required=false) String id_transaction){
		List<Bank> transactionList;
		transactionList = transaction.findAll();
		return new ResponseEntity<>(transactionList, HttpStatus.OK);
	}
	
	// Get transactions by name - with the parameter in the path
	@RequestMapping(value="/transactions/id/{transaction_id}",  method = RequestMethod.GET)
	public @ResponseBody Bank get1transactionById(@PathVariable long transaction_id){
		//return daous.findByName(name);
		return transaction.findById(transaction_id);
		}
	
	
	// Delete a transaction
	@RequestMapping(value="/delete/{transaction_id}", method = RequestMethod.DELETE)
	public @ResponseBody ResponseEntity<Bank> deletetransaction(@PathVariable @Validated Long transaction_id) {
		ResponseEntity<Bank> response;
		Bank us = transaction.findById(transaction_id).orElse(null);
		if (us == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			transaction.delete(us);
			response = new ResponseEntity<>(HttpStatus.OK);
		}
		return response;
	}
	
	// Save a transaction
	@RequestMapping(value="/transactions", method=RequestMethod.POST)
	public ResponseEntity<Bank> savetransaction(@RequestBody Bank ptransaction){
		ResponseEntity<Bank> response;
		Bank newtransaction = transaction.save(ptransaction);
		if (newtransaction == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			response = new ResponseEntity<>(newtransaction, HttpStatus.CREATED);
		}
		return response;
	}
	/*
	
	// Get transactions by email - with the parameter in the path
	@RequestMapping(value="/login/{email}", method = RequestMethod.GET)
	public @ResponseBody transaction get1transactionByEmail(@PathVariable String email){
		//return daous.findByName(name);
		return transaction.findTop1ByEmail(email);
	}
	
	// Get transactions by name and surname - with the parameters in the path
	@RequestMapping(value="/transactions/{name}/{surname}",  method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<transaction>> gettransactionByNameAndSurname(@PathVariable String name,
											  @PathVariable String surname){
		return new ResponseEntity<>(transaction.findByNameAndSurname(name, surname), HttpStatus.OK);
	}
	
	// Get transactions by name - with the parameter in the path
	@RequestMapping(value="/transactions/owner/{owner}",  method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<Bank>> gettransactionsByOwner(@PathVariable String owner){
		//return daous.findByName(name);
		List<Bank> us;
		us = transaction.findByOwner(owner);
		return new ResponseEntity<>(us, HttpStatus.OK);
	}
	
	// Get transactions by name - with the parameter in the path
	@RequestMapping(value="/transactions/category/{category}",  method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<Bank>> gettransactionsByCategory(@PathVariable String category){
		//return daous.findByName(name);
		List<Bank> us;
		us = transaction.findByCategory(category);
		return new ResponseEntity<>(us, HttpStatus.OK);
	}
	*/	
}
	




