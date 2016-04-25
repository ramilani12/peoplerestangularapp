package br.com.cinq.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cinq.sample.bean.Person;
import br.com.cinq.sample.service.IPeopleService;

@RestController
public class PeopleController {

	@Autowired
	@Qualifier("PeopleService")
	private IPeopleService peopleService;
	
	
	@RequestMapping(value = "/people", method = RequestMethod.GET)
	public ResponseEntity<List<Person>> listAllPersons() {
		List<Person> people = peopleService.findAll();
		
		if(people.isEmpty()){
			return new ResponseEntity<List<Person>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Person>>(people, HttpStatus.OK);
	}
	
}
