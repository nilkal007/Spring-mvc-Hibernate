package com.scp.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.scp.spring.model.Person;
@Repository
public class PersoneDOAImpl implements PersonDAO {

	private static final Logger logger=LoggerFactory.getLogger(PersonDAO.class);
	private SessionFactory sFactory;
	
	public void setsFactory(SessionFactory sFactory) {
		this.sFactory = sFactory;
	}

	@Override
	public void addPerson(Person p) {
	Session session =this.sFactory.getCurrentSession();
	session.persist(p);
	logger.info("Person saved successfully, Person Details="+p);
		
	}

	@Override
	public void updatePerson(Person p) {
		Session session=this.sFactory.getCurrentSession();
		session.update(p);
		logger.info("Person supdate successfully, Person Details="+p);
	
	}

	@Override
	public List<Person> listOfPersone() {
		Session session = this.sFactory.getCurrentSession();
		List<Person> personlList=session.createQuery("from Person").list();
		for (Person person : personlList) {
			logger.info("Person List::"+person);
		}
		return personlList;
	}

	@Override
	public Person getPersonById(int id) {
		Session session=this.sFactory.getCurrentSession();
		Person p=session.load(Person.class,new Integer(id));
		logger.info("Person loaded successfully, Person details="+p);
		return p;
	}

	@Override
	public void removePersone(int id) {
		Session session=this.sFactory.getCurrentSession();
		Person p=session.load(Person.class, new Integer(id));
		if (p!=null) {
			session.delete(p);
		}
		logger.info("Person deleted successfully, person details="+p);
		
	}

}
