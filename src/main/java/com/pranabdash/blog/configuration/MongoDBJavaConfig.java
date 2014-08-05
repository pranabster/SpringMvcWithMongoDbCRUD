package com.pranabdash.blog.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ReadPreference;
import com.mongodb.WriteConcern;

@Configuration
@PropertySource(value="classpath:MongoDBConfig.properties")
public class MongoDBJavaConfig {
	
	@Value("${mongo.datasource.host}")
	private String host;

	@Value("${mongo.datasource.maxPoolSize}")
	private int maxPoolSize;
	
	@Value("${mongo.datasource.connectTimeout}")
	private int connectTimeout;
	
	private final ReadPreference readPreference = ReadPreference.secondaryPreferred();
	
	private final WriteConcern writeConcern = WriteConcern.ACKNOWLEDGED;

	private final String PERSONS_COLLECTION_DB = "PersonsCollectionDB";

	public @Bean MongoTemplate mongoTemplate() throws Exception {
		return new MongoTemplate(mongoDbFactory());
	}

	public @Bean MongoDbFactory mongoDbFactory() throws Exception {
		return new SimpleMongoDbFactory(new MongoClient(host, getMongoClientOptions()), PERSONS_COLLECTION_DB);
	}

	private MongoClientOptions getMongoClientOptions() {
		return MongoClientOptions.builder().connectionsPerHost(maxPoolSize)
				.connectTimeout(connectTimeout).readPreference(readPreference)
				.writeConcern(writeConcern).build();
	}

}
