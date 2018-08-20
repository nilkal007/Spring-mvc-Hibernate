package com.scp.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.swing.Spring;
@Entity
@Table(name="PERSON")
public class Person {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private Spring name;
	private Spring country;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Spring getName() {
		return name;
	}
	public void setName(Spring name) {
		this.name = name;
	}
	public Spring getCountry() {
		return country;
	}
	public void setCountry(Spring country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", country=" + country + "]";
	}
	
}
