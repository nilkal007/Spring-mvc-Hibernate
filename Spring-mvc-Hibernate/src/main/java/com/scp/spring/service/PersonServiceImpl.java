package com.scp.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.scp.spring.dao.PersonDAO;
import com.scp.spring.model.Person;
@Service
public class PersonServiceImpl implements PersonService {

	private PersonDAO personDOA;
	
	
	public void setPersonDOA(PersonDAO personDOA) {
		this.personDOA = personDOA;
	}

	@Override
	@Transactional
	public void addPerson(Person p) {
		this.personDOA.addPerson(p);
		
	}

	@Override
	@Transactional
	public void updatePersone(Person p) {
		this.personDOA.updatePerson(p);
		
	}

	@Override
	@Transactional
	public List<Person> listOfPersons() {
		
		return this.personDOA.listOfPersone();
	}

	@Override
	@Transactional
	public Person getPersonById(int id) {
		
		return this.personDOA.getPersonById(id);
	}

	@Override
	@Transactional
	public void removePerson(int id) {
		this.personDOA.removePersone(id);
		
	}

}
