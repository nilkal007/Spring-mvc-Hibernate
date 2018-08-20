package com.scp.spring.service;

import java.util.List;

import com.scp.spring.model.Person;

public interface PersonService {

	public void addPerson(Person p);
	public void updatePersone(Person p);
	public List<Person> listOfPersons();
	public Person getPersonById(int id);
	public void removePerson(int id);
}
