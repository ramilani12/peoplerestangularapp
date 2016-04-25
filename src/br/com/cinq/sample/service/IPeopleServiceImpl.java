package br.com.cinq.sample.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cinq.sample.bean.Person;

@Service("PeopleService")
@Transactional
public class IPeopleServiceImpl implements IPeopleService {

	public List<Person> findAll() {
		 
			Random rnd = new Random();
	        String[] name = { "Adam", "Abe", "Maria", "Rose", "Mario", "Luigi"};
	        String[] surname = { "Lincoln", "Franklin", "Jackson", "Miyazaki", "M'bebe"};
	        List<Person> list=new ArrayList<Person>();
	        
	        for(int i=0;i<10;i++) {
	            Person person = new Person();
	            person.setId(i);
	            person.setName(name[rnd.nextInt(name.length)] + " " + surname[rnd.nextInt(surname.length)]);
	            person.setDisclosableInfo("Lorem ipsum dolor sit amet, consectetur adipiscing elit," + 
	            "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad mini" +
	            "m veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo c"+
	            "onsequat.");
	            
	            list.add(person);
	        }
	        
	        return list;
		
	}

}
