package com.scp.spring.dao;

import java.util.List;

import com.scp.spring.model.Person;

public interface PersonDAO {
	public void addPerson(Person p);
	public void updatePerson(Person p);
	public List<Person> listOfPersone();
	public Person getPersonById(int id);
	public void removePersone(int id);
	
}
