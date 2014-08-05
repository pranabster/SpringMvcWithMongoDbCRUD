package com.pranabdash.blog.service;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.pranabdash.blog.model.Person;

@Service
public class MongoPersonServiceImpl implements PersonService {
	
	private final Logger logger = LoggerFactory.getLogger(MongoPersonServiceImpl.class);
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	/* (non-Javadoc)
	 * @see com.pranabdash.blog.service.PersonService#addPerson(com.pranabdash.blog.model.Person)
	 */
	@Override
	public void addPerson(Person person) {
		
		logger.info("AaddPerson");
		
		if (!mongoTemplate.collectionExists(Person.class)) {
			mongoTemplate.createCollection(Person.class);
		}		
		person.setId(UUID.randomUUID().toString());
		mongoTemplate.insert(person, COLLECTION_NAME);
	}
	
	/* (non-Javadoc)
	 * @see com.pranabdash.blog.service.PersonService#listPerson()
	 */
	@Override
	public List<Person> listPerson() {
		logger.info("listPerson");
		return mongoTemplate.findAll(Person.class, COLLECTION_NAME);
	}
	
	/* (non-Javadoc)
	 * @see com.pranabdash.blog.service.PersonService#deletePerson(com.pranabdash.blog.model.Person)
	 */
	@Override
	public void deletePerson(Person person) {
		logger.info("deletePerson");
		mongoTemplate.remove(person, COLLECTION_NAME);
	}
	
	/* (non-Javadoc)
	 * @see com.pranabdash.blog.service.PersonService#updatePerson(com.pranabdash.blog.model.Person)
	 */
	@Override
	public void updatePerson(Person person) {
		logger.info("updatePerson");
		mongoTemplate.insert(person, COLLECTION_NAME);		
	}
}
