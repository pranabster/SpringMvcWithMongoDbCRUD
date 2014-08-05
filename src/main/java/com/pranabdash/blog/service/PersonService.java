package com.pranabdash.blog.service;

import java.util.List;

import com.pranabdash.blog.model.Person;

public interface PersonService {

	public static final String COLLECTION_NAME = "PersonsCollection";

	public abstract void addPerson(Person person);

	public abstract List<Person> listPerson();

	public abstract void deletePerson(Person person);

	public abstract void updatePerson(Person person);

}